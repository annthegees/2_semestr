package html;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
public class HTML1 {
    private static final String URL = "http://fat.urfu.ru/index.html";
    private static final String OUTPUT_FILE = "src/lr10/resources/news.txt";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements news = doc.select(".news-item"); // селектор может отличаться

            try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
                for (Element item : news) {
                    String title = item.select(".news-title").text();
                    String date = item.select(".news-date").text();
                    String line = "Тема: " + title + " | Дата: " + date + "\n";
                    System.out.print(line);
                    writer.write(line);
                }
            }
            System.out.println("\nДанные сохранены в " + OUTPUT_FILE);
        } catch (IOException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
            System.out.println("Попытка переподключения через 3 секунды...");
            try {
                Thread.sleep(3000);
                main(args); // рекурсивная попытка
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

}