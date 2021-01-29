
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class INFORMATION {

	private static JLabel ChooseFrom;
	private static JButton covidWhat, mentalHealthIn, worldwideCasesAbout, signsAndSymptoms, thePrespectivesOn;

	static String command;

	public static void info7() {

		final Desktop d = Desktop.getDesktop(); // Returns the Desktop instance of the current browser context.

		JPanel panelINFO = new JPanel();
		panelINFO.setLayout(null); // Sets the layout manager for this container.
		panelINFO.setBackground(Color.LIGHT_GRAY);

		final JFrame frameINFO = new JFrame();
		frameINFO.setTitle("World Health Organization (WHO).");

		ChooseFrom = new JLabel("CHOOSE FROM THE FOLLOWING:");
		ChooseFrom.setFont(new Font("Tahoma", Font.BOLD, 13)); // Sets the font
		ChooseFrom.setBounds(10, 20, 300, 30);
		panelINFO.add(ChooseFrom, BorderLayout.CENTER); // The center layout constraint (middle of container)

		// OPTION 1
		covidWhat = new JButton("1. COVID-19: what is this?");
		covidWhat.setBounds(20, 60, 300, 30);
		covidWhat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// browser for option 1
					d.browse(new URI("https://www.nejm.org/doi/full/10.1056/nejme2002387"));
				} catch (IOException | URISyntaxException e1) {

					e1.printStackTrace();
				}
				frameINFO.setVisible(false);
			}
		});
		panelINFO.add(covidWhat, BorderLayout.CENTER);

		// OPTION 2
		mentalHealthIn = new JButton("2. Mental health in COVID 19.");
		mentalHealthIn.setBounds(20, 100, 300, 30);
		mentalHealthIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// browsers for option 2
					d.browse(new URI("https://academic.oup.com/qjmed/article/113/5/311/5813733"));
					d.browse(new URI("https://www.sciencedirect.com/science/article/pii/S0165032720325891"));
				} catch (IOException | URISyntaxException e1) {

					e1.printStackTrace();
				}
				frameINFO.setVisible(false);
			}
		});
		panelINFO.add(mentalHealthIn, BorderLayout.CENTER);

		// OPTION 3
		worldwideCasesAbout = new JButton("3. Worldwide cases about the pandemic.");
		worldwideCasesAbout.setBounds(20, 140, 300, 30);
		worldwideCasesAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// browser for option 3
					d.browse(new URI("https://www.worldometers.info/coronavirus/?utm_campaign=homeAdvegas1?"));
				} catch (IOException | URISyntaxException e1) {

					e1.printStackTrace();
				}
				frameINFO.setVisible(false);
			}
		});
		panelINFO.add(worldwideCasesAbout, BorderLayout.CENTER);

		// OPTION 4
		signsAndSymptoms = new JButton("4. Signs and symptoms.");
		signsAndSymptoms.setBounds(20, 180, 300, 30);
		signsAndSymptoms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// browsers for option 4
					d.browse(new URI("https://www.cochranelibrary.com/cdsr/doi/10.1002/14651858.CD013665/full"));
					d.browse(new URI("https://www.cdc.gov/coronavirus/2019-ncov/symptoms-testing/symptoms.html"));
				} catch (IOException | URISyntaxException e1) {

					e1.printStackTrace();
				}
				frameINFO.setVisible(false);
			}
		});
		panelINFO.add(signsAndSymptoms, BorderLayout.CENTER);

		// OPTION 5
		thePrespectivesOn = new JButton("5. The prespectives on an unfolding crisis.");
		thePrespectivesOn.setBounds(20, 220, 300, 30);
		thePrespectivesOn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// browser for option 5
					d.browse(new URI("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7228411/"));
				} catch (IOException | URISyntaxException e1) {

					e1.printStackTrace();
				}
				frameINFO.setVisible(false);
			}
		});
		panelINFO.add(thePrespectivesOn, BorderLayout.CENTER);

		frameINFO.add(panelINFO);
		// Sets the operation that will happen by default when the user initiates a
		// "close" on this frame.
		// EXIT_ON_CLOSE:Exit the application using the System exit method.
		frameINFO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameINFO.setSize(360, 320);
		frameINFO.setLocationRelativeTo(null); // the window is placed in the center of the screen
		frameINFO.setVisible(true);

	}

	public static void info8() throws IOException, URISyntaxException {
		Desktop d = Desktop.getDesktop(); // Returns the Desktop instance of the current browser context.
		d.browse(new URI("https://osf.io/92ay6"));
	}

}
