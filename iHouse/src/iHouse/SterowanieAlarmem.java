package iHouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * odpowiada za dzialanie modulu alarmu
 */
public class SterowanieAlarmem extends JPanel implements Runnable {

	int id =1;
	boolean wlaczone = false;
	JLabel lblWlaczony;
	JLabel lblAlarm;
	JLabel lblStan;
	JLabel lblGsm;
	Alarm alarm1;
	/**
	 * Create the panel.
	 */
	public SterowanieAlarmem() {
		alarm1 = new Alarm();
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 600);
		add(panel);
		panel.setLayout(null);
		
		lblAlarm = new JLabel("Alarm");
		lblAlarm.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblAlarm.setBounds(76, 19, 47, 24);
		panel.add(lblAlarm);
		
		lblWlaczony = new JLabel("");
		lblWlaczony.setBounds(20, 110, 160, 40);
		panel.add(lblWlaczony);
		
		lblStan = new JLabel("");
		lblStan.setBounds(20, 210, 160, 40);
		panel.add(lblStan);
		
		
		JButton btnWlaczAlarm = new JButton("Włącz alarm");
		btnWlaczAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wlaczAlarm();
				alarm1 = new Alarm();
				alarm1.start();
				
				
			}
		});
		
		btnWlaczAlarm.setBounds(20, 60, 160, 40);
		panel.add(btnWlaczAlarm);
		
		JButton btnWylaczAlarm = new JButton("Wyłącz alarm");
		btnWylaczAlarm.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				wylaczAlarm();
				alarm1.stop();
			}
		});
		btnWylaczAlarm.setBounds(20, 160, 160, 40);
		panel.add(btnWylaczAlarm);
		
		lblGsm = new JLabel("");
		lblGsm.setVerticalAlignment(SwingConstants.TOP);
		lblGsm.setBounds(20, 250, 160, 40);
		panel.add(lblGsm);
		
	}
	
	/**
	 * wlacza alarm
	 */
	public void wlaczAlarm(){
		wlaczone=true;
		
	}
	/**
	 * wylacza alarm
	 */
	public void wylaczAlarm(){
	
		wlaczone=false;
		for(int i=0; i>alarm1.czujnik.size();i++){
		alarm1.czujnik.get(i).stan=false;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblStan.setText("Alarm wyłączony");
		lblGsm.setText("");
	
	}
	

	@Override
	public void run() {
		for(;;){
			
			if(wlaczone){
				lblWlaczony.setText("Sprawdzam czujniki");
				lblStan.setText(String.valueOf(alarm1.sprawdzStan()));
				if(alarm1.sprawdzStan()){
					lblGsm.setText(alarm1.gsm.wyslijSMS());
				}
				
			}
			else lblWlaczony.setText("Wyłączony");
		}
		
	}
}
