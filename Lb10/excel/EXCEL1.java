package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EXCEL1 {
    private static final String FILE_PATH = "src/lr10/resources/products.xlsx";

    public static void main(String[] args) {
        try {
            readExcel();
            writeExcel();
        } catch (IOException e) {
            System.err.println("Ошибка работы с файлом: " + e.getMessage());
            System.err.println("Рекомендация: проверьте, что файл не открыт в Excel и путь корректен.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка формата: " + e.getMessage());
        }
    }

    private static void readExcel() throws IOException {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new IOException("Не удалось прочитать файл. Возможно, файл отсутствует или повреждён.", e);
        }
    }

    private static void writeExcel() throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Товары");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Название");
            header.createCell(1).setCellValue("Цена");
            header.createCell(2).setCellValue("Количество");

            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("Ноутбук");
            row1.createCell(1).setCellValue(75000);
            row1.createCell(2).setCellValue(10);

            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
                System.out.println("Excel файл создан/обновлён.");
            }
        } catch (IOException e) {
            throw new IOException("Ошибка записи в Excel файл.", e);
        }
    }
}
