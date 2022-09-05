/*package com.example.pfeesprit.QRAndPDF;
import java.util.List;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import esprit.pidev.entities.Bill;

public class DefaultUserPDFExporter {
   int priceincard;
   private List<Bill> listBills;
   
 

   public DefaultUserPDFExporter(List<Bill> listBills, int priceincard) {
	   this.priceincard=priceincard;
       this.listBills = listBills;
        }

   private void writeTableHeader(PdfPTable table) {
       PdfPCell cell = new PdfPCell();
       cell.setBackgroundColor(Color.blue);
       cell.setPadding(5);
        
       Font font = FontFactory.getFont(FontFactory.HELVETICA);
       font.setColor(Color.WHITE);
       
       cell.setPhrase(new Phrase("Created_At", font));
       table.addCell(cell);
       
       
       cell.setPhrase(new Phrase("Status", font));
       table.addCell(cell);
       
       cell.setPhrase(new Phrase("Warranty", font));
       table.addCell(cell);      
   }
    
   private void writeTableData(PdfPTable table) {
       for (Bill bill : listBills) {
           table.addCell(bill.getCreatedAt().toString());
           table.addCell(String.valueOf(bill.getStatus()));
           table.addCell(String.valueOf(bill.getWarranty()));
       }
   }
    
   public Document export(HttpServletResponse response) throws DocumentException, IOException {
       Document document = new Document(PageSize.A4);
       PdfWriter.getInstance(document, response.getOutputStream());
        
       document.open();
       Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
       font.setSize(18);
       font.setColor(Color.blue);
        
       Paragraph p = new Paragraph("Facture", font);
       p.setAlignment(Paragraph.ALIGN_CENTER);
       document.add(p);
   
       PdfPTable table = new PdfPTable(3);
       table.setWidthPercentage(100f);
       table.setWidths(new float[] {1.5f, 3.5f, 3.0f});
       table.setSpacingBefore(10);
         
       writeTableHeader(table);
       writeTableData(table);
    // HTTP response code: 403" error.
       System.setProperty("http.agent", "Chrome");

       String filename = "src/main/webapp/bb.jpg";
       Image image = Image.getInstance(filename);
       image.setSpacingBefore(10);
       
       document.add(image);
       document.add(table);
       
       Paragraph s = new Paragraph("your loyalty card now contains "+" "+priceincard + " TND");
       Paragraph H = new Paragraph("we didn't use this price in your loyaltycard because you achived more than three payments , the price is fixed from now until you decide later what are you going to do with that price thanks!<3");
       document.add(s); 
       document.add(H); 
       
       document.close();
	return document;
        
   }
}*/