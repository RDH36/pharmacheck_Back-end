package com.inclusiv.cdan3.pharmacheck.utilitaire;

import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PDFGenerator {

    public void generate(HttpServletResponse response, String title) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        Paragraph paragraph = new Paragraph(title, fontTiltle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new int[] { 3, 3, 3 });
        table.setSpacingBefore(5);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(CMYKColor.MAGENTA);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        cell.setPhrase(new Phrase("Nom", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Localisation", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Qte", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Qte", font));
        table.addCell(cell);
        document.add(table);
        document.close();
    }
}
