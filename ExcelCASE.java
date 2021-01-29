import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelCASE {

	// searchcon
	private static JLabel MessSearchCONTACTS;

	private static Cell b;

	public static void data(String a, String b, String c, String d, String e1, String f, String g, String h)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		String excelFilePath = "datalast.xlsx";
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);
			// Ξ”Ξ—Ξ�Ξ™Ξ�Ξ¥Ξ΅Ξ“Ξ™Ξ‘ Ξ�Ξ•Ξ�Ξ¥ Ξ¥Ξ Ξ�Ξ›Ξ�Ξ“Ξ™Ξ£Ξ¤Ξ™Ξ�Ξ�Ξ¥ Ξ¦Ξ¥Ξ›Ξ›Ξ�Ξ¥ Ξ¤Ξ� Ξ�Ξ Ξ�Ξ™Ξ� Ξ§Ξ΅Ξ—Ξ£Ξ™Ξ�Ξ�Ξ Ξ�Ξ™Ξ•Ξ™Ξ¤Ξ‘Ξ™ Ξ“Ξ™Ξ‘ Ξ¤Ξ—Ξ�
			// Ξ•Ξ™Ξ£Ξ‘Ξ“Ξ©Ξ“Ξ— Ξ�Ξ‘Ξ™ Ξ‘Ξ Ξ�Ξ�Ξ—Ξ�Ξ•Ξ¥Ξ£Ξ— Ξ¤Ξ©Ξ� Ξ£Ξ¤Ξ�Ξ™Ξ§Ξ•Ξ™Ξ©Ξ� Ξ Ξ™Ξ�Ξ‘Ξ�Ξ�Ξ¥ Ξ�Ξ΅Ξ�Ξ¥Ξ£Ξ�Ξ‘Ξ¤Ξ�Ξ£.
			Sheet sheet = workbook.getSheetAt(0); // Get the Sheet object at the given index
			Object[][] bolo = { { a, b, c, d, e1, f, g, h },

			};

			int rowCount = sheet.getLastRowNum();

			for (Object[] aBook : bolo) {
				Row row = sheet.createRow(++rowCount); // Create a new row within the sheet and return the high level
														// representation

				int columnCount = 0;

				Cell cell = row.createCell(columnCount); // Use this to create new cells within the row and return it.
				cell.setCellValue(rowCount); // Set a boolean value for the cell

				for (Object field : aBook) {
					cell = row.createCell(++columnCount);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Integer) {
						cell.setCellValue((Integer) field);
					}
				}

			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream("datalast.xlsx");
			workbook.write(outputStream); // Write out this workbook to an Outputstream.
			workbook.close(); // Close the underlying input resource (File or Stream),from which the Workbook
								// was read
			outputStream.close(); // Closes this file output stream and releases any system resourcesassociated
									// with this stream

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (EncryptedDocumentException ex1) {
			ex1.printStackTrace();
		}
	}

	public static void excelresults(String a, String b, String c) {
		String excelFilePath = "resultlast.xlsx";
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream); // Creates the appropriate HSSFWorkbook /
																		// XSSFWorkbook from the given InputStream.
			// Ξ”Ξ—Ξ�Ξ™Ξ�Ξ¥Ξ΅Ξ“Ξ™Ξ‘ Ξ�Ξ•Ξ�Ξ¥ Ξ¥Ξ Ξ�Ξ›Ξ�Ξ“Ξ™Ξ£Ξ¤Ξ™Ξ�Ξ�Ξ¥ Ξ¦Ξ¥Ξ›Ξ›Ξ�Ξ¥ , " Results", Ξ¤Ξ� Ξ�Ξ Ξ�Ξ™Ξ� Ξ§Ξ΅Ξ—Ξ£Ξ™Ξ�Ξ�Ξ Ξ�Ξ™Ξ•Ξ™Ξ¤Ξ‘Ξ™
			// Ξ“Ξ™Ξ‘ Ξ¤Ξ—Ξ�
			// Ξ•Ξ™Ξ£Ξ‘Ξ“Ξ©Ξ“Ξ— Ξ�Ξ‘Ξ™ Ξ‘Ξ Ξ�Ξ�Ξ—Ξ�Ξ•Ξ¥Ξ£Ξ— Ξ¤Ξ©Ξ� Ξ£Ξ¤Ξ�Ξ™Ξ§Ξ•Ξ™Ξ©Ξ� Ξ¤Ξ—Ξ£ Ξ•Ξ Ξ‘Ξ¦Ξ—Ξ£ Ξ¤Ξ�Ξ¥ Ξ�Ξ΅Ξ�Ξ¥Ξ£Ξ�Ξ‘Ξ¤Ξ�Ξ£.

			Sheet sheet = workbook.getSheetAt(0);

			Object[][] bookrs = { { a, b, c },

			};

			int rowCount = sheet.getLastRowNum(); // Gets the last row on the sheetNote
			for (Object[] aBook : bookrs) {
				Row row = sheet.createRow(++rowCount);

				int columnCount = 0;

				Cell cell = row.createCell(columnCount);
				cell.setCellValue(rowCount);

				for (Object field : aBook) {
					cell = row.createCell(++columnCount);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Integer) {
						cell.setCellValue((Integer) field);
					}
				}

			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream("resultlast.xlsx");
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (EncryptedDocumentException ex1) {
			ex1.printStackTrace();
		}
	}

	/*public static <Worksheet> void deleterow(String amka) throws IOException {
		String excelFilePath = "resultslast.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		for (int rownr = 0; rownr < sheet.getPhysicalNumberOfRows(); rownr++) {
			Row row = sheet.getRow(rownr);
			int i = sheet.getPhysicalNumberOfRows(); // Returns the number of physically defined rows (NOT the number of
														// rows in the sheet)
			Cell cell = sheet.getRow(rownr).getCell(1);
			b = sheet.getRow(rownr).getCell(1);

			DataFormatter formatter = new DataFormatter();
			String b1 = formatter.formatCellValue(cell);

			if (b1.equals(amka)) {
				sheet.shiftRows(row.getRowNum() + 1, sheet.getLastRowNum() + 1, -1);
				i--;

				JOptionPane.showMessageDialog(null, "Deleting completed successfully.");
				break;

			}

		}

	}*/

	public static void excelcontacts(String a, String b, String c, String d) {
		String excelFilePath = "datalast.xlsx";

		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);
			// Ξ”Ξ—Ξ�Ξ™Ξ�Ξ¥Ξ΅Ξ“Ξ™Ξ‘ Ξ�Ξ•Ξ�Ξ¥ Ξ¥Ξ Ξ�Ξ›Ξ�Ξ“Ξ™Ξ£Ξ¤Ξ™Ξ�Ξ�Ξ¥ Ξ¦Ξ¥Ξ›Ξ›Ξ�Ξ¥ , " Contacts", Ξ¤Ξ� Ξ�Ξ Ξ�Ξ™Ξ� Ξ§Ξ΅Ξ—Ξ£Ξ™Ξ�Ξ�Ξ Ξ�Ξ™Ξ•Ξ™Ξ¤Ξ‘Ξ™
			// Ξ“Ξ™Ξ‘ Ξ¤Ξ—Ξ� Ξ•Ξ™Ξ£Ξ‘Ξ“Ξ©Ξ“Ξ— Ξ�Ξ‘Ξ™ Ξ‘Ξ Ξ�Ξ�Ξ—Ξ�Ξ•Ξ¥Ξ£Ξ— Ξ¤Ξ©Ξ� Ξ£Ξ¤Ξ�Ξ™Ξ§Ξ•Ξ™Ξ©Ξ� Ξ¤Ξ—Ξ£ Ξ•Ξ Ξ‘Ξ¦Ξ—Ξ£ Ξ¤Ξ�Ξ¥ Ξ�Ξ΅Ξ�Ξ¥Ξ£Ξ�Ξ‘Ξ¤Ξ�Ξ£.
			Sheet sheet = workbook.getSheet("Contacts");

			Object[][] BOOKCONTACTS = { { a, b, c, d },

			};

			int rowCount = sheet.getLastRowNum();

			for (Object[] aBook : BOOKCONTACTS) {
				Row row = sheet.createRow(++rowCount);

				int columnCount = 0;

				Cell cell = row.createCell(columnCount);
				cell.setCellValue(rowCount);

				for (Object field : aBook) {
					cell = row.createCell(++columnCount);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Integer) {
						cell.setCellValue((Integer) field);
					}
				}

			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream("datalast.xlsx");
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();

		} catch (IOException | EncryptedDocumentException ex) {
			ex.printStackTrace();
		}
	}

	public static boolean check(String ssn) throws IOException {
		String excelFilePath = "datalast.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		String amka = ssn;

		boolean flag = false;
		// Ξ Ξ΅Ξ�Ξ£Ξ Ξ•Ξ›Ξ‘Ξ£Ξ— Ξ¤Ξ—Ξ£ Ξ£Ξ¤Ξ—Ξ›Ξ—Ξ£ SSN Ξ¤Ξ�Ξ� EXCEL Ξ Ξ΅Ξ�Ξ�Ξ•Ξ™Ξ�Ξ•Ξ�Ξ�Ξ¥ Ξ�Ξ‘ Ξ•Ξ›Ξ•Ξ“Ξ�Ξ•Ξ™ Ξ‘Ξ�
		// Ξ¥Ξ Ξ‘Ξ΅Ξ§Ξ•Ξ™ Ξ¤Ξ� SSN Ξ Ξ�Ξ¥ Ξ”Ξ©Ξ�Ξ—Ξ�Ξ•
		for (int rownr = 0; rownr < sheet.getPhysicalNumberOfRows(); rownr++) {
			int i = sheet.getPhysicalNumberOfRows();
			Cell cell = sheet.getRow(rownr).getCell(4);
			b = sheet.getRow(rownr).getCell(4);
			// Converts cell to String.
			DataFormatter formatter = new DataFormatter();
			String b1 = formatter.formatCellValue(cell);

			if (b1.equals(amka)) {
				flag = true;
				break;
			}

		}
		return flag;
	}

	public static void searchcon(String ssn) throws IOException {
		String excelFilePath = "datalast.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet("Contacts");

		JPanel panelSEARCHCON = new JPanel();
		panelSEARCHCON.setLayout(null);
		panelSEARCHCON.setBackground(Color.lightGray);

		JFrame frameSEARCHCON = new JFrame();
		frameSEARCHCON.setTitle("World Health Organization (WHO).");

		boolean flag = false;
		int i = 40;

		for (int rownr = 0; rownr < sheet.getPhysicalNumberOfRows(); rownr++) {

			Cell cell = sheet.getRow(rownr).getCell(1);
			b = sheet.getRow(rownr).getCell(1);
			// Converts cell to String.
			DataFormatter formatter = new DataFormatter();
			String b1 = formatter.formatCellValue(cell);

			if (b1.equals(ssn)) {
				flag = true;
				Cell name = sheet.getRow(rownr).getCell(2);
				Cell phone = sheet.getRow(rownr).getCell(3);

				frameSEARCHCON.setVisible(true);

				MessSearchCONTACTS = new JLabel("");
				MessSearchCONTACTS.setForeground(Color.red);
				MessSearchCONTACTS.setVisible(false);
				panelSEARCHCON.add(MessSearchCONTACTS);

				MessSearchCONTACTS.setText("CONTACT:  Name:  " + name + "  Phone Number:  " + phone);
				MessSearchCONTACTS.setBounds(20, i, 400, 30);
				MessSearchCONTACTS.setVisible(true);

				i = i + 50;
			}
		}

		if (flag == false) {

			JOptionPane.showMessageDialog(null, "No contacts found.");
			frameSEARCHCON.setVisible(false);

		}

		frameSEARCHCON.setSize(450, i + 60);
		frameSEARCHCON.add(panelSEARCHCON);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameSEARCHCON.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSEARCHCON.setLocationRelativeTo(null); // the window is placed in the center of the screen

	}

	public static int serach(String pc) throws IOException {
		String excelFilePath = "datalast.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		String pcode = pc;

		int count = 0;

		for (int rownr = 0; rownr < sheet.getPhysicalNumberOfRows(); rownr++) {
			int i = sheet.getPhysicalNumberOfRows();
			Cell cell = sheet.getRow(rownr).getCell(8);
			b = sheet.getRow(rownr).getCell(8);
			// Converts cell to String.
			DataFormatter formatter = new DataFormatter();
			String b1 = formatter.formatCellValue(cell);

			if (b1.equals(pcode)) {
				count = count + 1;
			}
		}

		return count;
	}

	public static String getDATE(int rown) throws IOException {
		String excelFilePath = "resultlast.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Cell d = sheet.getRow(rown).getCell(1);
		DataFormatter formatter = new DataFormatter();
		String testdate = formatter.formatCellValue(d);
		return testdate;
	}
	public static String getRes(int rown) throws IOException {
		String excelFilePath = "resultlast.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Cell d = sheet.getRow(rown).getCell(3);
		DataFormatter formatter = new DataFormatter();
		String testres = formatter.formatCellValue(d);
		return testres;
	}
}
