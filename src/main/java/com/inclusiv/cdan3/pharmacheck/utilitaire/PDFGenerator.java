package com.inclusiv.cdan3.pharmacheck.utilitaire;

import com.inclusiv.cdan3.pharmacheck.models.Pharmacie;
import com.inclusiv.cdan3.pharmacheck.service.ServicePharmacie;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PDFGenerator {

    private List<Pharmacie> pharmacies;
    public void generate(HttpServletResponse response, String title, String[] value, String prixTotal) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        Paragraph paragraph = new Paragraph(title, fontTiltle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new int[] { 4, 4, 3, 2});
        table.setSpacingBefore(5);
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);
        cell.setMinimumHeight(4);
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.BLACK);
        cell.setPhrase(new Phrase("Nom (produit/médicament)", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Localisation (pharmacie)", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Qte (plaquete/Boite)", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Prix (Ariary)", font));
        table.addCell(cell);

        for (String item: value) {
            String[] produit = item.split("/");
            for (String one: produit) {
                table.addCell(one);
            }
        }
        document.add(table);

        Paragraph total = new Paragraph("Total à payer : " + prixTotal + " Ariary", fontTiltle);
        total.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(total);

        Font fontlogo = FontFactory.getFont(FontFactory.TIMES_ITALIC);
        fontlogo.setColor(Color.BLACK);
        Paragraph logo = new Paragraph("Copyright PHARMACHECK 2022", fontlogo);
        logo.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(logo);
        document.close();
    }
}
