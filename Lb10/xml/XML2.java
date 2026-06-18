package xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

public class XML2 {
    private static final String FILE_PATH = "books.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- XML Парсер (Книги) ---");
            System.out.println("1. Показать все книги");
            System.out.println("2. Добавить книгу");
            System.out.println("3. Найти книги по автору");
            System.out.println("4. Найти книги по году");
            System.out.println("5. Удалить книгу по названию");
            System.out.println("6. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllBooks();
                case 2 -> addBook(scanner);
                case 3 -> searchByAuthor(scanner);
                case 4 -> searchByYear(scanner);
                case 5 -> deleteBookByTitle(scanner);
                case 6 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    // Чтение XML документа
    private static Document getDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(FILE_PATH));
    }

    // Сохранение XML документа
    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
        System.out.println("Файл успешно обновлён!");
    }

    // 1. Показать все книги
    private static void showAllBooks() {
        try {
            Document doc = getDocument();
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element book = (Element) nodeList.item(i);
                System.out.println("\nКнига " + (i + 1) + ":");
                System.out.println("  Название: " + book.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("  Автор: " + book.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("  Год: " + book.getElementsByTagName("year").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Добавить книгу
    private static void addBook(Scanner scanner) {
        try {
            System.out.print("Введите название книги: ");
            String title = scanner.nextLine();
            System.out.print("Введите автора: ");
            String author = scanner.nextLine();
            System.out.print("Введите год издания: ");
            String year = scanner.nextLine();

            Document doc = getDocument();
            Element root = doc.getDocumentElement();

            Element book = doc.createElement("book");
            Element titleElem = doc.createElement("title");
            titleElem.setTextContent(title);
            Element authorElem = doc.createElement("author");
            authorElem.setTextContent(author);
            Element yearElem = doc.createElement("year");
            yearElem.setTextContent(year);

            book.appendChild(titleElem);
            book.appendChild(authorElem);
            book.appendChild(yearElem);
            root.appendChild(book);

            saveDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Поиск по автору (Stream API)
    private static void searchByAuthor(Scanner scanner) {
        try {
            System.out.print("Введите автора для поиска: ");
            String searchAuthor = scanner.nextLine();

            Document doc = getDocument();
            NodeList nodeList = doc.getElementsByTagName("book");

            List<Element> books = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                books.add((Element) nodeList.item(i));
            }

            List<Element> found = books.stream()
                    .filter(book -> book.getElementsByTagName("author").item(0).getTextContent()
                            .equalsIgnoreCase(searchAuthor))
                    .collect(Collectors.toList());

            if (found.isEmpty()) {
                System.out.println("Книги не найдены.");
            } else {
                found.forEach(book -> {
                    System.out.println("\nНайдена книга:");
                    System.out.println("  Название: " + book.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("  Год: " + book.getElementsByTagName("year").item(0).getTextContent());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. Поиск по году
    private static void searchByYear(Scanner scanner) {
        try {
            System.out.print("Введите год издания: ");
            String searchYear = scanner.nextLine();

            Document doc = getDocument();
            NodeList nodeList = doc.getElementsByTagName("book");

            List<Element> books = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                books.add((Element) nodeList.item(i));
            }

            List<Element> found = books.stream()
                    .filter(book -> book.getElementsByTagName("year").item(0).getTextContent().equals(searchYear))
                    .collect(Collectors.toList());

            if (found.isEmpty()) {
                System.out.println("Книги не найдены.");
            } else {
                found.forEach(book -> {
                    System.out.println("\nНайдена книга:");
                    System.out.println("  Название: " + book.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("  Автор: " + book.getElementsByTagName("author").item(0).getTextContent());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5. Удаление книги по названию
    private static void deleteBookByTitle(Scanner scanner) {
        try {
            System.out.print("Введите название книги для удаления: ");
            String titleToDelete = scanner.nextLine();

            Document doc = getDocument();
            NodeList nodeList = doc.getElementsByTagName("book");
            boolean found = false;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element book = (Element) nodeList.item(i);
                String currentTitle = book.getElementsByTagName("title").item(0).getTextContent();
                if (currentTitle.equalsIgnoreCase(titleToDelete)) {
                    book.getParentNode().removeChild(book);
                    found = true;
                    break;
                }
            }

            if (found) {
                saveDocument(doc);
                System.out.println("Книга удалена!");
            } else {
                System.out.println("Книга не найдена.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
