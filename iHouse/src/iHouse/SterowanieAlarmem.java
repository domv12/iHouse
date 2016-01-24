package iHouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SterowanieAlarmem extends JPanel implements Runnable {

	int id =1;
	boolean wlaczone = false;
	JLabel lblWlaczony;
	JLabel lblAlarm;
	JLabel lblStan;
	Alarm alarm1;
	/**
	 * Create the panel.
	 */
	public SterowanieAlarmem() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 198, 300);
		add(panel);
		panel.setLayout(null);
		
		lblAlarm = new JLabel("Alarm");
		lblAlarm.setBounds(7, 0, 86, 24);
		panel.add(lblAlarm);
		
		lblWlaczony = new JLabel("");
		lblWlaczony.setBounds(7, 22, 181, 38);
		panel.add(lblWlaczony);
		
		lblStan = new JLabel("");
		lblStan.setBounds(7, 147, 181, 38);
		panel.add(lblStan);
		
		
		JButton btnWlaczAlarm = new JButton("wlacz alarm");
		btnWlaczAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wlaczAlarm();
				alarm1 = new Alarm();
				alarm1.start();
				
				
			}
		});
		
		btnWlaczAlarm.setBounds(7, 60, 125, 24);
		panel.add(btnWlaczAlarm);
		
		JButton btnWylaczAlarm = new JButton("wylacz Alarm");
		btnWylaczAlarm.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				wylaczAlarm();
				alarm1.stop();
			}
		});
		btnWylaczAlarm.setBounds(7, 95, 122, 29);
		panel.add(btnWylaczAlarm);
		
	}
	
	public void wlaczAlarm(){
		wlaczone=true;
		
	}
	public void wylaczAlarm(){
	
		wlaczone=false;
		for(int i=0; i>alarm1.czujnik.size();i++){
		alarm1.czujnik.get(i).stan=false;
		}
		lblStan.setText("alarm wylaczony");
	
	}
	

	@Override
	public void run() {
		for(;;){
			
			if(wlaczone){
				lblWlaczony.setText("uruchomiony : sprawdzam stan");
				lblStan.setText(String.valueOf(alarm1.sprawdzStan()));
				
			}
			else lblWlaczony.setText("wylaczony");
		}
		
	}

}
