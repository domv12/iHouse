package iHouse;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.invoke.VolatileCallSite;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * dla danego pokoju ustawia przedzil czasu w ktorym swiatla maja byc zaswiecone
 */
public class HarmonogramOswietlenia extends JPanel implements Runnable{

		Pomieszczenie P; 
		int idPomieszczenia;
		Czas czas;	
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JButton btnUstaw;
		private JLabel lblOd;
		private JLabel lblDo;
		private JTextPane textPane;
		private JTextPane textPane1;
		
	
	/**
	 * Create the panel.
	 */
	public HarmonogramOswietlenia(Pomieszczenie p1) {
		setLayout(null);
		P=p1;
		int Hp[] = new int[2];
		int Hk[] = new int[2];
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 180);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNazwa = new JLabel(p1.nazwa, JLabel.CENTER);
		
		lblNazwa.setBounds(0, 6, 200, 14);
		System.out.println(p1.nazwa+" w harmonogramie.");
		//lblNazwa.setText(p1.nazwa);
		lblNazwa.repaint();
		lblNazwa.validate();
		panel.add(lblNazwa);
		 
		
		textField = new JTextField();
		textField.setBounds(56, 33, 40, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 33, 40, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(56, 68, 40, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(116, 68, 40, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		btnUstaw = new JButton("Ustaw");
		btnUstaw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hp[0]=Integer.valueOf(textField.getText());
				Hp[1]=Integer.valueOf(textField_1.getText());
				Hk[0]=Integer.valueOf(textField_2.getText());
				Hk[1]=Integer.valueOf(textField_3.getText());
				czas = new Czas(Hp,Hk);
				lblNazwa.setText("Gotowe");
				textField.setEnabled(false);
				textField_1.setEnabled(false);
				textField_2.setEnabled(false);
				textField_3.setEnabled(false);
			}
		});
		btnUstaw.setBounds(20, 102, 160, 40);
		panel.add(btnUstaw);
		
		lblOd = new JLabel("Od:");
		lblOd.setBounds(30, 41, 22, 14);
		panel.add(lblOd);
		
		lblDo = new JLabel("Do:");
		lblDo.setBounds(30, 76, 22, 14);
		panel.add(lblDo);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		textPane.setBackground(SystemColor.window);
		textPane.setText(":");
		textPane.setBounds(103, 37, 3, 24);
		panel.add(textPane);
		
		textPane1 = new JTextPane();
		textPane1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		textPane1.setBackground(SystemColor.window);
		textPane1.setText(":");
		textPane1.setBounds(103, 72, 3, 24);
		panel.add(textPane1);
		
		idPomieszczenia=p1.id;
		
		panel.validate();
		panel.repaint();
	}



	@Override
	public void run() {
		
		for(;;){
		if(!textField.isEnabled()){

			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
			String dateH = dateFormat.format(currentDate);
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("mm");
			String dateM = dateFormat2.format(currentDate);
			
			System.out.println(dateH);
			System.out.println(dateM);
			
			if(Integer.valueOf(dateH)>=czas.godziPocz[0]&&Integer.valueOf(dateM)>=czas.godziPocz[1]
					&&Integer.valueOf(dateH)<=czas.godziKon[0]&&Integer.valueOf(dateM)<=czas.godziKon[1]){
				P.wlaczSwiatlo();
			}else{
				P.wylaczSwiatlo();
			}
			
			
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			}
				
		}
		
	}

}
