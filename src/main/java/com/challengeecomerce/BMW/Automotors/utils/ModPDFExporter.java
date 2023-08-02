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
import java.util.Set;

public class ModPDFExporter {

    private  List<Mod> mods;

    private Client client;

    private Integer quantity;

    private Set<ClientPurchase> clientPurchaseSet;

    private double finalPrice;

    private Double amount;

    public ModPDFExporter(List<Mod> mods, Client client, double finalPrice, Double amount ) {
        this.mods = mods;
        this.client = client;
        this.finalPrice = finalPrice;
        this.amount = amount;
    }




    private void writeTableHeader (PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.WHITE);
        cell.setPadding(1);

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

    }

        private void writeTableData(PdfPTable table) {
            mods.forEach(mod -> {
                table.addCell(String.valueOf(mod.getId()));
                table.addCell(String.valueOf(mod.getName()));
                table.addCell(String.valueOf(mod.getPrice()));
                table.addCell(String.valueOf(mod.getCarColor()));
            });
        }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(BaseColor.DARK_GRAY);

        Paragraph paragraphClient = new Paragraph ("Client" + client.getFirstName() + " " + client.getLastName() + " " + client.getPhone(), font);
        Paragraph finalPriceParagraph = new Paragraph ("Final Price" + finalPrice, font);
        Paragraph amountParagraph = new Paragraph ("Total Amount" + amount, font);

        Paragraph p = new Paragraph("Mod's list", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable modTable = new PdfPTable(4);
        modTable.setWidthPercentage(100f);
        modTable.setWidths(new float[]{1.5f, 3.5f, 3.0f, 3.0f});
        modTable.setSpacingBefore(10);

        writeTableHeader(modTable);
        writeTableData(modTable);

        document.add(paragraphClient);
        document.add(finalPriceParagraph);
        document.add(amountParagraph);
        document.add(modTable);

//        // Mod Purchase Title
//        Paragraph p2 = new Paragraph("Mod's Purchase", font);
//        p2.setAlignment(Paragraph.ALIGN_CENTER);
//        document.add(p2);
//
//        PdfPTable modPurchaseTable = new PdfPTable(4);
//        modPurchaseTable.setWidthPercentage(100f);
//        modPurchaseTable.setWidths(new float[]{1.5f, 3.5f, 3.0f});
//        modPurchaseTable.setSpacingBefore(10);
//
//
//        // HEADER Mod Purchase
//        PdfPCell cell = new PdfPCell();
//        cell.setBackgroundColor(BaseColor.GREEN);
//        cell.setPadding(1);
//        cell.setPhrase(new Phrase("ID"));
//        modPurchaseTable.addCell(cell);
//
//        cell.setPhrase(new Phrase("Quantity"));
//        modPurchaseTable.addCell(cell);
//
//        cell.setPhrase(new Phrase("Purchase Date"));
//        modPurchaseTable.addCell(cell);

//        // Mod Purchase Cells
//        private void writeTableData(PdfPTable PdfPTable table;
//        table) {
//            modsPurchaseTable.forEach(mod -> {
//                table.addCell(String.valueOf(mod.getId()));
//                table.addCell(String.valueOf(mod.getName()));
//                table.addCell(String.valueOf(mod.getPrice()));
//                table.addCell(mod.getDescription());
//                table.addCell(String.valueOf(mod.getCarColor()));
//            });
//        }


//        document.add(modPurchaseTable);



//        // TITULO CLIENT
//        Paragraph p3 = new Paragraph("Client Details", font);
//        p3.setAlignment(Paragraph.ALIGN_CENTER);
//        document.add(p3);
//
//        PdfPTable clientTable = new PdfPTable(3);
//        clientTable.setWidthPercentage(100f);
//        clientTable.setWidths(new float[]{1.5f, 3.5f, 3.0f});
//        clientTable.setSpacingBefore(10);
//
//        // HEADER TABLA ACCOUNT
//        PdfPCell cellClient = new PdfPCell();
//        cellClient.setBackgroundColor(BaseColor.GREEN);
//        cellClient.setPadding(1);
//        cellClient.setPhrase(new Phrase("Name"));
//        clientTable.addCell(cellClient);
//
//        cellClient.setPhrase(new Phrase("Last Name"));
//        clientTable.addCell(cellClient);
//
//        cellClient.setPhrase(new Phrase("Email"));
//        clientTable.addCell(cellClient);
//
//        // CELDAS ACCOUNT
//        clientTable.addCell(String.valueOf(client.getFirstName()));
//        clientTable.addCell(String.valueOf(client.getLastName()));
//        clientTable.addCell(String.valueOf(client.getEmail()));
//
//
//        document.add(clientTable);



        document.close();
    }

    }
