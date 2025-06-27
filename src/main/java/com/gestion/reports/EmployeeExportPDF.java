package com.gestion.reports;

import com.gestion.entity.Employee;
import com.lowagie.text.pdf.PdfTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeExportPDF {

    private List<Employee> employeeList;

    private void writeHeaderTable(PdfTable table) {

    }
}
