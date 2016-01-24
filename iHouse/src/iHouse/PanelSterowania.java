package iHouse;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class PanelSterowania extends JFrame {

	private JPanel contentPane;
	PanelLogowania panelLogowania;
	SterowanieOgrzewaniem sterowanieOgrzewaniem;
	SterowanieAlarmem sterowanieAlarmem;
	SterowanieOswietleniem sterowanieOswietleniem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelSterowania frame = new PanelSterowania();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelSterowania() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel Logowania
		panelLogowania = new PanelLogowania();
		// Zaloguj button
		JButton btnNewButton = new JButton("Zaloguj");
		btnNewButton.setBounds(205, 199, 190, 40);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (panelLogowania.zaloguj() == true) {
					panelLogowania.setVisible(true);
					remove(panelLogowania);
					repaint();
					validate();

					sterowanieOgrzewaniem.setVisible(true);
					sterowanieOswietleniem.setVisible(true);
					sterowanieAlarmem.setVisible(true);

				}
			}
		});
		panelLogowania.setBounds(0, 0, 600, 600);
		contentPane.add(panelLogowania);
		
		// Panel Ogrzewania
		sterowanieOgrzewaniem = new SterowanieOgrzewaniem();
		sterowanieOgrzewaniem.setBounds(0, 0, 200, 600);
		sterowanieOgrzewaniem.setVisible(false);
		contentPane.add(sterowanieOgrzewaniem);

		// Panel Oswietlenia
		sterowanieOswietleniem = new SterowanieOswietleniem();
		sterowanieOswietleniem.setBounds(200, 0, 200, 600);
		sterowanieOswietleniem.setVisible(false);
		contentPane.add(sterowanieOswietleniem);

		// Panel Alarmu
		sterowanieAlarmem = new SterowanieAlarmem();
		sterowanieAlarmem.setBounds(400, 0, 200, 600);
		sterowanieAlarmem.setVisible(false);
		contentPane.add(sterowanieAlarmem);

		Thread sOswietleniem = new Thread(sterowanieOswietleniem);
		sOswietleniem.start();

		Thread sOgrzewaniem = new Thread(sterowanieOgrzewaniem);
		sOgrzewaniem.start();

		Thread sAlarmem = new Thread(sterowanieAlarmem);
		sAlarmem.start();

		contentPane.validate();
		contentPane.repaint();

	}
}
