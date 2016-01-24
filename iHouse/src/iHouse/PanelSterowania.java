package iHouse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class PanelSterowania extends JFrame {


	
	private JPanel contentPane;
	PanelLogowania panelLogowania;
	SterowanieOgrzewaniem sterowaneiOgrzewaniem;
	SterowanieAlarmem sterowanieAlarmem;
	SterowanieOswietleniem sterowaneiOswietleniem;
	
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
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelLogowania = new PanelLogowania();
		panelLogowania.setBounds(0, 0, 275, 113);
		contentPane.add(panelLogowania);
		
		sterowaneiOgrzewaniem = new SterowanieOgrzewaniem();
		sterowaneiOgrzewaniem.setBounds(399, 142, 205, 277);
		contentPane.add(sterowaneiOgrzewaniem);
		Thread sOgrzewaniem = new Thread(sterowaneiOgrzewaniem);
		sOgrzewaniem.start();
		
		sterowaneiOswietleniem = new SterowanieOswietleniem();
		sterowaneiOswietleniem.setBounds(0, 124, 275, 277);
		contentPane.add(sterowaneiOswietleniem);
		Thread sOswietleniem = new Thread(sterowaneiOswietleniem);
		sOswietleniem.start();
		
		sterowanieAlarmem = new SterowanieAlarmem();
		sterowanieAlarmem.setBounds(606, 11, 218, 260);
		contentPane.add(sterowanieAlarmem);
		Thread sAlarmem = new Thread(sterowanieAlarmem);
		sAlarmem.start();
		

		
		
		
		contentPane.validate();
		contentPane.repaint();
		
	}
}
