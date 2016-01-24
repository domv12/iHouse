package iHouse;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;

public class PanelLogowania extends JPanel {


	private JTextField textFieldLogin;
	private JPasswordField passwordFieldHaslo;

	public String login = "test";
	private String haslo = "test1";
	public int logowanie = 0;

	/**
	 * Create the panel.
	 */
	public PanelLogowania() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 600, 600);
		add(panel);
		panel.setLayout(null);

		// Login & haslo
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(147, 113, 46, 14);
		panel.add(lblLogin);

		JLabel lblHaslo = new JLabel("Haslo:");
		lblHaslo.setBounds(147, 161, 46, 14);
		panel.add(lblHaslo);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(205, 99, 190, 40);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		passwordFieldHaslo = new JPasswordField();
		passwordFieldHaslo.setBounds(205, 147, 190, 40);
		panel.add(passwordFieldHaslo);

		// Komunikat
		JTextPane errorText = new JTextPane();
		errorText.setBackground(SystemColor.window);
		errorText.setBounds(190, 260, 269, 40);
		panel.add(errorText);

		// iHouse3.0 text
		JTextPane txtpnIhouse = new JTextPane();
		txtpnIhouse.setEditable(false);
		txtpnIhouse.setBackground(SystemColor.window);
		txtpnIhouse.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		txtpnIhouse.setText("iHouse 3.0");
		txtpnIhouse.setBounds(256, 62, 87, 40);
		panel.add(txtpnIhouse);
	}

	public boolean zaloguj() {
		String localLog = textFieldLogin.getText();
		String localPas = String.valueOf(passwordFieldHaslo.getPassword());
		if (localLog.equals(login) && localPas.equals(haslo)) {
			return true;
			} else {
			return false;
		}
	}

	public void wyloguj() {
		System.exit(0);
	}
}
