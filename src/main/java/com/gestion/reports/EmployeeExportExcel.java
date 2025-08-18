package com.gestion.reports;

import com.gestion.entity.Employee;
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
}
