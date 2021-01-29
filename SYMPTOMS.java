import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SYMPTOMS extends JDialog {

	// SYMPTOMS
	private static JRadioButton yesSYMPTbutton, noSYMPTbutton, YESTouchButtonSYMPT, NOTouchButtonSYMPT;
	private static JRadioButton YESTestButtonSYMPT, NOTestButtonSYMPT;
	private static JLabel SymptomsQuestion, touchQuestionSYMPT, daysPassedSYMPT, testQuestionSYMPT, MessSYMPT;
	private static JTextField daysPassedSYMPT_tf;
	private static JButton OKbuttonSYMPT, CANCELbuttonSYMPT;
	public static String $sympt = "no", $touch = "no", $test = "no", daysString = " ";
	public int $daysSYMPT;

	private static String amka;

	public SYMPTOMS(String AMKA) {

		amka = AMKA;

		JPanel panelSYMPTOMS = new JPanel();
		panelSYMPTOMS.setLayout(null); // Sets the layout manager for this container
		panelSYMPTOMS.setBackground(Color.lightGray);

		final JFrame frameSYMPTOMS = new JFrame();
		frameSYMPTOMS.setTitle("World Health Organization (WHO).");

		SymptomsQuestion = new JLabel("DID YOU HAVE ANY SYMPTOMS?");
		SymptomsQuestion.setBounds(20, 60, 250, 30);
		SymptomsQuestion.setBackground(Color.lightGray);
		panelSYMPTOMS.add(SymptomsQuestion);

		yesSYMPTbutton = new JRadioButton("YES");
		yesSYMPTbutton.setBounds(260, 60, 50, 20);
		yesSYMPTbutton.setBackground(Color.lightGray);
		yesSYMPTbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$sympt = "yes";
				noSYMPTbutton.setSelected(false);

			}

		});
		panelSYMPTOMS.add(yesSYMPTbutton);

		noSYMPTbutton = new JRadioButton("NO");
		noSYMPTbutton.setBounds(330, 60, 50, 20);
		noSYMPTbutton.setBackground(Color.lightGray);
		noSYMPTbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$sympt = "no";
				yesSYMPTbutton.setSelected(false);

			}

		});
		panelSYMPTOMS.add(noSYMPTbutton);

		touchQuestionSYMPT = new JLabel("DID YOU GET IN TOUCH WITH A CASE?");
		touchQuestionSYMPT.setBounds(20, 100, 250, 30);
		panelSYMPTOMS.add(touchQuestionSYMPT);

		daysPassedSYMPT = new JLabel("HOW MANY DAYS HAVE PASSED FROM YOUR TOUCH WITH THE CASE?");
		daysPassedSYMPT.setBounds(20, 140, 400, 30);
		daysPassedSYMPT.setVisible(false);
		panelSYMPTOMS.add(daysPassedSYMPT);

		daysPassedSYMPT_tf = new JTextField();
		daysPassedSYMPT_tf.setBounds(440, 140, 50, 30);
		daysPassedSYMPT_tf.setVisible(false);
		panelSYMPTOMS.add(daysPassedSYMPT_tf);

		YESTouchButtonSYMPT = new JRadioButton("YES");
		YESTouchButtonSYMPT.setBounds(260, 100, 50, 20);
		YESTouchButtonSYMPT.setBackground(Color.lightGray);
		YESTouchButtonSYMPT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$touch = "yes";
				NOTouchButtonSYMPT.setSelected(false);

				MessSYMPT.setVisible(false);

				daysPassedSYMPT.setVisible(true);
				daysPassedSYMPT_tf.setVisible(true);

			}

		});
		panelSYMPTOMS.add(YESTouchButtonSYMPT);

		MessSYMPT = new JLabel("");
		MessSYMPT.setForeground(Color.red);
		MessSYMPT.setVisible(false);
		panelSYMPTOMS.add(MessSYMPT);

		NOTouchButtonSYMPT = new JRadioButton("NO");
		NOTouchButtonSYMPT.setBounds(330, 100, 50, 20);
		NOTouchButtonSYMPT.setBackground(Color.lightGray);
		NOTouchButtonSYMPT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				$touch = "no";
				YESTouchButtonSYMPT.setSelected(false);

				daysPassedSYMPT.setVisible(false);
				daysPassedSYMPT_tf.setVisible(false);

				if ($sympt.equals("no")) {
					MessSYMPT.setText("Not a possible case.");
					MessSYMPT.setVisible(true);
					MessSYMPT.setBounds(20, 260, 200, 30);
				} else {
					MessSYMPT.setVisible(false);
				}

			}

		});
		panelSYMPTOMS.add(NOTouchButtonSYMPT);

		testQuestionSYMPT = new JLabel("DID YOU HAVE A COVID-19 TEST?");
		testQuestionSYMPT.setBounds(20, 180, 250, 30);
		panelSYMPTOMS.add(testQuestionSYMPT);

		YESTestButtonSYMPT = new JRadioButton("YES");
		YESTestButtonSYMPT.setBounds(260, 180, 50, 20);
		YESTestButtonSYMPT.setBackground(Color.lightGray);
		YESTestButtonSYMPT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$test = "yes";
				NOTestButtonSYMPT.setSelected(false);

			}

		});
		panelSYMPTOMS.add(YESTestButtonSYMPT);

		NOTestButtonSYMPT = new JRadioButton("NO");
		NOTestButtonSYMPT.setBounds(330, 180, 50, 20);
		NOTestButtonSYMPT.setBackground(Color.lightGray);
		NOTestButtonSYMPT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				$test = "no";
				YESTestButtonSYMPT.setSelected(false);

			}

		});
		panelSYMPTOMS.add(NOTestButtonSYMPT);

		OKbuttonSYMPT = new JButton("OK");
		OKbuttonSYMPT.setBounds(60, 220, 100, 20);
		OKbuttonSYMPT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if ($test.equals("yes")) {

					daysString = daysPassedSYMPT_tf.getText();
					try {
						if (daysString.equals(" ")) {
							$daysSYMPT = 0;

						} else {
							$daysSYMPT = Integer.parseInt(daysString);

						}
					} catch (NumberFormatException err) {
						err.printStackTrace();

					}

					if ($daysSYMPT >= 15) {
						JOptionPane.showMessageDialog(null, "Not a possible case.");
						// FUNC.deleteCase(amka, AL);
						frameSYMPTOMS.setVisible(false);

					}
					if ($daysSYMPT <= 14) {
						TEST.TESTRESULTS(amka);
						frameSYMPTOMS.setVisible(false);

					}

				}

				if ($sympt.equals("no") && $touch.equals("no") && $test.equals("no")) {
					JOptionPane.showMessageDialog(frameSYMPTOMS, "Not a possible case, deleting patient.");
					// FUNC.deleteCase(amka, AL);
					frameSYMPTOMS.setVisible(false);

				}

				if ($test.equals("no") && ($sympt.equals("yes") || $touch.equals("yes"))) {
					JOptionPane.showMessageDialog(frameSYMPTOMS, "Do a COVID-19 test and stay at home for 14 days!");
					frameSYMPTOMS.setVisible(false);

				}

			}

		});
		panelSYMPTOMS.add(OKbuttonSYMPT);

		CANCELbuttonSYMPT = new JButton("CANCEL");
		CANCELbuttonSYMPT.setBounds(190, 220, 100, 20);
		CANCELbuttonSYMPT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		panelSYMPTOMS.add(CANCELbuttonSYMPT);

		frameSYMPTOMS.add(panelSYMPTOMS);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameSYMPTOMS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSYMPTOMS.setSize(550, 380);
		frameSYMPTOMS.setLocationRelativeTo(null); // the window is placed in the center of the screen
		frameSYMPTOMS.setVisible(true);

	}

}
