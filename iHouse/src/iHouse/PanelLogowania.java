package iHouse;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PanelLogowania extends JPanel {
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldHaslo;

	public String login = "test";
	private String haslo = "test1";
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelLogowania() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 275, 113);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(63, 30, 46, 14);
		panel.add(lblLogin);
		
		JLabel lblHaslo = new JLabel("Haslo:");
		lblHaslo.setBounds(63, 61, 46, 14);
		panel.add(lblHaslo);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(119, 27, 86, 20);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		passwordFieldHaslo = new JPasswordField();
		passwordFieldHaslo.setBounds(119, 58, 86, 20);
		panel.add(passwordFieldHaslo);

	}
	
	public boolean zaloguj(){
		String localLog=textFieldLogin.getText();
		String localPas= String.valueOf(passwordFieldHaslo.getPassword());
		if(localLog.equals(login)&&localPas.equals(haslo)){	
		return true;
		}else{
			return false;
		}
	}
	
	public void wyloguj(){
		System.exit(0);
	}
	
	
}


