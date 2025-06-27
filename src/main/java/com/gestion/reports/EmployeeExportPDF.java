package com.gestion.reports;

import com.gestion.entity.Employee;
import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.Font;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.awt.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeExportPDF {

    private List<Employee> employeeList;

    private void writeHeaderTable(PdfTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.RED);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
    }
}
