package ro.ulbs.paradigme.lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class crearefisierxl {

    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Grades");

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle yellowItalicStyle = workbook.createCellStyle();
        Font italicFont = workbook.createFont();
        italicFont.setItalic(true);
        yellowItalicStyle.setFont(italicFont);
        yellowItalicStyle.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
        yellowItalicStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        String[] columns = {"Name", "Surname", "Grade 1", "Grade 2", "Grade 3", "Grade 4", "Max", "Average"};
        Row header = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerStyle);
        }

        Map<String, Object[]> data = new TreeMap<>();
        data.put("2", new Object[]{"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[]{"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[]{"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[]{"Brian", "Schultz", 7, 6, 8, 9});

        int rowNum = 1;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row = sheet.createRow(rowNum);
            Object[] values = entry.getValue();

            for (int i = 0; i < values.length; i++) {
                Cell cell = row.createCell(i);
                if (values[i] instanceof String) {
                    cell.setCellValue((String) values[i]);
                } else if (values[i] instanceof Integer) {
                    cell.setCellValue((Integer) values[i]);
                }
            }

            String formulaMax = String.format("MAX(C%d:F%d)", rowNum + 1, rowNum + 1);
            Cell cellMax = row.createCell(6);
            cellMax.setCellFormula(formulaMax);
            cellMax.setCellStyle(yellowItalicStyle);

            String formulaAvg = String.format("AVERAGE(C%d:F%d)", rowNum + 1, rowNum + 1);
            Cell cellAvg = row.createCell(7);
            cellAvg.setCellFormula(formulaAvg);
            cellAvg.setCellStyle(yellowItalicStyle);

            rowNum++;
        }

        // rand medie
        Row avgRow = sheet.createRow(rowNum);


        for (int col = 2; col <= 5; col++) { // Grade 1 - 4
            char colLetter = (char) ('A' + col);
            String formula = String.format("AVERAGE(%c2:%c%d)", colLetter, colLetter, rowNum);
            Cell cell = avgRow.createCell(col);
            cell.setCellFormula(formula);
        }

        String formulaMaxCol = String.format("AVERAGE(G2:G%d)", rowNum);
        Cell cellMaxCol = avgRow.createCell(6);
        cellMaxCol.setCellFormula(formulaMaxCol);
        cellMaxCol.setCellStyle(yellowItalicStyle);

        String formulaAvgCol = String.format("AVERAGE(H2:H%d)", rowNum);
        Cell cellAvgCol = avgRow.createCell(7);
        cellAvgCol.setCellFormula(formulaAvgCol);
        cellAvgCol.setCellStyle(yellowItalicStyle);

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream out = new FileOutputStream("grades.xlsx")) {
            workbook.write(out);
            workbook.close();
            System.out.println("Fișierul Excel 'grades.xlsx' a fost generat cu succes.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
