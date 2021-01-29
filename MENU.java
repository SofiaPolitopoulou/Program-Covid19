import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MENU {
	protected static final ArrayList<CASE> Patients = null;
	private static JFrame frameMENU, frameEnterSSN;
	private static JPanel panelMENU, panelEnterSSN;
	private static JButton button1, button2, button3, button4, button5, button6, button7, button8, OK;
	private static JLabel Menu, errorMess, label;
	private static JTextField label_tf;

	public static String ssn;

	static String command;
	static int b;

	public MENU() {
		JOptionPane.showMessageDialog(null, "Welcome to World Health Organization (WHO).");
		panelMENU = new JPanel();
		panelMENU.setLayout(null); // Sets the layout manager for this container.
		// This method changes layout-related information and invalidates the component
		// hierarchy.
		// setBounds
		panelMENU.setBackground(Color.lightGray);

		frameMENU = new JFrame();
		frameMENU.setTitle("WELCOME TO WORLD HEALTH ORGANIZATION (WHO).");

		// Ξ•Ξ™Ξ£Ξ‘Ξ“Ξ©Ξ“Ξ— Ξ�Ξ•Ξ�Ξ�Ξ¥
		Menu = new JLabel("MENU");
		Menu.setBackground(Color.LIGHT_GRAY);
		Menu.setForeground(Color.BLACK);
		Menu.setFont(new Font("Tahoma", Font.BOLD, 13)); // Ξ“Ξ΅Ξ‘Ξ�Ξ�Ξ‘Ξ¤Ξ�Ξ£Ξ•Ξ™Ξ΅Ξ‘
		Menu.setBounds(10, 20, 80, 30);
		panelMENU.add(Menu, BorderLayout.CENTER);
		panelMENU.setVisible(true);

		button1 = new JButton("1. ENTER A NEW CASE.");
		button1.setBounds(20, 60, 430, 30);// Ξ‘Ξ Ξ�Ξ£Ξ¤Ξ‘Ξ£Ξ— Ξ‘Ξ Ξ� Ξ‘Ξ΅Ξ™Ξ£Ξ¤Ξ•Ξ΅Ξ‘ Ξ�Ξ•Ξ΅Ξ™Ξ‘ Ξ Ξ‘Ξ΅Ξ‘Ξ�Ξ¥Ξ΅Ξ�Ξ¥, Ξ‘Ξ Ξ�Ξ£Ξ¤Ξ‘Ξ£Ξ— Ξ‘Ξ Ξ� Ξ Ξ‘Ξ�Ξ© Ξ�Ξ•Ξ΅Ξ™Ξ‘ Ξ Ξ‘Ξ΅Ξ‘Ξ�Ξ¥Ξ΅Ξ�Ξ¥,
											// width, height
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CASE.CaseGUI();

			}
		});
		panelMENU.add(button1, BorderLayout.CENTER); // Ξ Ξ΅Ξ�Ξ£Ξ�Ξ—Ξ�Ξ— Ξ•Ξ¤Ξ™Ξ�Ξ•Ξ¤Ξ‘Ξ£ Ξ£Ξ¤Ξ� Ξ Ξ‘Ξ΅Ξ‘Ξ�Ξ¥Ξ΅Ξ� Ξ£Ξ¤Ξ� Ξ�Ξ•Ξ�Ξ¤Ξ΅Ξ� Ξ¤Ξ�Ξ¥ PANEL

		button2 = new JButton("2. UPDATE THE SYSTEM AFTER A NEW COVID-19 TEST.");
		button2.setBounds(20, 100, 430, 30); // Ξ�Ξ•Ξ£Ξ—-Ξ”Ξ™Ξ‘Ξ£Ξ¤Ξ‘Ξ£Ξ•Ξ™Ξ£ Ξ¤Ξ‘Ξ�Ξ Ξ•Ξ›Ξ‘Ξ£
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterSSN();
				b = 2;

			}
		}); // Ξ�Ξ•Ξ›Ξ�Ξ¥Ξ�Ξ• Ξ¤Ξ� Ξ�Ξ�Ξ¥Ξ�Ξ Ξ™ Ξ�Ξ‘Ξ£ Ξ�Ξ‘ Ξ•Ξ�Ξ¤Ξ•Ξ›Ξ•Ξ™ Ξ�Ξ™Ξ‘ Ξ›Ξ•Ξ™Ξ¤Ξ�Ξ¥Ξ΅Ξ“Ξ™Ξ‘ Ξ�Ξ¤Ξ‘Ξ� Ξ¤Ξ� Ξ Ξ‘Ξ¤Ξ‘Ξ�Ξ•
		panelMENU.add(button2, BorderLayout.CENTER);

		button3 = new JButton("3. ENTER NEW CONTACTS FOR A CASE.");
		button3.setBounds(20, 140, 430, 30);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterSSN();
				b = 3;
			}
		});
		panelMENU.add(button3, BorderLayout.CENTER);

		button4 = new JButton("4. SEARCH CASES'S CONTACTS USING SSN.");
		button4.setBounds(20, 180, 430, 30);
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterSSN();
				b = 4;
			}
		});
		panelMENU.add(button4, BorderLayout.CENTER);

		button5 = new JButton("5. SEARCH THE NUMBER OF CASES USING POSTAL CODE (P.C.).");
		button5.setBounds(20, 220, 430, 30);
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CASE.searchArea();

			}
		});
		panelMENU.add(button5, BorderLayout.CENTER);

		button6 = new JButton("6. SEARCH MY COVID-19 TEST DATES.");
		button6.setBounds(20, 260, 430, 30);
		button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterSSN();
				b = 6;
			}
		});
		panelMENU.add(button6, BorderLayout.CENTER);

		button7 = new JButton("7. INFORMATIONS ABOUT COVID-19.");
		button7.setBounds(20, 300, 430, 30);
		button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				INFORMATION.info7();

			}
		});
		panelMENU.add(button7, BorderLayout.CENTER);

		button8 = new JButton("8. DOCTORS ADVICES.");
		button8.setBounds(20, 340, 430, 30);
		button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					INFORMATION.info8();
				} catch (IOException e1) {

					e1.printStackTrace();
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}
			}
		});
		panelMENU.add(button8, BorderLayout.CENTER);

		frameMENU.add(panelMENU);
		frameMENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the operation that will happen when the user
																	// initiates a "close" on this frame: Exit the
																	// application using the System exit method
		frameMENU.setSize(490, 450);
		frameMENU.setLocationRelativeTo(null); // Sets the location of the window. If the component is null, the window
												// is placed in the center of the screen
		frameMENU.setVisible(true); // Shows or hides this Window depending on the value of parameter b

	}

	public static void enterSSN() {
		panelEnterSSN = new JPanel();
		panelEnterSSN.setLayout(null);
		panelEnterSSN.setBackground(Color.lightGray);

		frameEnterSSN = new JFrame();
		frameEnterSSN.setTitle("WORLD HEALTH ORGANIZATION (WHO).");

		label = new JLabel("ENTER PATIENT'S SSN:");
		label.setBounds(20, 40, 130, 30);
		label.setVisible(true);
		panelEnterSSN.add(label);

		label_tf = new JTextField(11);
		label_tf.setBounds(190, 40, 110, 30);
		panelEnterSSN.add(label_tf);

		errorMess = new JLabel("");
		errorMess.setForeground(Color.red);
		errorMess.setVisible(false);
		panelEnterSSN.add(errorMess);

		OK = new JButton("OK");
		OK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				command = e.getActionCommand();

				if (command.equals("OK")) {
					ssn = label_tf.getText();
					if (ssn.length() != 11) {
						errorMess.setText("Invalid SSN. SSN must have 11 numbers. Please try again.");
						errorMess.setBounds(20, 130, 350, 30);
						errorMess.setVisible(true);
					} else if (ssn.length() == 11) {
						// OPTION 2
						if (b == 2) {
							try {
								boolean rs = ExcelCASE.check(ssn);

								if (rs == true) {
									TEST.TESTRESULTS(ssn);
								} else {
									JOptionPane.showMessageDialog(frameMENU, "No case found.");
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							panelEnterSSN.setVisible(false);
							frameEnterSSN.setVisible(false);

						}
						// OPTION 3
						if (b == 3) {
							try {
								boolean rs = ExcelCASE.check(ssn);

								if (rs == true) {
									CONTACTS.CaseContacts(ssn);
								} else {
									JOptionPane.showMessageDialog(frameMENU, "No case found.");
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							panelEnterSSN.setVisible(false);
							frameEnterSSN.setVisible(false);

						}
						// OPTION 4
						if (b == 4) {
							try {
								ExcelCASE.searchcon(ssn);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							panelEnterSSN.setVisible(false);
							frameEnterSSN.setVisible(false);

						}
						// OPTION 6
						if (b == 6) {
							try {
								boolean rs = ExcelCASE.check(ssn);

								if (rs == true) {
									DATE.CalculateDays(ssn);
								} else {
									JOptionPane.showMessageDialog(frameMENU, "No case found.");
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							panelEnterSSN.setVisible(false);
							frameEnterSSN.setVisible(false);

						}

					}

				}

			}

		});
		OK.setBounds(50, 90, 100, 20);
		panelEnterSSN.add(OK);

		panelEnterSSN.setVisible(true);
		frameEnterSSN.setVisible(true);
		frameEnterSSN.add(panelEnterSSN);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameEnterSSN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEnterSSN.setSize(400, 220);
		frameEnterSSN.setLocationRelativeTo(null); // the window is placed in the center of the screen
	}

	public static void main(String[] args) {
		new MENU();

	}

}
