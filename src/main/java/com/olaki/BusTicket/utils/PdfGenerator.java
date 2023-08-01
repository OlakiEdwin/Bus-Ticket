package com.olaki.BusTicket.utils;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.olaki.BusTicket.model.TicketDetails;

public class PdfGenerator {

    public void generate(TicketDetails ticket, HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);
        Paragraph paragraph1 = new Paragraph("Ticket Details", fontTitle);
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph1);
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        table.setWidths(new int[] { 2, 2, 2, 2, 2, 2, 2 });
        table.setSpacingBefore(5);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        cell.setPhrase(new Phrase("Ticket Number", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Bus Number", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Seat Number", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Confirmed Date", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("From City", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("To City", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Fare", font));
        table.addCell(cell);
        table.addCell(ticket.getTicketNumber());
        table.addCell(ticket.getBusNumber());
        table.addCell(ticket.getSeatNumber());
        table.addCell(ticket.getConfirmedDate());
        table.addCell(ticket.getFromCity());
        table.addCell(ticket.getToCity());
        table.addCell(ticket.getFare());
        document.add(table);
        document.close();
    }
}

