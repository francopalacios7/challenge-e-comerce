package com.challengeecomerce.BMW.Automotors.utils;

import com.challengeecomerce.BMW.Automotors.models.DuesPlan;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DuesPlanPDFExporter {

    private List<DuesPlan> duesPlan;
    public DuesPlanPDFExporter(List<DuesPlan> duesPlan){
        this.duesPlan = duesPlan;
    }


    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.GREEN);
        cell.setPadding(1);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.BLACK);

        cell.setPhrase(new Phrase("ID"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("planDescription"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("dues"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("interest"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("purchase"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("planDuesCarSet"));
        table.addCell(cell);
    }


    private void writeTableData(PdfPTable table) {
        duesPlan.forEach(duesP -> {
            table.addCell(String.valueOf(duesP.getId()));
            table.addCell(String.valueOf(duesP.getPlanDescription()));
            table.addCell(String.valueOf(duesP.getDues()));
            table.addCell(String.valueOf(duesP.getInterest()));
            table.addCell(String.valueOf(duesP.getPurchase()));
            table.addCell(String.valueOf(duesP.getPlanDuesCarSet()));
        });
    }


    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(BaseColor.DARK_GRAY);

        Paragraph p = new Paragraph("List of Dues Plan", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable duesPlanTable = new PdfPTable(6);
        duesPlanTable.setWidthPercentage(100f);
        duesPlanTable.setWidths(new float[]{1.5f, 3.5f, 3.0f, 3.0f, 3.0f, 3.0f});
        duesPlanTable.setSpacingBefore(10);

        writeTableHeader(duesPlanTable);
        writeTableData(duesPlanTable);

        document.add(duesPlanTable);

        document.close();
    }









}
