package com.gestion.reports;

import com.gestion.entity.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;

public class EmployeeExportExcel {

    private XSSFWorkbook book;
    private XSSFSheet paper;

    private List<Employee> employeeList;

    public EmployeeExportExcel(XSSFWorkbook book, XSSFSheet paper, List<Employee> employeeList) {
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
    }
}
