package com.gestion.reports;

import com.gestion.entity.Employee;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class EmployeeExportExcel {

    private XSSFWorkbook book;
    private XSSFSheet paper;

    private List<Employee> employeeList;

    public EmployeeExportExcel(List<Employee> employeeList) {
        this.employeeList = employeeList;
        book = new XSSFWorkbook();
        paper = book.createSheet("Empleados");
    }

    private void writeHeaderTable() {
        Row row = paper.createRow(0);

        CellStyle cellStyle = book.createCellStyle();
        XSSFFont font = book.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        cellStyle.setFont(font);

        Cell cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(1);
        cell.setCellValue("Nombre");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(2);
        cell.setCellValue("Apellido");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(3);
        cell.setCellValue("Email");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(4);
        cell.setCellValue("Fecha");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(5);
        cell.setCellValue("Telefono");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(6);
        cell.setCellValue("Sexo");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(7);
        cell.setCellValue("Salario");
        cell.setCellStyle(cellStyle);
    }

    private void writeDataTable() {
        int rowNumber = 1;

        CellStyle style = book.createCellStyle();
        XSSFFont font = book.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Employee employee: employeeList) {
            Row row = paper.createRow(rowNumber ++);

            Cell cell = row.createCell(0);
            cell.setCellValue(employee.getId());
            paper.autoSizeColumn(0);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(employee.getName());
            paper.autoSizeColumn(1);
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(employee.getLastName());
            paper.autoSizeColumn(2);
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(employee.getEmail());
            paper.autoSizeColumn(3);
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(employee.getDate().toString());
            paper.autoSizeColumn(4);
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue(employee.getPhone());
            paper.autoSizeColumn(5);
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue(employee.getSex());
            paper.autoSizeColumn(6);
            cell.setCellStyle(style);

            cell = row.createCell(7);
            cell.setCellValue(employee.getSalary());
            paper.autoSizeColumn(7);
            cell.setCellStyle(style);
        }
    }

    public void exportExcel(HttpServletResponse response) throws IOException {
        writeHeaderTable();
        writeDataTable();

        ServletOutputStream outputStream = response.getOutputStream();
        book.write(outputStream);

        book.close();
        outputStream.close();
    }
}
