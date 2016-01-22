package iHouse;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

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
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(10, 11, 86, 38);
		panel.add(lblTemperatura);
		
		lblAktualnaTemperatura = new JLabel("");
		lblAktualnaTemperatura.setBounds(106, 23, 46, 14);
		panel.add(lblAktualnaTemperatura);
		
		t1 = new CzujnikTemperatury();
		t1.start();	
		lblAktualnaTemperatura.setText(String.valueOf(t1.odczytajTemperature()));
		
		JButton btnWlaczOgrzewanie = new JButton("wlacz ogrzewanie");
		btnWlaczOgrzewanie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wlaczOgrzewanie();
			}
		});
		btnWlaczOgrzewanie.setBounds(7, 60, 125, 23);
		panel.add(btnWlaczOgrzewanie);
		
		JButton btnNewButton = new JButton("wylacz ogrzewanie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wylaczOgrewanie();
				textFieldUstawTemp.setEnabled(true);
			}
		});
		btnNewButton.setBounds(10, 94, 122, 29);
		panel.add(btnNewButton);
		
		textFieldUstawTemp = new JTextField();
		textFieldUstawTemp.setBounds(10, 158, 86, 20);
		panel.add(textFieldUstawTemp);
		textFieldUstawTemp.setColumns(10);
		
		JButton btnUtrzymujTemperature = new JButton("utrzymuj temperature");
		btnUtrzymujTemperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldUstawTemp.setEnabled(false);
			}
		});
		btnUtrzymujTemperature.setBounds(10, 189, 156, 23);
		panel.add(btnUtrzymujTemperature);

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
