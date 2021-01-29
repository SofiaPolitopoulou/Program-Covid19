import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.apache.poi.EncryptedDocumentException;

public class CASE {
	// CASEID
	private static JLabel MessCASE, nameCASE, ageCASE, ssnCASE, sexCASE, phoneCASE, emailCASE, addressCASE;
	private static JLabel postalcodeCASE;
	private static JLabel errorMessCASE, errorNameCASE, errorAgeCASE, errorSSNCASE, errorPNCASE, errorAddCASE,
			errorPCCASE;
	private static JTextField nameCASE_tf, ageCASE_tf, ssnCASE_tf, phoneCASE_tf, emailCASE_tf;
	private static JTextField addressCASE_tf, postalcodeCASE_tf;
	private static JRadioButton maleJButton, femaleJButton;
	private static JButton OKbuttonCASE, CANCELbuttonCASE;

	public static int flag = -1;

	// searchArea
	private static JLabel labelAREA;
	private static JTextField textAREA;
	private static JButton OKbuttonAREA, CANCELbuttonAREA;
	public static String $zip;

	// CASE Ξ�οΏ½Ξ�β€ΆΞ�Β¤Ξ�β€�Ξ�β€™Ξ�β€ΊΞ�β€”Ξ�Β¤Ξ�β€ΆΞ�Β£ Ξ�Β£Ξ�Β¤Ξ�β„ΆΞ�β€�Ξ�οΏ½Ξ�β„ΆΞ�οΏ½Ξ�Β¤Ξ�Β¥Ξ�Β Ξ�οΏ½Ξ�Β¥
	public static String $name = " ";
	public static int $age;
	public static String $ssn = " ";
	public static String $sex = "";
	public static String $phonenumber = " ";
	public static String $address = " ";
	public static String $postalcode = " ";
	public static String $email;

	public static String name;
	public static int age;
	public String ssn;
	public static String sex;
	public static String phonenumber;
	public String mail;
	public String address;
	public String zip;
	public static String $age1;

	public static ArrayList<CASE> Patients = new ArrayList<CASE>();

	public CASE(String n, int a, String amka, String gen, String pn, String mail, String address, String zip) {
		name = n;
		age = a;
		ssn = amka;
		sex = gen;
		phonenumber = pn;
		this.mail = mail;
		this.address = address;
		this.zip = zip;
	}

	public String get$ssn() {
		return $ssn;
	}

	public String get$postalcode() {
		return $postalcode;
	}

	public static void CaseGUI() {

		JPanel panelCASEID = new JPanel();
		panelCASEID.setLayout(null); // Sets the layout manager for this container
		panelCASEID.setBackground(Color.lightGray);

		final JFrame frameCASEID = new JFrame();
		frameCASEID.setTitle("World Health Organization (WHO).");

		MessCASE = new JLabel("PLEASE, FILL THE FIELDS BELOW.");
		MessCASE.setBounds(10, 20, 300, 30);
		MessCASE.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCASEID.add(MessCASE, BorderLayout.CENTER); // The center layout constraint (middle of container)

		nameCASE = new JLabel("FULL NAME:");
		nameCASE.setBounds(20, 60, 100, 25);
		panelCASEID.add(nameCASE);

		nameCASE_tf = new JTextField();
		nameCASE_tf.setBounds(140, 60, 250, 25);
		panelCASEID.add(nameCASE_tf);

		ageCASE = new JLabel("AGE:");
		ageCASE.setBounds(20, 100, 100, 25);
		panelCASEID.add(ageCASE);

		ageCASE_tf = new JTextField();
		ageCASE_tf.setBounds(140, 100, 50, 25);
		panelCASEID.add(ageCASE_tf);

		ssnCASE = new JLabel("SSN:");
		ssnCASE.setBounds(20, 140, 100, 25);
		panelCASEID.add(ssnCASE);

		ssnCASE_tf = new JTextField(11);
		ssnCASE_tf.setBounds(140, 140, 110, 25);
		panelCASEID.add(ssnCASE_tf);

		sexCASE = new JLabel("SEX:");
		sexCASE.setBounds(20, 180, 100, 25);
		panelCASEID.add(sexCASE);

		maleJButton = new JRadioButton("MALE");
		maleJButton.setBounds(140, 180, 60, 20);
		maleJButton.setBackground(Color.lightGray);
		maleJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				$sex = "male";
				femaleJButton.setSelected(false);
			}
		});

		panelCASEID.add(maleJButton);

		femaleJButton = new JRadioButton("FEMALE");
		femaleJButton.setBounds(220, 180, 70, 20);
		femaleJButton.setBackground(Color.lightGray);
		femaleJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				$sex = "female";
				maleJButton.setSelected(false);
			}
		});
		panelCASEID.add(femaleJButton);

		phoneCASE = new JLabel("PHONE NUMBER:");
		phoneCASE.setBounds(20, 220, 100, 25);
		panelCASEID.add(phoneCASE);

		phoneCASE_tf = new JTextField(10);
		phoneCASE_tf.setBounds(140, 220, 110, 25);
		panelCASEID.add(phoneCASE_tf);

		emailCASE = new JLabel("EMAIL ADDRESS:");
		emailCASE.setBounds(20, 260, 100, 25);
		panelCASEID.add(emailCASE);

		emailCASE_tf = new JTextField();
		emailCASE_tf.setBounds(140, 260, 250, 25);
		panelCASEID.add(emailCASE_tf);

		addressCASE = new JLabel("HOME ADDRESS:");
		addressCASE.setBounds(20, 300, 100, 25);
		panelCASEID.add(addressCASE);

		addressCASE_tf = new JTextField();
		addressCASE_tf.setBounds(140, 300, 350, 25);
		panelCASEID.add(addressCASE_tf);

		postalcodeCASE = new JLabel("POSTAL CODE:");
		postalcodeCASE.setBounds(20, 340, 100, 25);
		panelCASEID.add(postalcodeCASE);

		postalcodeCASE_tf = new JTextField();
		postalcodeCASE_tf.setBounds(140, 340, 80, 25);
		panelCASEID.add(postalcodeCASE_tf);

		errorNameCASE = new JLabel("");
		errorNameCASE.setForeground(Color.red);
		errorNameCASE.setVisible(false);
		panelCASEID.add(errorNameCASE);

		errorAgeCASE = new JLabel("");
		errorAgeCASE.setForeground(Color.red);
		errorAgeCASE.setVisible(false);
		panelCASEID.add(errorAgeCASE);

		errorSSNCASE = new JLabel("");
		errorSSNCASE.setForeground(Color.red);
		errorSSNCASE.setVisible(false);
		panelCASEID.add(errorSSNCASE);

		errorMessCASE = new JLabel("");
		errorMessCASE.setForeground(Color.red);
		errorMessCASE.setVisible(false);
		panelCASEID.add(errorMessCASE);

		errorPNCASE = new JLabel("");
		errorPNCASE.setForeground(Color.red);
		errorPNCASE.setVisible(false);
		panelCASEID.add(errorPNCASE);

		errorAddCASE = new JLabel("");
		errorAddCASE.setForeground(Color.red);
		errorAddCASE.setVisible(false);
		panelCASEID.add(errorAddCASE);

		errorPCCASE = new JLabel("");
		errorPCCASE.setForeground(Color.red);
		errorPCCASE.setVisible(false);
		panelCASEID.add(errorPCCASE);

		OKbuttonCASE = new JButton("OK");
		OKbuttonCASE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorMessCASE.setVisible(false);

				boolean oks[] = { false, false, false, false, false, false, false };

				$name = nameCASE_tf.getText();
				int flag = 0;

				boolean isNum = true;
				try {
					// Parses the string argument as a signed decimal integer
					Integer.parseInt($name);
					errorNameCASE.setVisible(false);

				} catch (NumberFormatException err) { // $name not a number
					// if the string does not contain a parsable integer
					isNum = false;
					if ($name.equals("")) {
						flag = 1;
						errorNameCASE.setText("Invalid name. Please try again.");
						errorNameCASE.setBounds(20, 420, 200, 30);
						errorNameCASE.setVisible(true);

					}

				}
				if (flag == 0) {
					if (isNum == false || FUNC.checkName($name) == true) {
						oks[0] = true;
						errorNameCASE.setVisible(false);

					}

				}

				$age1 = ageCASE_tf.getText();
				boolean isAge = true;
				try {
					// Parses the string argument as a signed decimal integer
					$age = Integer.parseInt($age1);

				} catch (NumberFormatException err) {
					// if the string does not contain a parsable integer
					isAge = false;

				}
				if (isAge == false || ($age > 120 || $age < 0)) {
					errorAgeCASE.setText("Invalid age. Please try again.");
					errorAgeCASE.setBounds(20, 450, 200, 30);
					errorAgeCASE.setVisible(true);

				} else {
					oks[1] = true;
					errorAgeCASE.setVisible(false);

				}
				$ssn = ssnCASE_tf.getText();

				if ($ssn.length() != 11 || $ssn.equals("")) {
					errorSSNCASE.setText("Invalid SSN. SSN must have 11 numbers. Please try again.");
					errorSSNCASE.setBounds(20, 480, 350, 30);
					errorSSNCASE.setVisible(true);

				} else {
					oks[2] = true;
					errorSSNCASE.setVisible(false);

				}

				if ($sex.equals("female") || $sex.equals("male")) {
					oks[3] = true;
					errorMessCASE.setVisible(false);

				} else {
					errorMessCASE.setText("Please choose MALE/ FEMALE.");
					errorMessCASE.setBounds(20, 510, 200, 30);
					errorMessCASE.setVisible(true);

				}

				$phonenumber = phoneCASE_tf.getText();
				if ($phonenumber.length() != 10 || $phonenumber.equals("")) {
					errorPNCASE.setText("Invalid Phone Number. Phone Number must have 10 numbers. Please try again.");
					errorPNCASE.setBounds(20, 540, 450, 30);
					errorPNCASE.setVisible(true);

				} else {
					oks[4] = true;
					errorPNCASE.setVisible(false);

				}

				$email = emailCASE_tf.getText();

				$address = addressCASE_tf.getText();
				if ($address.equals("")) {
					errorAddCASE.setText("Please enter your address.");
					errorAddCASE.setBounds(20, 570, 250, 30);
					errorAddCASE.setVisible(true);

				} else {
					oks[5] = true;
					errorAddCASE.setVisible(false);

				}

				$postalcode = postalcodeCASE_tf.getText();
				if ($postalcode.length() != 5 || $postalcode.equals("")) {
					errorPCCASE.setText("Invalid Postal Code. Postal Code must have 5 numbers. Please try again.");
					errorPCCASE.setBounds(20, 600, 450, 30);
					errorPCCASE.setVisible(true);

				} else {
					oks[6] = true;
					errorPCCASE.setVisible(false);

				}

				if (FUNC.checkALL(oks) == true) {
					Patients.add(new CASE($name, $age, $ssn, $sex, $phonenumber, $email, $address, $postalcode));

					// Inserting data in EXCEL
					try {
						ExcelCASE.data($name, $age1, $sex, $ssn, $phonenumber, $email, $address, $postalcode);
					} catch (EncryptedDocumentException | IOException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					new SYMPTOMS($ssn);
					frameCASEID.setVisible(false);

				}

			}

		});
		OKbuttonCASE.setBounds(60, 390, 100, 20);
		panelCASEID.add(OKbuttonCASE);

		CANCELbuttonCASE = new JButton("CANCEL");
		CANCELbuttonCASE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		CANCELbuttonCASE.setBounds(190, 390, 100, 20);
		panelCASEID.add(CANCELbuttonCASE);

		frameCASEID.add(panelCASEID);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameCASEID.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCASEID.setSize(550, 680);
		frameCASEID.setLocationRelativeTo(null); // the window is placed in the center of the screen
		frameCASEID.setVisible(true);

	}

	public static void searchArea() {

		JPanel panelAREA = new JPanel();
		panelAREA.setLayout(null); // Sets the layout manager for this container.
		panelAREA.setBackground(Color.lightGray);

		final JFrame frameAREA = new JFrame();
		frameAREA.setTitle("World Health Organization (WHO).");

		labelAREA = new JLabel("ENTER THE ZIP OF THE AREA YOU WANT TO SEARCH:");
		labelAREA.setBounds(20, 40, 310, 30);
		panelAREA.add(labelAREA);

		textAREA = new JTextField();
		textAREA.setBounds(330, 40, 80, 30);
		panelAREA.add(textAREA);

		OKbuttonAREA = new JButton("OK");
		OKbuttonAREA.setBounds(60, 100, 100, 20);
		OKbuttonAREA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$zip = textAREA.getText();

				int a = 0;
				try {
					a = ExcelCASE.serach($zip);
					if (a != 0) {
						JOptionPane.showMessageDialog(frameAREA, a);
					} else {
						JOptionPane.showMessageDialog(frameAREA, "No posibble cases found in your area.");
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}

				frameAREA.setVisible(false);
			}

		});
		panelAREA.add(OKbuttonAREA);

		CANCELbuttonAREA = new JButton("CANCEL");
		CANCELbuttonAREA.setBounds(190, 100, 100, 20);
		CANCELbuttonAREA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		panelAREA.add(CANCELbuttonAREA);

		frameAREA.add(panelAREA);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameAREA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAREA.setSize(450, 220);
		frameAREA.setLocationRelativeTo(null); // the window is placed in the center of the screen
		frameAREA.setVisible(true);

	}

	public static void main(String[] args) {
		try {
			CaseGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
