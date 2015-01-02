/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.pdf;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import sa.shpi.advanced.model.Residential;
import sa.shpi.advanced.model.content.FurnishingList;
import sa.shpi.advanced.model.content.Room;
import sa.shpi.advanced.model.structure.MaterialList;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This class automatically generates a PDF report upon instantiation.
 * @author Tyler
 *
 */
public class PdfGenerator {
	private static long date = new Date().getTime();
	private static String FILE = "C:/Emissions_Report_" + String.valueOf(date)
			+ ".pdf";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);

	private static Residential res;

	public PdfGenerator(Residential res) {
		PdfGenerator.res = res;

		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addTitlePage(document);
			addContent(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addTitlePage(Document document)
			throws DocumentException {

		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);

		// Write the header
		preface.add(new Paragraph(
				"El reporte para las emisiones de los incendios residenciales",
				catFont));
		preface.add(new Paragraph("SHPI Ingenieria S.A.", smallBold));
		addEmptyLine(preface, 1);

		preface.add(new Paragraph("Reporte generado: " + new Date(), smallBold));
		addEmptyLine(preface, 3);

		document.add(preface);
	}

	private static void addContent(Document document) throws DocumentException {
		//basic fire details
		Paragraph resDetails = new Paragraph("Detalles del incendio:", subFont);
		resDetails.add(new Paragraph("Área total: " + res.getAreaTotal()
				+ " m^2"));
		resDetails.add(new Paragraph("Área quemada: " + res.getAreaBurned()
				+ " m^2"));
		addEmptyLine(resDetails, 2);

		Paragraph totalEmissions = new Paragraph("Total de emisiones: "
				+ String.format("%.2f kg CO2", res.getTotalEmissions()),
				catFont);

		// add all this to the document
		document.add(resDetails);
		document.add(generateStructureSection());
		document.add(generateContentSection());
		document.add(totalEmissions);
	}

	private static Paragraph generateStructureSection() {
		//add structure details
		Paragraph structureDetails = new Paragraph("La estructura ("
				+ String.format("%.2f kg CO2", res.getStructureEmissions())
				+ "):", subFont);
		PdfPTable structureTable = new PdfPTable(3);

		PdfPCell c1 = new PdfPCell(new Phrase("Categoría"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		structureTable.addCell(c1);

		c1 = new PdfPCell(new Phrase("El material"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		structureTable.addCell(c1);

		c1 = new PdfPCell(new Phrase("El porcentaje de la ubicación"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		structureTable.addCell(c1);

		// complete table dynamically
		ArrayList<sa.shpi.advanced.model.structure.Section> resSections = res
				.getSections();
		for (int count = 0; count < resSections.size(); count++) {
			structureTable.addCell(resSections.get(count).getSectionCategory()
					.toString());

			MaterialList matList = resSections.get(count).getMaterialList();
			for (int c2 = 0; c2 < matList.size(); c2++) {
				structureTable.addCell(matList.get(c2).getMaterial().getName());
				structureTable.addCell(matList.get(c2).getPercent() + "%");
				structureTable.addCell("");
			}
			//add blank cells to complete the row
			structureTable.addCell("");
			structureTable.addCell("");
			//delete empty row
			structureTable.deleteLastRow();
		}

		structureDetails.add(structureTable);

		return structureDetails;
	}

	private static Paragraph generateContentSection() {
		//add content details
		Paragraph contentDetails = new Paragraph("Los contenidos ("
				+ String.format("%.2f kg CO2", res.getContentEmissions())
				+ "):", subFont);
		PdfPTable contentTable = new PdfPTable(3);

		PdfPCell c1 = new PdfPCell(new Phrase("La área"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		contentTable.addCell(c1);

		c1 = new PdfPCell(new Phrase("El mueble"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		contentTable.addCell(c1);

		c1 = new PdfPCell(new Phrase("Cantidad"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		contentTable.addCell(c1);

		ArrayList<Room> rooms = res.getRooms();
		for (int count = 0; count < rooms.size(); count++) {
			contentTable.addCell(rooms.get(count).toString());

			FurnishingList furnishingList = rooms.get(count)
					.getFurnishingList();
			for (int c2 = 0; c2 < furnishingList.size(); c2++) {
				contentTable.addCell(furnishingList.get(c2).getFurnishing()
						.getName());
				contentTable.addCell(String.valueOf(furnishingList.get(c2)
						.getQuantity()));
				contentTable.addCell("");
			}
			//add blank cells to complete the row
			contentTable.addCell("");
			contentTable.addCell("");
			//delete emptry row
			contentTable.deleteLastRow();
		}

		contentDetails.add(contentTable);

		return contentDetails;
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
