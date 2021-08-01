/*

	This java file is responsible for exporting
	the student details, the book details, issued book details and the
	returned book details in the PDF format, that you can print them out,
	and keep the hard hopy with you.

*/ 

package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportToPdf extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JButton b1, b2, b3, b4, b5;
	
	// This method is for generating pdf from the student table
	public void createStudentPdf() {
		try {
			String filename = "F:\\StudentDetails.pdf";
			Document document = new Document();
			
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			
			Paragraph p1 = new Paragraph("Student Details - RDS College, Muzaffarpur", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD, new BaseColor(0, 88, 133)));
			p1.setAlignment(Element.ALIGN_CENTER);
			p1.setSpacingBefore(10);
			p1.setSpacingAfter(50);
			document.add(p1);
			
			PdfPTable pdfPTable = new PdfPTable(7);
			pdfPTable.setWidthPercentage(100);
			
			float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f, 1f};
			pdfPTable.setWidths(columnWidths);

			PdfPTable pdfPTable2 = new PdfPTable(7);
			pdfPTable2.setWidthPercentage(100);
			pdfPTable2.setWidths(columnWidths);
						
			PdfPCell c1 = new PdfPCell(new Paragraph("Student ID"));
			c1.setBorderColor(BaseColor.BLACK);
			c1.setBackgroundColor(new BaseColor(252,  217,  239));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c1);
			
			PdfPCell c2 = new PdfPCell(new Paragraph("Name"));
			c2.setBorderColor(BaseColor.BLACK);
			c2.setBackgroundColor(new BaseColor(252,  217,  239));
			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
			c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c2);
			
			PdfPCell c3 = new PdfPCell(new Paragraph("Father"));
			c3.setBorderColor(BaseColor.BLACK);
			c3.setBackgroundColor(new BaseColor(252,  217,  239));
			c3.setHorizontalAlignment(Element.ALIGN_CENTER);
			c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c3);
			
			PdfPCell c4 = new PdfPCell(new Paragraph("Course"));
			c4.setBorderColor(BaseColor.BLACK);
			c4.setBackgroundColor(new BaseColor(252,  217,  239));
			c4.setHorizontalAlignment(Element.ALIGN_CENTER);
			c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c4);
			
			PdfPCell c5 = new PdfPCell(new Paragraph("Branch"));
			c5.setBorderColor(BaseColor.BLACK);
			c5.setBackgroundColor(new BaseColor(252,  217,  239));
			c5.setHorizontalAlignment(Element.ALIGN_CENTER);
			c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c5);
			
			PdfPCell c6 = new PdfPCell(new Paragraph("Semester"));
			c6.setBorderColor(BaseColor.BLACK);
			c6.setBackgroundColor(new BaseColor(252,  217,  239));
			c6.setHorizontalAlignment(Element.ALIGN_CENTER);
			c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c6);
			
			PdfPCell c7 = new PdfPCell(new Paragraph("Year"));
			c7.setBorderColor(BaseColor.BLACK);
			c7.setBackgroundColor(new BaseColor(252,  217,  239));
			c7.setHorizontalAlignment(Element.ALIGN_CENTER);
			c7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c7);
			
			document.add(pdfPTable);
			
			EstablishConnection establishConnection = new EstablishConnection();
			
			String sql = "select * from student";
			PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				PdfPCell cell1 = new PdfPCell(new Paragraph(resultSet.getString("student_id")));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell1);
				PdfPCell cell2 = new PdfPCell(new Paragraph(resultSet.getString("name")));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell2);
				PdfPCell cell3 = new PdfPCell(new Paragraph(resultSet.getString("father")));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell3);
				PdfPCell cell4 = new PdfPCell(new Paragraph(resultSet.getString("course")));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell4);
				PdfPCell cell5 = new PdfPCell(new Paragraph(resultSet.getString("branch")));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell5);
				PdfPCell cell6 = new PdfPCell(new Paragraph(resultSet.getString("semester")));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell6);
				PdfPCell cell7 = new PdfPCell(new Paragraph(resultSet.getString("year")));
				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell7);
				document.add(pdfPTable2);
			}
			
			document.close();
			
			JOptionPane.showMessageDialog(null, "Exported Succesfully");
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	// This method is for generating pdf from the book table
	public void createBookPdf() {
		try {
			String filename = "F:\\BookDetails.pdf";
			Document document = new Document();
			
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			
			Paragraph p1 = new Paragraph("Book Details - RDS College, Muzaffarpur", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD, new BaseColor(0, 88, 133)));
			p1.setAlignment(Element.ALIGN_CENTER);
			p1.setSpacingBefore(10);
			p1.setSpacingAfter(50);
			document.add(p1);

			PdfPTable pdfPTable = new PdfPTable(7);
			pdfPTable.setWidthPercentage(100);
			
			float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f, 1f};
			pdfPTable.setWidths(columnWidths);

			PdfPTable pdfPTable2 = new PdfPTable(7);
			pdfPTable2.setWidthPercentage(100);
			pdfPTable2.setWidths(columnWidths);
						
			PdfPCell c1 = new PdfPCell(new Paragraph("Book ID"));
			c1.setBorderColor(BaseColor.BLACK);
			c1.setBackgroundColor(new BaseColor(252,  217,  239));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c1);
			
			PdfPCell c2 = new PdfPCell(new Paragraph("Title"));
			c2.setBorderColor(BaseColor.BLACK);
			c2.setBackgroundColor(new BaseColor(252,  217,  239));
			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
			c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c2);
			
			PdfPCell c3 = new PdfPCell(new Paragraph("ISBN"));
			c3.setBorderColor(BaseColor.BLACK);
			c3.setBackgroundColor(new BaseColor(252,  217,  239));
			c3.setHorizontalAlignment(Element.ALIGN_CENTER);
			c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c3);
			
			PdfPCell c4 = new PdfPCell(new Paragraph("Publisher"));
			c4.setBorderColor(BaseColor.BLACK);
			c4.setBackgroundColor(new BaseColor(252,  217,  239));
			c4.setHorizontalAlignment(Element.ALIGN_CENTER);
			c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c4);
			
			PdfPCell c5 = new PdfPCell(new Paragraph("Edition"));
			c5.setBorderColor(BaseColor.BLACK);
			c5.setBackgroundColor(new BaseColor(252,  217,  239));
			c5.setHorizontalAlignment(Element.ALIGN_CENTER);
			c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c5);
			
			PdfPCell c6 = new PdfPCell(new Paragraph("Price"));
			c6.setBorderColor(BaseColor.BLACK);
			c6.setBackgroundColor(new BaseColor(252,  217,  239));
			c6.setHorizontalAlignment(Element.ALIGN_CENTER);
			c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c6);
			
			PdfPCell c7 = new PdfPCell(new Paragraph("Pages"));
			c7.setBorderColor(BaseColor.BLACK);
			c7.setBackgroundColor(new BaseColor(252,  217,  239));
			c7.setHorizontalAlignment(Element.ALIGN_CENTER);
			c7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c7);
			
			document.add(pdfPTable);
			
			EstablishConnection establishConnection = new EstablishConnection();
			
			String sql = "select * from book";
			PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				PdfPCell cell1 = new PdfPCell(new Paragraph(resultSet.getString("book_id")));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell1);
				PdfPCell cell2 = new PdfPCell(new Paragraph(resultSet.getString("name")));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell2);
				PdfPCell cell3 = new PdfPCell(new Paragraph(resultSet.getString("isbn")));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell3);
				PdfPCell cell4 = new PdfPCell(new Paragraph(resultSet.getString("publisher")));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell4);
				PdfPCell cell5 = new PdfPCell(new Paragraph(resultSet.getString("edition")));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell5);
				PdfPCell cell6 = new PdfPCell(new Paragraph(resultSet.getString("price")));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell6);
				PdfPCell cell7 = new PdfPCell(new Paragraph(resultSet.getString("pages")));
				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell7);
				document.add(pdfPTable2);
			}
			
			document.close();
			
			JOptionPane.showMessageDialog(null, "Exported Succesfully");
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	// This method is for generating pdf from issue_book table
	public void createBookIssuePdf() {
		try {
			String filename = "F:\\BookIssueDetails.pdf";
			Document document = new Document();
			
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			
			Paragraph p1 = new Paragraph("Book Issue Details - RDS College, Muzaffarpur", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD, new BaseColor(0, 88, 133)));
			p1.setAlignment(Element.ALIGN_CENTER);
			p1.setSpacingBefore(10);
			p1.setSpacingAfter(50);
			document.add(p1);
			
			PdfPTable pdfPTable = new PdfPTable(7);
			pdfPTable.setWidthPercentage(100);
			
			float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f, 1f};
			pdfPTable.setWidths(columnWidths);

			PdfPTable pdfPTable2 = new PdfPTable(7);
			pdfPTable2.setWidthPercentage(100);			
			pdfPTable2.setWidths(columnWidths);
						
			PdfPCell c1 = new PdfPCell(new Paragraph("Book ID"));
			c1.setBorderColor(BaseColor.BLACK);
			c1.setBackgroundColor(new BaseColor(252,  217,  239));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c1);
			
			PdfPCell c2 = new PdfPCell(new Paragraph("Student ID"));
			c2.setBorderColor(BaseColor.BLACK);
			c2.setBackgroundColor(new BaseColor(252,  217,  239));
			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
			c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c2);
			
			PdfPCell c3 = new PdfPCell(new Paragraph("Title"));
			c3.setBorderColor(BaseColor.BLACK);
			c3.setBackgroundColor(new BaseColor(252,  217,  239));
			c3.setHorizontalAlignment(Element.ALIGN_CENTER);
			c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c3);
			
			PdfPCell c4 = new PdfPCell(new Paragraph("Student Name"));
			c4.setBorderColor(BaseColor.BLACK);
			c4.setBackgroundColor(new BaseColor(252,  217,  239));
			c4.setHorizontalAlignment(Element.ALIGN_CENTER);
			c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c4);
			
			PdfPCell c5 = new PdfPCell(new Paragraph("Course"));
			c5.setBorderColor(BaseColor.BLACK);
			c5.setBackgroundColor(new BaseColor(252,  217,  239));
			c5.setHorizontalAlignment(Element.ALIGN_CENTER);
			c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c5);
			
			PdfPCell c6 = new PdfPCell(new Paragraph("Branch"));
			c6.setBorderColor(BaseColor.BLACK);
			c6.setBackgroundColor(new BaseColor(252,  217,  239));
			c6.setHorizontalAlignment(Element.ALIGN_CENTER);
			c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c6);
			
			PdfPCell c7 = new PdfPCell(new Paragraph("Date of Issue"));
			c7.setBorderColor(BaseColor.BLACK);
			c7.setBackgroundColor(new BaseColor(252,  217,  239));
			c7.setHorizontalAlignment(Element.ALIGN_CENTER);
			c7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c7);
			
			document.add(pdfPTable);
			
			EstablishConnection establishConnection = new EstablishConnection();
			
			String sql = "select * from issue_book";
			PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				PdfPCell cell1 = new PdfPCell(new Paragraph(resultSet.getString("book_id")));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell1);
				PdfPCell cell2 = new PdfPCell(new Paragraph(resultSet.getString("student_id")));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell2);
				PdfPCell cell3 = new PdfPCell(new Paragraph(resultSet.getString("bname")));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell3);
				PdfPCell cell4 = new PdfPCell(new Paragraph(resultSet.getString("sname")));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell4);
				PdfPCell cell5 = new PdfPCell(new Paragraph(resultSet.getString("course")));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell5);
				PdfPCell cell6 = new PdfPCell(new Paragraph(resultSet.getString("branch")));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell6);
				PdfPCell cell7 = new PdfPCell(new Paragraph(resultSet.getString("date_of_issue")));
				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell7);
				document.add(pdfPTable2);
			}
			
			document.close();
			
			JOptionPane.showMessageDialog(null, "Exported Succesfully");
			statement.close();
			resultSet.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// This method is for generating PDF from the return_book table
	public void createBookReturnPdf() {
		try {
			String filename = "F:\\BookReturnDetails.pdf";
			Document document = new Document();
			
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			
			Paragraph p1 = new Paragraph("Book Return Details - RDS College, Muzaffarpur", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD, new BaseColor(0, 88, 133)));
			p1.setAlignment(Element.ALIGN_CENTER);
			p1.setSpacingBefore(10);
			p1.setSpacingAfter(50);
			document.add(p1);
			
			PdfPTable pdfPTable = new PdfPTable(8);
			pdfPTable.setWidthPercentage(100);
			
			float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f};
			pdfPTable.setWidths(columnWidths);

			PdfPTable pdfPTable2 = new PdfPTable(8);
			pdfPTable2.setWidthPercentage(100);
			pdfPTable2.setWidths(columnWidths);
			
			PdfPCell c1 = new PdfPCell(new Paragraph("Book ID"));
			c1.setBorderColor(BaseColor.BLACK);
			c1.setBackgroundColor(new BaseColor(252,  217,  239));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c1);
			
			PdfPCell c2 = new PdfPCell(new Paragraph("Student ID"));
			c2.setBorderColor(BaseColor.BLACK);
			c2.setBackgroundColor(new BaseColor(252,  217,  239));
			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
			c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c2);
			
			PdfPCell c3 = new PdfPCell(new Paragraph("Title"));
			c3.setBorderColor(BaseColor.BLACK);
			c3.setBackgroundColor(new BaseColor(252,  217,  239));
			c3.setHorizontalAlignment(Element.ALIGN_CENTER);
			c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c3);
			
			PdfPCell c4 = new PdfPCell(new Paragraph("Student Name"));
			c4.setBorderColor(BaseColor.BLACK);
			c4.setBackgroundColor(new BaseColor(252,  217,  239));
			c4.setHorizontalAlignment(Element.ALIGN_CENTER);
			c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c4);
			
			PdfPCell c5 = new PdfPCell(new Paragraph("Course"));
			c5.setBorderColor(BaseColor.BLACK);
			c5.setBackgroundColor(new BaseColor(252,  217,  239));
			c5.setHorizontalAlignment(Element.ALIGN_CENTER);
			c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c5);
			
			PdfPCell c6 = new PdfPCell(new Paragraph("Branch"));
			c6.setBorderColor(BaseColor.BLACK);
			c6.setBackgroundColor(new BaseColor(252,  217,  239));
			c6.setHorizontalAlignment(Element.ALIGN_CENTER);
			c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c6);
			
			PdfPCell c7 = new PdfPCell(new Paragraph("Date of Issue"));
			c7.setBorderColor(BaseColor.BLACK);
			c7.setBackgroundColor(new BaseColor(252,  217,  239));
			c7.setHorizontalAlignment(Element.ALIGN_CENTER);
			c7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c7);
			
			PdfPCell c8 = new PdfPCell(new Paragraph("Date of Return"));
			c8.setBorderColor(BaseColor.BLACK);
			c8.setBackgroundColor(new BaseColor(252,  217,  239));
			c8.setHorizontalAlignment(Element.ALIGN_CENTER);
			c8.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(c8);
			
			document.add(pdfPTable);
			
			EstablishConnection establishConnection = new EstablishConnection();
			
			String sql = "select * from return_book";
			PreparedStatement statement = establishConnection.connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				PdfPCell cell1 = new PdfPCell(new Paragraph(resultSet.getString("book_id")));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell1);
				PdfPCell cell2 = new PdfPCell(new Paragraph(resultSet.getString("student_id")));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell2);
				PdfPCell cell3 = new PdfPCell(new Paragraph(resultSet.getString("bname")));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell3);
				PdfPCell cell4 = new PdfPCell(new Paragraph(resultSet.getString("sname")));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell4);
				PdfPCell cell5 = new PdfPCell(new Paragraph(resultSet.getString("course")));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell5);
				PdfPCell cell6 = new PdfPCell(new Paragraph(resultSet.getString("branch")));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell6);
				PdfPCell cell7 = new PdfPCell(new Paragraph(resultSet.getString("date_of_issue")));
				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell7);
				PdfPCell cell8 = new PdfPCell(new Paragraph(resultSet.getString("date_of_return")));
				cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPTable2.addCell(cell8);
				document.add(pdfPTable2);
			}
			
			document.close();
			
			JOptionPane.showMessageDialog(null, "Exported Succesfully");
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public ExportToPdf() {
		super("Export To PDF - Library Management System");
		setBounds(400, 200, 550, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel("To export tables from the database, Click on the");
		l1.setBounds(10, 20, 500, 24);
		l1.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 16));
		l1.setForeground(Color.BLACK);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Export");
		l2.setBounds(380, 20, 500, 24);
		l2.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 16));
		l2.setForeground(new Color(0, 88, 133));
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("button below.");
		l3.setBounds(435, 20, 500, 24);
		l3.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 16));
		l3.setForeground(Color.BLACK);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Student Details Table");
		l4.setBounds(30, 70, 500, 24);
		l4.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 16));
		l4.setForeground(Color.BLACK);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Book Details Table");
		l5.setBounds(30, 100, 500, 24);
		l5.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 16));
		l5.setForeground(Color.BLACK);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Book Issue Table");
		l6.setBounds(30, 130, 500, 24);
		l6.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 16));
		l6.setForeground(Color.BLACK);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("Book Return Table");
		l7.setBounds(30, 160, 500, 24);
		l7.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 16));
		l7.setForeground(Color.BLACK);
		contentPane.add(l7);

		b1 = new JButton("Export");
		b1.addActionListener(this);
		b1.setBounds(280, 65, 100, 24);
		b1.setBorder(new LineBorder(new Color(0, 88, 133), 2));
		b1.setForeground(new Color(0, 88, 133));
		b1.setBackground(Color.WHITE);
		contentPane.add(b1);
		
		b2 = new JButton("Export");
		b2.addActionListener(this);
		b2.setBounds(280, 95, 100, 24);
		b2.setBorder(new LineBorder(new Color(0, 88, 133), 2));
		b2.setForeground(new Color(0, 88, 133));
		b2.setBackground(Color.WHITE);
		contentPane.add(b2);
		
		b3 = new JButton("Export");
		b3.addActionListener(this);
		b3.setBounds(280, 125, 100, 24);
		b3.setBorder(new LineBorder(new Color(0, 88, 133), 2));
		b3.setForeground(new Color(0, 88, 133));
		b3.setBackground(Color.WHITE);
		contentPane.add(b3);
		
		b4 = new JButton("Export");
		b4.addActionListener(this);
		b4.setBounds(280, 155, 100, 24);
		b4.setBorder(new LineBorder(new Color(0, 88, 133), 2));
		b4.setForeground(new Color(0, 88, 133));
		b4.setBackground(Color.WHITE);
		contentPane.add(b4);
		
		b5 = new JButton("CANCEL");
		b5.addActionListener(this);
		b5.setBounds(180, 220, 100, 24);
		b1.setBorder(new LineBorder(new Color(0, 88, 133), 2));
		b5.setForeground(Color.WHITE);
		b5.setBackground(new Color(0, 88, 133));
		contentPane.add(b5);

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			if (e.getSource() == b1) {
				createStudentPdf();
			}
			if (e.getSource() == b2) {
				createBookPdf();
			}
			if(e.getSource() == b3) {
				createBookIssuePdf();
			}
			if(e.getSource() == b4) {
				createBookReturnPdf();
			}
			if(e.getSource() == b5) {
				setVisible(false);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ExportToPdf().setVisible(true);
	}
}
