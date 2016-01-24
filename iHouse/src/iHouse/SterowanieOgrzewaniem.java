package iHouse;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class SterowanieOgrzewaniem extends JPanel implements Runnable{

	int id =2;
	boolean wlaczone = false;
	CzujnikTemperatury t1;
	
	JLabel lblAktualnaTemperatura;
	private JTextField textFieldUstawTemp;
	/**
	 * Create the panel.
	 */
	public SterowanieOgrzewaniem() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 600);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(20, 53, 86, 38);
		panel.add(lblTemperatura);
		
		lblAktualnaTemperatura = new JLabel("",JLabel.RIGHT);
		lblAktualnaTemperatura.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblAktualnaTemperatura.setBounds(102, 65, 74, 14);
		panel.add(lblAktualnaTemperatura);
		
		t1 = new CzujnikTemperatury();
		t1.start();	
		lblAktualnaTemperatura.setText(String.valueOf(t1.odczytajTemperature()));
		
		JButton btnWlaczOgrzewanie = new JButton("Włącz ogrzewanie");
		btnWlaczOgrzewanie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wlaczOgrzewanie();
			}
		});
		btnWlaczOgrzewanie.setBounds(20, 92, 160, 40);
		panel.add(btnWlaczOgrzewanie);
		
		JButton btnNewButton = new JButton("Wyłącz ogrzewanie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wylaczOgrewanie();
				textFieldUstawTemp.setEnabled(true);
			}
		});
		btnNewButton.setBounds(20, 142, 160, 40);
		panel.add(btnNewButton);
		
		textFieldUstawTemp = new JTextField();
		textFieldUstawTemp.setBounds(66, 252, 40, 30);
		panel.add(textFieldUstawTemp);
		textFieldUstawTemp.setColumns(10);
		
		JButton btnUtrzymujTemperature = new JButton("Utrzymuj temperature");
		btnUtrzymujTemperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldUstawTemp.setEnabled(false);
			}
		});
		btnUtrzymujTemperature.setBounds(20, 290, 160, 40);
		panel.add(btnUtrzymujTemperature);
		
		JTextPane txtpnOgrzewanie = new JTextPane();
		txtpnOgrzewanie.setBackground(SystemColor.window);
		txtpnOgrzewanie.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		txtpnOgrzewanie.setText("Ogrzewanie");
		txtpnOgrzewanie.setBounds(54, 19, 92, 25);
		panel.add(txtpnOgrzewanie);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 196, 160, 14);
		panel.add(separator);
		
		JTextPane txtpnUstawStaTemperatur = new JTextPane();
		txtpnUstawStaTemperatur.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnUstawStaTemperatur.setBackground(SystemColor.window);
		txtpnUstawStaTemperatur.setText("Stała temperatura");
		txtpnUstawStaTemperatur.setBounds(40, 220, 122, 20);
		panel.add(txtpnUstawStaTemperatur);
		
		JTextPane txtpnC = new JTextPane();
		txtpnC.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnC.setBackground(SystemColor.window);
		txtpnC.setText("ºC");
		txtpnC.setBounds(110, 258, 21, 14);
		panel.add(txtpnC);

	}
	
	public void wlaczOgrzewanie(){
		wlaczone=true;
		
	}
	public void wylaczOgrewanie(){
		wlaczone=false;
		
	}

	
	/**
	 * funkcja sprawdz temperature 
	 * wyswietla aktualna wartosc temeperatury
	 */
	@Override
	public void run() {
		// TODO Auto-generated method 
		for(;;){
		if(wlaczone==true){
			t1.aktualnaTemperatura+=1;
		}
		lblAktualnaTemperatura.setText(String.valueOf(t1.odczytajTemperature()));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(	textFieldUstawTemp.isEnabled()==false){
			utrzymujTemperature(Double.valueOf(textFieldUstawTemp.getText()));
		}
		
		
		
		}
	}
	
	
	void utrzymujTemperature(double temperatura){
		
		if(t1.odczytajTemperature()>temperatura){
			if(wlaczone==true){
			wylaczOgrewanie();
				try {
				Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
		}
		}
		else{
			if(wlaczone==false){
				wlaczOgrzewanie();
				try {
					Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
			}
			
			
		}
		
	}
}
