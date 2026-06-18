import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class HTML2 {
    private static final String URL = "http://fat.urfu.ru/index.html";
    private static final String OUTPUT_FILE = "src/lr10/resources/news.txt";
    private static final int MAX_RETRIES = 3;

    public static void main(String[] args) {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                System.out.println("Попытка " + attempt + " подключения к " + URL);
                Document doc = Jsoup.connect(URL).get();
                Elements newsItems = doc.select(".news-item"); // селектор может отличаться

                try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
                    for (Element item : newsItems) {
                        String title = item.select(".news-title").text();
                        String date = item.select(".news-date").text();
                        String line = "Тема: " + title + " | Дата: " + date + "\n";
                        System.out.print(line);
                        writer.write(line);
                    }
                }
                System.out.println("\nДанные успешно сохранены в " + OUTPUT_FILE);
                return; // успех – выходим
            } catch (IOException e) {
                System.err.println("Ошибка подключения: " + e.getMessage());
                if (attempt == MAX_RETRIES) {
                    System.err.println("Не удалось подключиться после " + MAX_RETRIES + " попыток.");
                } else {
                    System.out.println("Повторная попытка через 3 секунды...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
