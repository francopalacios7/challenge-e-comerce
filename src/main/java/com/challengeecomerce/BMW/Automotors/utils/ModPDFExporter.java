package com.challengeecomerce.BMW.Automotors.utils;

import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.ModPurchase;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ModPDFExporter {

    private  List<Mod> mods;

    private Client client;

    private ModPurchase modPurchase;

    public ModPDFExporter(List<Mod> mods, Client client, ModPurchase modPurchase) {
        this.mods = mods;
        this.client = client;
        this.modPurchase = modPurchase;
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

        cell.setPhrase(new Phrase("Description", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Color", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Mod Type", font));
        table.addCell(cell);

    }

        private void writeTableData(PdfPTable table) {
            mods.forEach(mod -> {
                table.addCell(String.valueOf(mod.getId()));
                table.addCell(String.valueOf(mod.getName()));
                table.addCell(String.valueOf(mod.getPrice()));
                table.addCell(mod.getDescription());
                table.addCell(String.valueOf(mod.getCarColor()));
                table.addCell(String.valueOf(mod.getModType()));
            });
        }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(BaseColor.DARK_GRAY);

        Paragraph p = new Paragraph("List of Transactions", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable modTable = new PdfPTable(6);
        modTable.setWidthPercentage(100f);
        modTable.setWidths(new float[]{1.5f, 3.5f, 3.0f, 3.0f, 3.0f, 3.0f});
        modTable.setSpacingBefore(10);

        writeTableHeader(modTable);
        writeTableData(modTable);

        document.add(modTable);

//        // TITULO ACCOUNT
//        Paragraph p2 = new Paragraph("Details Of Account", font);
//        p2.setAlignment(Paragraph.ALIGN_CENTER);
//        document.add(p2);
//
//        PdfPTable accountTable = new PdfPTable(6);
//        accountTable.setWidthPercentage(100f);
//        accountTable.setWidths(new float[]{1.5f, 3.5f, 3.0f, 3.0f, 3.0f, 3.0f});
//        accountTable.setSpacingBefore(10);
//
//        // HEADER TABLA ACCOUNT
//        PdfPCell cell = new PdfPCell();
//        cell.setBackgroundColor(BaseColor.GREEN);
//        cell.setPadding(1);
//        cell.setPhrase(new Phrase("ID"));
//        accountTable.addCell(cell);
//
//        cell.setPhrase(new Phrase("Balance"));
//        accountTable.addCell(cell);
//
//        cell.setPhrase(new Phrase("Creation Date"));
//        accountTable.addCell(cell);
//
//        cell.setPhrase(new Phrase("Hidden"));
//        accountTable.addCell(cell);
//
//        cell.setPhrase(new Phrase("Number of Account"));
//        accountTable.addCell(cell);
//
//        cell.setPhrase(new Phrase("ID-Client"));
//        accountTable.addCell(cell);
//
//        // CELDAS ACCOUNT
//        accountTable.addCell(String.valueOf(account.getId()));
//        accountTable.addCell(String.valueOf(account.getBalance()));
//        accountTable.addCell(String.valueOf(account.getCreationDate()));
//        accountTable.addCell(String.valueOf(account.getHidden()));
//        accountTable.addCell(account.getNumber());
//        accountTable.addCell(String.valueOf(account.getClient().getId()));
//
//        document.add(accountTable);



        // TITULO CLIENT
        Paragraph p3 = new Paragraph("Client Details", font);
        p3.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p3);

        PdfPTable clientTable = new PdfPTable(3);
        clientTable.setWidthPercentage(100f);
        clientTable.setWidths(new float[]{1.5f, 3.5f, 3.0f});
        clientTable.setSpacingBefore(10);

        // HEADER TABLA ACCOUNT
        PdfPCell cellClient = new PdfPCell();
        cellClient.setBackgroundColor(BaseColor.GREEN);
        cellClient.setPadding(1);
        cellClient.setPhrase(new Phrase("Name"));
        clientTable.addCell(cellClient);

        cellClient.setPhrase(new Phrase("Last Name"));
        clientTable.addCell(cellClient);

        cellClient.setPhrase(new Phrase("Email"));
        clientTable.addCell(cellClient);

        // CELDAS ACCOUNT
        clientTable.addCell(String.valueOf(client.getFirstName()));
        clientTable.addCell(String.valueOf(client.getLastName()));
        clientTable.addCell(String.valueOf(client.getEmail()));


        document.add(clientTable);



        document.close();
    }

    }
