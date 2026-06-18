package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EXCEL2 {
    private static final String FILE_PATH = "src/lr10/resources/products.xlsx";

    public static void main(String[] args) {
        try {
            System.out.println("=== ЧТЕНИЕ ФАЙЛА ===");
            readExcel();

            System.out.println("\n=== ДОБАВЛЕНИЕ ТОВАРА ===");
            addProduct("Ноутбук", "Intel i7, 32GB RAM, 1TB SSD", 120000);

            System.out.println("\n=== ОБНОВЛЁННЫЙ СПИСОК ===");
            readExcel();
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
            System.err.println("Проверьте, что файл существует и не открыт в другой программе.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка формата: " + e.getMessage());
            System.err.println("Убедитесь, что лист 'Товары' существует в файле.");
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void readExcel() throws IOException {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet("Товары");
            if (sheet == null) {
                throw new IllegalArgumentException("Лист 'Товары' не найден!");
            }
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
        }
    }

    private static void addProduct(String name, String characteristics, double price) throws IOException {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet("Товары");
            if (sheet == null) {
                throw new IllegalArgumentException("Лист 'Товары' не найден!");
            }
            int lastRowNum = sheet.getLastRowNum();
            Row newRow = sheet.createRow(lastRowNum + 1);
            newRow.createCell(0).setCellValue(name);
            newRow.createCell(1).setCellValue(characteristics);
            newRow.createCell(2).setCellValue(price);

            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
                System.out.println("Товар добавлен: " + name);
            }
        }
    }
}
