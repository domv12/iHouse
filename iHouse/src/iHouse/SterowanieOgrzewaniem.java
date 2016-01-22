package iHouse;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class SterowanieOgrzewaniem extends JPanel implements Runnable{

	int id =2;
	boolean wlaczone = false;
	CzujnikTemperatury t1;
	
	JLabel lblAktualnaTemperatura;
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

	}
	
	public void wlaczOgrzewanie(){
		wlaczone=true;
	}
	public void wylaczOgrewanie(){
		wlaczone=false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method 
		for(;;){
		lblAktualnaTemperatura.setText(String.valueOf(t1.odczytajTemperature()));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	
	
	
	
	

}
