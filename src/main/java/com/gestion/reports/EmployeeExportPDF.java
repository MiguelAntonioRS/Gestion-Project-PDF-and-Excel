package com.gestion.reports;

import com.gestion.entity.Employee;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeExportPDF {

    private List<Employee> employeeList;

    private void writeHeaderTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.BLACK);
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

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLACK);
        font.setSize(18);

        Paragraph title = new Paragraph("Lista de Empleados", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[] {1f, 2.3f, 2.3f, 6f, 2.9f, 3.5f, 2f, 2.2f});
        table.setWidthPercentage(110);

        writeHeaderTable(table);
        writeDataTable(table);

        document.add(table);
        document.close();
    }
}
