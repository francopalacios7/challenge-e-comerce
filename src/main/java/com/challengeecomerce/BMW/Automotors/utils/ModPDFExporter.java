package com.challengeecomerce.BMW.Automotors.utils;

import com.challengeecomerce.BMW.Automotors.models.*;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ModPDFExporter {

    private List<Mod> mods;
    private Client client;
    private double finalPrice;
    private int amount;

    public ModPDFExporter(List<Mod> mods, Client client, double finalPrice, int amount) {
        this.mods = mods;
        this.client = client;
        this.finalPrice = finalPrice;
        this.amount = amount;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.BLACK);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Color", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Final Price", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Purchased Mods", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.BLACK);

        for (Mod mod : mods) {
            table.addCell(new Phrase(String.valueOf(mod.getId()), font));
            table.addCell(new Phrase(String.valueOf(mod.getName()), font));
            table.addCell(new Phrase(String.valueOf(mod.getPrice()), font));
            table.addCell(new Phrase(String.valueOf(mod.getCarColor()), font));
            table.addCell(new Phrase(String.valueOf(finalPrice), font));
            table.addCell(new Phrase(String.valueOf(amount), font));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Image logoImage = Image.getInstance("https://1000marcas.net/wp-content/uploads/2019/12/BMW-logo.png");
        logoImage.setAlignment(Element.ALIGN_CENTER);
        logoImage.scalePercent(10); //
        document.add(logoImage);


        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(BaseColor.DARK_GRAY);


        // Client Details table
        Paragraph p3 = new Paragraph("Client Details", font);
        p3.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p3);

        PdfPTable clientTable = new PdfPTable(5); //
        clientTable.setWidthPercentage(100f);
        clientTable.setWidths(new float[]{1.5f, 2.5f, 2.0f, 2.0f, 2.0f}); // Ancho de cada columna
        clientTable.setSpacingBefore(10);

        // HEADER TABLA CLIENT DETAILS
        PdfPCell cellClient = new PdfPCell();
        cellClient.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cellClient.setPadding(5);
        cellClient.setPhrase(new Phrase("First Name", font)); // Encabezado columna 1
        clientTable.addCell(cellClient);

        cellClient.setPhrase(new Phrase("Last Name", font)); // Encabezado columna 2
        clientTable.addCell(cellClient);

        cellClient.setPhrase(new Phrase("Email", font)); // Encabezado columna 3
        clientTable.addCell(cellClient);

        // Nuevos encabezados
        cellClient.setPhrase(new Phrase("Delivery Address", font)); // Encabezado columna 4
        clientTable.addCell(cellClient);

        cellClient.setPhrase(new Phrase("Phone", font)); // Encabezado columna 5
        clientTable.addCell(cellClient);


        // CELDAS CLIENT DETAILS
        clientTable.addCell(String.valueOf(client.getFirstName()));
        clientTable.addCell(String.valueOf(client.getLastName()));
        clientTable.addCell(String.valueOf(client.getEmail()));

        // Nuevas celdas
        clientTable.addCell(String.valueOf(client.getAddress()));
        clientTable.addCell(String.valueOf(client.getPhone()));

        document.add(clientTable);

        // Mod Purchase Table
        Paragraph p = new Paragraph("Purchased Mods", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);

        PdfPTable modTable = new PdfPTable(6);
        modTable.setWidthPercentage(100f);
        modTable.setWidths(new float[]{1.5f, 3.5f, 3.0f, 3.0f, 3.0f, 3.0f});
        modTable.setSpacingBefore(10);

        writeTableHeader(modTable);
        writeTableData(modTable);

        document.add(modTable);


        document.close();
    }
}