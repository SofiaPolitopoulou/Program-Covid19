import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;

public class DATE {
	protected String amka;
	protected LocalDate d;

	public static ArrayList<DATE> Dates = new ArrayList<DATE>();

	// TestDate
	private static JLabel testDATE, yearDATE, monthDATE, dayDATE, errorYearDATE, errorMonthDATE, errorDayDATE;
	private static JTextField yearDATE_tf, monthDATE_tf, dayDATE_tf;
	private static JButton OKbuttonDATE, CANCELbuttonDATE;

	public static String $ssnContacts, $resultContacts;

	// CalculateDays
	private static JLabel messCALC;

	public DATE(String amka, LocalDate d) {
		this.amka = amka;
		this.d = d;
	}

	/* INSERTS THE DATE OF A POSITIVE TEST - USED IN CLASS TEST */
	public static void TestDate(String amka, final String results) {

		$ssnContacts = amka;
		$resultContacts = results;

		JPanel panelDATE = new JPanel();
		panelDATE.setLayout(null); // Sets the layout manager for this container.
		panelDATE.setBackground(Color.lightGray);

		final JFrame frameDATE = new JFrame();
		frameDATE.setTitle("WORLD HEALTH ORGANIZATION (WHO).");

		testDATE = new JLabel("WhHEN DID YOU HAVE THE TEST?");
		testDATE.setBounds(10, 20, 300, 30);
		testDATE.setBackground(Color.LIGHT_GRAY);
		panelDATE.add(testDATE, BorderLayout.PAGE_START); /// The component comes before the first line of the layout's
															/// content.

		yearDATE = new JLabel("ENTER YEAR:");
		yearDATE.setBounds(20, 60, 100, 30);
		yearDATE.setBackground(Color.lightGray);
		panelDATE.add(yearDATE);

		yearDATE_tf = new JTextField();
		yearDATE_tf.setBounds(140, 60, 100, 30);
		panelDATE.add(yearDATE_tf);

		monthDATE = new JLabel("ENTER MONTH:");
		monthDATE.setBounds(20, 100, 100, 30);
		monthDATE.setBackground(Color.lightGray);
		panelDATE.add(monthDATE);

		monthDATE_tf = new JTextField();
		monthDATE_tf.setBounds(140, 100, 100, 30);
		panelDATE.add(monthDATE_tf);

		dayDATE = new JLabel("ENTER DAY:");
		dayDATE.setBounds(20, 140, 100, 30);
		dayDATE.setBackground(Color.lightGray);
		panelDATE.add(dayDATE);

		dayDATE_tf = new JTextField();
		dayDATE_tf.setBounds(140, 140, 100, 30);
		panelDATE.add(dayDATE_tf);

		errorYearDATE = new JLabel("");
		errorYearDATE.setForeground(Color.red);
		errorYearDATE.setVisible(false);
		panelDATE.add(errorYearDATE);

		errorMonthDATE = new JLabel("");
		errorMonthDATE.setForeground(Color.red);
		errorMonthDATE.setVisible(false);
		panelDATE.add(errorMonthDATE);

		errorDayDATE = new JLabel("");
		errorDayDATE.setForeground(Color.red);
		errorDayDATE.setVisible(false);
		panelDATE.add(errorDayDATE);

		OKbuttonDATE = new JButton("OK");
		OKbuttonDATE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean oks[] = { false, false, false };

				LocalDate today = LocalDate.now();
				int a = today.getYear();

				String year = yearDATE_tf.getText();
				try {
					// Parses the string argument as a signed decimal integer
					if (Integer.parseInt(year) <= 2019 && Integer.parseInt(year) >= a) {
						errorYearDATE.setText("Invalid year. Please try again.");
						errorYearDATE.setBounds(20, 240, 300, 30);
						errorYearDATE.setVisible(true);

					} else {
						oks[0] = true;
						errorYearDATE.setVisible(false);

					}

				} catch (NumberFormatException err) {
					// if the string does not contain a parsable integer
					err.printStackTrace();

				}

				String month = monthDATE_tf.getText();
				try {
					// Parses the string argument as a signed decimal integer
					if (Integer.parseInt(month) <= 0 && Integer.parseInt(month) >= 12) {
						errorMonthDATE.setText("Invalid month. Please try again.");
						errorMonthDATE.setBounds(20, 280, 300, 30);
						errorMonthDATE.setVisible(true);

					} else {
						oks[1] = true;
						errorMonthDATE.setVisible(false);

					}

				} catch (NumberFormatException err) {
					// if the string does not contain a parsable integer
					err.printStackTrace();

				}

				String day = dayDATE_tf.getText();
				try {
					// Parses the string argument as a signed decimal integer
					if (Integer.parseInt(day) <= 0 && Integer.parseInt(day) >= 31) {
						errorDayDATE.setText("Invalid day. Please try again.");
						errorDayDATE.setBounds(20, 320, 300, 30);
						errorDayDATE.setVisible(true);

					} else {
						oks[2] = true;
						errorDayDATE.setVisible(false);

					}

				} catch (NumberFormatException err) {
					// if the string does not contain a parsable integer
					err.printStackTrace();

				}

				if (FUNC.checkALL(oks)) {
					LocalDate tdate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month),
							Integer.parseInt(day)); // This returns a LocalDate with the specified year, month and
													// day-of-month

					Dates.add(new DATE($ssnContacts, tdate));

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy"); // This method will
																								// create a formatter
																								// based on a simple
																								// pattern of letters
																								// and symbols

					String strDate = tdate.format(formatter); // This date will be passed to the formatter to produce a
																// string.
					ExcelCASE.excelresults(strDate, $ssnContacts, $resultContacts);
					if ($resultContacts == "positive") {
					JOptionPane.showMessageDialog(frameDATE,
							"Stay at home for 14 days after your last test and repeat it once timeline is over.");
					frameDATE.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frameDATE,
								"Thank you.Stay safe!");
						frameDATE.setVisible(false);
					}
			}
			}		
		});
		OKbuttonDATE.setBounds(60, 200, 100, 20);
		panelDATE.add(OKbuttonDATE);

		CANCELbuttonDATE = new JButton("CANCEL");
		CANCELbuttonDATE.setBounds(190, 200, 100, 20);
		CANCELbuttonDATE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		panelDATE.add(CANCELbuttonDATE);

		frameDATE.setSize(450, 370);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameDATE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDATE.add(panelDATE);
		frameDATE.setLocationRelativeTo(null);
		frameDATE.setVisible(true);

	}

	/* CALCULATES DAYS - USED BY CLASS MENU */
	public static void CalculateDays(String amkaP) throws IOException {

		JPanel panelCALC = new JPanel();
		panelCALC.setLayout(null); // Sets the layout manager for this container.
		panelCALC.setBackground(Color.lightGray);

		JFrame frameCALC = new JFrame();
		frameCALC.setTitle("WORLD HEALTH ORGANIZATION (WHO).");

		// EXCEL

		String excelFilePath = "resultlast.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);

		int i = 40;
		for (int rownr = 0; rownr < sheet.getPhysicalNumberOfRows(); rownr++) {

			Cell cell = sheet.getRow(rownr).getCell(2);
			Cell b = sheet.getRow(rownr).getCell(2);
			// Converts String to int.
			DataFormatter formatter = new DataFormatter();
			String b1 = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String
															// regardless of the cell type

			if (b1.equals(amkaP)) {

				String testdate = ExcelCASE.getDATE(rownr);
				String testres = ExcelCASE.getRes(rownr);
				messCALC = new JLabel("Your COVID-19 test date was: " + testdate + " RESULT: "+ testres);
				messCALC.setBounds(20, i, 400, 30);
				messCALC.setBackground(Color.lightGray);
				messCALC.setVisible(true);
				panelCALC.add(messCALC);

				i = i + 50;

			}

		}

		frameCALC.setSize(550, i + 60);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameCALC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCALC.add(panelCALC);
		frameCALC.setLocationRelativeTo(null); // the window is placed in the center of the screen
		frameCALC.setVisible(true);
	}

}
