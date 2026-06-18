package xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;



public class XML1 {
    private static final String FILE_PATH = "src/lr10/resources/books.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- XML Книги ---");
            System.out.println("1. Показать все книги");
            System.out.println("2. Добавить книгу");
            System.out.println("3. Найти книги по автору");
            System.out.println("4. Найти книги по году");
            System.out.println("5. Удалить книгу по названию");
            System.out.println("6. Выход");
            System.out.print("Выберите: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllBooks();
                case 2 -> addBook(scanner);
                case 3 -> searchByAuthor(scanner);
                case 4 -> searchByYear(scanner);
                case 5 -> deleteBookByTitle(scanner);
                case 6 -> { return; }
            }
        }
    }

    private static Document loadDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(FILE_PATH));
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    private static void showAllBooks() {
        try {
            Document doc = loadDocument();
            NodeList books = doc.getElementsByTagName("book");
            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);
                System.out.println("Название: " + book.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Автор: " + book.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Год: " + book.getElementsByTagName("year").item(0).getTextContent());
                System.out.println("---");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addBook(Scanner scanner) {
        try {
            Document doc = loadDocument();
            Element library = doc.getDocumentElement();

            Element newBook = doc.createElement("book");
            Element title = doc.createElement("title");
            title.setTextContent(scanner.nextLine());
            Element author = doc.createElement("author");
            author.setTextContent(scanner.nextLine());
            Element year = doc.createElement("year");
            year.setTextContent(scanner.nextLine());

            newBook.appendChild(title);
            newBook.appendChild(author);
            newBook.appendChild(year);
            library.appendChild(newBook);

            saveDocument(doc);
            System.out.println("Книга добавлена!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchByAuthor(Scanner scanner) {
        try {
            Document doc = loadDocument();
            NodeList books = doc.getElementsByTagName("book");
            String searchAuthor = scanner.nextLine();
            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);
                String author = book.getElementsByTagName("author").item(0).getTextContent();
                if (author.equalsIgnoreCase(searchAuthor)) {
                    System.out.println("Найдено: " + book.getElementsByTagName("title").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchByYear(Scanner scanner) {
        try {
            Document doc = loadDocument();
            NodeList books = doc.getElementsByTagName("book");
            String searchYear = scanner.nextLine();
            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);
                String year = book.getElementsByTagName("year").item(0).getTextContent();
                if (year.equals(searchYear)) {
                    System.out.println("Найдено: " + book.getElementsByTagName("title").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteBookByTitle(Scanner scanner) {
        try {
            Document doc = loadDocument();
            NodeList books = doc.getElementsByTagName("book");
            String titleToDelete = scanner.nextLine();
            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);
                String title = book.getElementsByTagName("title").item(0).getTextContent();
                if (title.equalsIgnoreCase(titleToDelete)) {
                    book.getParentNode().removeChild(book);
                    saveDocument(doc);
                    System.out.println("Книга удалена!");
                    return;
                }
            }
            System.out.println("Книга не найдена.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
