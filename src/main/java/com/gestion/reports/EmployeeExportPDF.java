package com.gestion.reports;

import com.gestion.entity.Employee;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
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

    private void writeHeaderTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.RED);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nombre", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Apellido", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Fecha", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Telefono", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Sexo", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Salario", font));
        table.addCell(cell);
    }

    private void writeDataTable(PdfPTable table) {
        for (Employee employee : employeeList) {
            table.addCell(String.valueOf(employee.getId()));
            table.addCell(employee.getName());
            table.addCell(employee.getLastName());
            table.addCell(employee.getEmail());
            table.addCell(employee.getDate().toString());
            table.addCell(String.valueOf(employee.getPhone()));
            table.addCell(employee.getSex());
            table.addCell(String.valueOf(employee.getSalary()));
        }
    }

    public void export() {

    }
}
