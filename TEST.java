import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TEST extends JDialog {
	// TEST
	private static JRadioButton POSButtonTEST, NEGButtonTEST, YESButtonCONLAST14DAYS, NOButtonCONLAST14DAYS;
	private static JButton CANCELbuttonTEST, OKbuttonTEST;
	private static JLabel textTEST, TESTResults, MessCONLAST14DAYS;
	private static String $result = " ", $contacts = " ";
	public static int $daysTEST = -1;

	static ArrayList<TEST> TestResults = new ArrayList<TEST>();

	public static String result;
	public static String ssnTests;

	private static String amka;

	public TEST(String amka, String tresult) {
		ssnTests = amka;
		result = tresult;

	}

	public static void TESTRESULTS(String AMKA) {

		amka = AMKA;

		JPanel panelTEST = new JPanel();
		panelTEST.setLayout(null); // Sets the layout manager for this container.
		panelTEST.setBackground(Color.lightGray);

		final JFrame frameTEST = new JFrame();
		frameTEST.setTitle("World Health Organization (WHO).");

		textTEST = new JLabel("PLEASE ANSWER THE FOLLOWING QUESTION.");
		textTEST.setFont(new Font("Tahoma", Font.BOLD, 13)); // Sets Font
		textTEST.setBackground(Color.lightGray);
		textTEST.setBounds(10, 20, 350, 30);
		panelTEST.add(textTEST);

		MessCONLAST14DAYS = new JLabel("DID YOU HAVE ANY CONTACTS IN THE LAST 14 DAYS?");
		MessCONLAST14DAYS.setBounds(20, 100, 350, 30);
		MessCONLAST14DAYS.setVisible(false);
		panelTEST.add(MessCONLAST14DAYS);

		YESButtonCONLAST14DAYS = new JRadioButton("YES");
		YESButtonCONLAST14DAYS.setBackground(Color.lightGray);
		YESButtonCONLAST14DAYS.setBounds(340, 100, 50, 20);
		YESButtonCONLAST14DAYS.setVisible(false);
		YESButtonCONLAST14DAYS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$contacts = "yes";
				NOButtonCONLAST14DAYS.setSelected(false);
			}

		});
		panelTEST.add(YESButtonCONLAST14DAYS);

		NOButtonCONLAST14DAYS = new JRadioButton("NO");
		NOButtonCONLAST14DAYS.setBackground(Color.lightGray);
		NOButtonCONLAST14DAYS.setBounds(410, 100, 50, 20);
		NOButtonCONLAST14DAYS.setVisible(false);
		NOButtonCONLAST14DAYS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$contacts = "no";
				YESButtonCONLAST14DAYS.setSelected(false);
			}

		});
		panelTEST.add(NOButtonCONLAST14DAYS);

		TESTResults = new JLabel("WΞ—Ξ‘Ξ¤ WAS THE TEST'S RESULT?");
		TESTResults.setBounds(20, 60, 300, 30);
		panelTEST.add(TESTResults);

		POSButtonTEST = new JRadioButton("POSITIVE");
		POSButtonTEST.setBackground(Color.lightGray);
		POSButtonTEST.setBounds(340, 60, 90, 20);
		POSButtonTEST.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$result = "positive";
				NEGButtonTEST.setSelected(false);

				MessCONLAST14DAYS.setVisible(true);
				YESButtonCONLAST14DAYS.setVisible(true);
				NOButtonCONLAST14DAYS.setVisible(true);
			}

		});
		panelTEST.add(POSButtonTEST);

		NEGButtonTEST = new JRadioButton("NEGATIVE");
		NEGButtonTEST.setBackground(Color.lightGray);
		NEGButtonTEST.setBounds(450, 60, 90, 20);
		NEGButtonTEST.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$result = "negative";
				POSButtonTEST.setSelected(false);

				MessCONLAST14DAYS.setVisible(false);
				YESButtonCONLAST14DAYS.setVisible(false);
				NOButtonCONLAST14DAYS.setVisible(false);
			}

		});
		panelTEST.add(NEGButtonTEST);

		OKbuttonTEST = new JButton("OK");
		OKbuttonTEST.setBounds(60, 150, 100, 20);
		OKbuttonTEST.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ($result.equals("positive")) {
					if ($contacts.equals("yes")) {
						CONTACTS.CaseContacts(amka);
					}

					// Inserts the date of the COVID-19 test
					DATE.TestDate(amka, $result);

					// Ξ•Ξ΅Ξ©Ξ¤Ξ—Ξ£Ξ— Ξ“Ξ™Ξ‘ Ξ�Ξ•Ξ‘ Ξ Ξ΅Ξ�Ξ£Ξ�Ξ—Ξ�Ξ— Ξ•Ξ Ξ‘Ξ¦Ξ—Ξ£
					frameTEST.setVisible(false);

				}
				if ($result.equals("negative")) {
					DATE.TestDate(amka, $result);
					//JOptionPane.showMessageDialog(frameTEST, "Not a possible case.");
					// Deletes patient
					// FUNC.deleteCase(amka, array);

					frameTEST.setVisible(false);
				}
				// adds new test result for a patient
				TestResults.add(new TEST(amka, $result));

			}

		});
		panelTEST.add(OKbuttonTEST);

		CANCELbuttonTEST = new JButton("CANCEL");
		CANCELbuttonTEST.setBounds(190, 150, 100, 20);
		CANCELbuttonTEST.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		panelTEST.add(CANCELbuttonTEST);

		frameTEST.add(panelTEST);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameTEST.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTEST.setSize(580, 250);
		frameTEST.setLocationRelativeTo(null); // the window is placed in the center of the screen
		frameTEST.setVisible(true);

	}
}
