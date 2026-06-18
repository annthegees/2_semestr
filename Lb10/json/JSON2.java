package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class JSON2 {
    private static final String FILE_PATH = "src/lr10/resources/books.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- JSON КНИГИ ---");
            System.out.println("1. Показать все книги");
            System.out.println("2. Добавить книгу");
            System.out.println("3. Поиск по автору");
            System.out.println("4. Удалить книгу по названию");
            System.out.println("5. Выход");
            System.out.print("Выберите: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllBooks();
                case 2 -> addBook(scanner);
                case 3 -> searchByAuthor(scanner);
                case 4 -> deleteByTitle(scanner);
                case 5 -> {
                    System.out.println("До свидания!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private static JSONObject loadJSON() throws Exception {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(new FileReader(FILE_PATH));
    }

    private static void saveJSON(JSONObject obj) throws Exception {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(obj.toJSONString());
        }
    }

    private static void showAllBooks() {
        try {
            JSONObject obj = loadJSON();
            JSONArray books = (JSONArray) obj.get("books");
            System.out.println("\n=== ВСЕ КНИГИ ===");
            for (Object o : books) {
                JSONObject book = (JSONObject) o;
                System.out.println("Название: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год: " + book.get("year"));
                System.out.println("---");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addBook(Scanner scanner) {
        try {
            JSONObject obj = loadJSON();
            JSONArray books = (JSONArray) obj.get("books");
            JSONObject newBook = new JSONObject();
            System.out.print("Введите название: ");
            newBook.put("title", scanner.nextLine());
            System.out.print("Введите автора: ");
            newBook.put("author", scanner.nextLine());
            System.out.print("Введите год: ");
            newBook.put("year", Integer.parseInt(scanner.nextLine()));
            books.add(newBook);
            saveJSON(obj);
            System.out.println("Книга добавлена!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchByAuthor(Scanner scanner) {
        try {
            JSONObject obj = loadJSON();
            JSONArray books = (JSONArray) obj.get("books");
            System.out.print("Введите автора: ");
            String author = scanner.nextLine();
            boolean found = false;
            for (Object o : books) {
                JSONObject book = (JSONObject) o;
                if (author.equalsIgnoreCase((String) book.get("author"))) {
                    System.out.println("Найдена: " + book.get("title"));
                    found = true;
                }
            }
            if (!found) System.out.println("Книг автора \"" + author + "\" не найдено.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteByTitle(Scanner scanner) {
        try {
            JSONObject obj = loadJSON();
            JSONArray books = (JSONArray) obj.get("books");
            System.out.print("Введите название книги для удаления: ");
            String title = scanner.nextLine();
            Iterator<?> iterator = books.iterator();
            boolean deleted = false;
            while (iterator.hasNext()) {
                JSONObject book = (JSONObject) iterator.next();
                if (title.equalsIgnoreCase((String) book.get("title"))) {
                    iterator.remove();
                    deleted = true;
                    break;
                }
            }
            if (deleted) {
                saveJSON(obj);
                System.out.println("Книга удалена!");
            } else {
                System.out.println("Книга не найдена.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
