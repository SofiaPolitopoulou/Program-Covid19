import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CONTACTS {

	// CaseContacts
	private static JLabel MessCONTACTS, nameCONTACTS, phoneCONTACTS, emailCONTACTS, errorNameCONTACTS, errorPNCONTACTS;
	private static JTextField nameCONTACTS_tf, phoneCONTACTS_tf, emailCONTACTS_tf;
	private static JButton OKbuttonCONTACTS, CANCELbuttonCONTACTS;

	// addContacts
	private static JLabel addCONTACTS;
	private static JRadioButton YESaddCONTACTS, NOaddCONTACTS;
	private static JButton OKaddCONTACTS;
	public static String $answer;

	public static String contactsName;
	public static String contactsPhoneNumber;
	public static String ssnCase;
	public static String gmail;

	public static String $name = " ";
	public static String $phone = " ";
	public static String $ssnContacts;
	public static String $mail;

	public static ArrayList<CONTACTS> Contacts = new ArrayList<CONTACTS>();

	public CONTACTS(String name, String number, String amka, String mail) {
		contactsName = name;
		contactsPhoneNumber = number;
		ssnCase = amka;
		gmail = mail;

	}

	public static void CaseContacts(String amkaP) {

		$ssnContacts = amkaP;

		JPanel panelCONTACTS = new JPanel();
		panelCONTACTS.setLayout(null); // Sets the layout manager for this container
		panelCONTACTS.setBackground(Color.lightGray);

		final JFrame frameCONTACTS = new JFrame();
		frameCONTACTS.setTitle("World Health Organization (WHO).");

		MessCONTACTS = new JLabel("PLEASE, FILL THE FIELDS BELOW.");
		MessCONTACTS.setBounds(10, 20, 300, 30);
		MessCONTACTS.setFont(new Font("Tahoma", Font.BOLD, 13)); // Sets Font
		panelCONTACTS.add(MessCONTACTS, BorderLayout.CENTER); // The center layout constraint (middle of container)

		nameCONTACTS = new JLabel("CONTACT'S FULL NAME:");
		nameCONTACTS.setBounds(20, 60, 200, 30);
		panelCONTACTS.add(nameCONTACTS);

		nameCONTACTS_tf = new JTextField();
		nameCONTACTS_tf.setBounds(240, 60, 250, 30);
		panelCONTACTS.add(nameCONTACTS_tf);

		phoneCONTACTS = new JLabel("CONTACT'S PHONE NUMBER:");
		phoneCONTACTS.setBounds(20, 100, 200, 30);
		panelCONTACTS.add(phoneCONTACTS);

		phoneCONTACTS_tf = new JTextField(10);
		phoneCONTACTS_tf.setBounds(240, 100, 110, 30);
		panelCONTACTS.add(phoneCONTACTS_tf);

		emailCONTACTS = new JLabel("CONTACT'S EMAIL:");
		emailCONTACTS.setBounds(20, 140, 200, 30);
		panelCONTACTS.add(emailCONTACTS);

		emailCONTACTS_tf = new JTextField();
		emailCONTACTS_tf.setBounds(240, 140, 250, 30);
		panelCONTACTS.add(emailCONTACTS_tf);

		errorNameCONTACTS = new JLabel("");
		errorNameCONTACTS.setForeground(Color.red);
		errorNameCONTACTS.setVisible(false);
		panelCONTACTS.add(errorNameCONTACTS);

		errorPNCONTACTS = new JLabel("");
		errorPNCONTACTS.setForeground(Color.red);
		errorPNCONTACTS.setVisible(false);
		panelCONTACTS.add(errorPNCONTACTS);

		OKbuttonCONTACTS = new JButton("OK");
		OKbuttonCONTACTS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				boolean oks[] = { false, false };

				$name = nameCONTACTS_tf.getText();
				int flag = 0;

				boolean isNum = true;
				try {
					// Parses the string argument as a signed decimal integer
					Integer.parseInt($name);
					errorNameCONTACTS.setVisible(false);

				} catch (NumberFormatException err) { // $name not a number
					// if the string does not contain a parsable integer
					isNum = false;
					if ($name.equals("")) {
						flag = 1;
						errorNameCONTACTS.setText("Invalid name. Please try again.");
						errorNameCONTACTS.setBounds(20, 210, 250, 30);
						errorNameCONTACTS.setVisible(true);

					}

				}
				if (flag == 0) {
					if (isNum == false || FUNC.checkName($name) == true) {
						oks[0] = true;
						errorNameCONTACTS.setVisible(false);

					}

				}

				$phone = phoneCONTACTS_tf.getText();
				if ($phone.length() != 10 || $phone.equals(" ")) {
					errorPNCONTACTS
							.setText("Invalid Phone Number. Phone Number must have 10 numbers. Please try again.");
					errorPNCONTACTS.setBounds(20, 240, 450, 30);
					errorPNCONTACTS.setVisible(true);

				} else {
					oks[1] = true;
					errorPNCONTACTS.setVisible(false);

				}

				$mail = emailCONTACTS_tf.getText();

				if (FUNC.checkALL(oks) == true) {
					Contacts.add(new CONTACTS($name, $phone, $ssnContacts, $mail)); // adds new contact for a patient

					EMAIL.send("covidinfong@gmail.com", "nextgenPr", CONTACTS.$mail, "Ξ•Ξ�Ξ”Ξ¥ Ξ Ξ»Ξ·Ο�ΞΏΟ†Ο�Ο�Ξ·ΟƒΞ·",
							"You have been in contact with a COVID-19 case in the past few days. Please do a COVID-19 test and update the system immediately!");// Ξ‘Ξ Ξ�Ξ£Ξ¤Ξ�Ξ›Ξ—
																																								// Ξ�Ξ—Ξ�Ξ¥Ξ�Ξ‘Ξ¤Ξ�Ξ£
					JOptionPane.showMessageDialog(frameCONTACTS, "Contact entered successfully.");

					frameCONTACTS.setVisible(false);

					try {
						ExcelCASE.excelcontacts($ssnContacts, $name, $phone, $mail);
						System.out.println("Excel successfully completed.");
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					addContacts($ssnContacts);

				}
			}

		});
		OKbuttonCONTACTS.setBounds(60, 190, 100, 20);
		panelCONTACTS.add(OKbuttonCONTACTS);

		CANCELbuttonCONTACTS = new JButton("CANCEL");
		CANCELbuttonCONTACTS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		CANCELbuttonCONTACTS.setBounds(190, 190, 100, 20);
		panelCONTACTS.add(CANCELbuttonCONTACTS);

		frameCONTACTS.add(panelCONTACTS);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameCONTACTS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCONTACTS.setSize(550, 320);
		frameCONTACTS.setLocationRelativeTo(null); // the window is placed in the center of the screen
		frameCONTACTS.setVisible(true);

	}

	public static void addContacts(final String ssn) {

		JPanel panelADD = new JPanel();
		panelADD.setLayout(null); // Sets the layout manager for this container.
		panelADD.setBackground(Color.lightGray);

		final JFrame frameADD = new JFrame();
		frameADD.setTitle("World Health Organization (WHO).");

		addCONTACTS = new JLabel("DO YOU HAVE MORE CONTACTS TO ADD?");
		addCONTACTS.setBounds(20, 40, 300, 30);
		panelADD.add(addCONTACTS);

		YESaddCONTACTS = new JRadioButton("YES");
		YESaddCONTACTS.setBounds(60, 90, 50, 20);
		YESaddCONTACTS.setBackground(Color.lightGray);
		YESaddCONTACTS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$answer = "yes";
				NOaddCONTACTS.setSelected(false);

			}

		});
		panelADD.add(YESaddCONTACTS);

		NOaddCONTACTS = new JRadioButton("NO");
		NOaddCONTACTS.setBounds(190, 90, 50, 20);
		NOaddCONTACTS.setBackground(Color.lightGray);
		NOaddCONTACTS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$answer = "no";
				YESaddCONTACTS.setSelected(false);
			}

		});
		panelADD.add(NOaddCONTACTS);

		OKaddCONTACTS = new JButton("OK");
		OKaddCONTACTS.setBounds(100, 140, 100, 20);
		OKaddCONTACTS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ($answer.equals("yes")) {
					CaseContacts(ssn);
				} else {
					System.exit(0);
				}
			}

		});
		panelADD.add(OKaddCONTACTS);

		frameADD.add(panelADD);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameADD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameADD.setSize(350, 230);
		frameADD.setLocationRelativeTo(null); // the window is placed in the center of the screen
		frameADD.setVisible(true);

	}

}
