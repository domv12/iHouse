package iHouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JSeparator;

public class SterowanieOswietleniem extends JPanel implements Runnable{

	int id=3;
	
	Pomieszczenie kuchnia;
	Pomieszczenie salon;
	Pomieszczenie pokoj;
	Pomieszczenie lazienka;
	Pomieszczenie korytarz;
	
	JLabel lblKuchniaStan;
	JLabel lblSalonStan;
	JLabel lblLazienkaStan;
	JLabel lblPokojStan;
	JLabel lblKorytarzStan; 
	
	JCheckBox checkKuchania;
	JCheckBox checkSalon;
	JCheckBox checkLazienka;
	JCheckBox checkPokoj;
	JCheckBox chckKorytarz;
	
	HarmonogramOswietlenia harmonogramOswietlenia;
	
	JPanel panel;
	private JButton btnWylaczWszystkie;
	private JTextPane txtpnHarmonogram;
	private JSeparator separator;
	private JTextPane txtpnWybierzPokj;
	
	/**
	 * Create the panel.
	 */
	public SterowanieOswietleniem() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 200, 600);
		add(panel);
		panel.setLayout(null);
		
		kuchnia = new Pomieszczenie(1,"Kuchnia");
		salon = new Pomieszczenie(2,"Salon");
		pokoj = new Pomieszczenie(3,"Pokój");
		lazienka = new Pomieszczenie(4,"Łazienka");
		korytarz = new Pomieszczenie(5,"Korytarz");
		
		JLabel lblKuchnia = new JLabel("Kuchnia");
		lblKuchnia.setBounds(40, 75, 98, 14);
		panel.add(lblKuchnia);
		
		JLabel lblSalon = new JLabel("Salon");
		lblSalon.setBounds(40, 100, 98, 14);
		panel.add(lblSalon);
		
		JLabel lblLazienka = new JLabel("Łazienka");
		lblLazienka.setBounds(40, 125, 76, 14);
		panel.add(lblLazienka);
		
		JLabel lblPokoj = new JLabel("Pokój");
		lblPokoj.setBounds(40, 150, 76, 14);
		panel.add(lblPokoj);
		
		JLabel lblKorytarz = new JLabel("Korytarz");
		lblKorytarz.setBounds(40, 175, 98, 14);
		panel.add(lblKorytarz);
		
		lblKuchniaStan = new JLabel("",JLabel.RIGHT);
		lblKuchniaStan.setBounds(115, 75, 65, 14);
		panel.add(lblKuchniaStan);
		
		lblSalonStan = new JLabel("",JLabel.RIGHT);
		lblSalonStan.setBounds(115, 100, 65, 14);
		panel.add(lblSalonStan);
		
		lblLazienkaStan = new JLabel("",JLabel.RIGHT);
		lblLazienkaStan.setBounds(115, 125, 65, 14);
		panel.add(lblLazienkaStan);
		
		lblPokojStan = new JLabel("",JLabel.RIGHT);
		lblPokojStan.setBounds(114, 150, 66, 14);
		panel.add(lblPokojStan);
		
		lblKorytarzStan = new JLabel("",JLabel.RIGHT);
		lblKorytarzStan.setBounds(115, 175, 65, 14);
		panel.add(lblKorytarzStan);
		
		checkKuchania = new JCheckBox("");
		checkKuchania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(	checkKuchania.isSelected()) kuchnia.wlaczSwiatlo();
				else kuchnia.wylaczSwiatlo();
			}
		});
		
		checkKuchania.setBounds(10, 70, 25, 25);
		panel.add(checkKuchania);
		
		checkSalon = new JCheckBox("");
		checkSalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkSalon.isSelected()) salon.wlaczSwiatlo();
				else salon.wylaczSwiatlo();
			}
		});
		
		checkSalon.setBounds(10, 95, 25, 25);
		panel.add(checkSalon);
		
		checkLazienka = new JCheckBox("");
		checkLazienka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkLazienka.isSelected()) lazienka.wlaczSwiatlo();
				else lazienka.wylaczSwiatlo();
			}
		});
		
		checkLazienka.setBounds(10, 120, 25, 25);
		panel.add(checkLazienka);
		
		checkPokoj = new JCheckBox("");
		checkPokoj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkPokoj.isSelected()) pokoj.wlaczSwiatlo();
				else pokoj.wylaczSwiatlo();
			}
		});
		checkPokoj.setBounds(10, 145, 25, 25);
		panel.add(checkPokoj);
		
		chckKorytarz = new JCheckBox("");
		chckKorytarz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckKorytarz.isSelected()) korytarz.wlaczSwiatlo();
				else korytarz.wylaczSwiatlo();
			}
		});
		chckKorytarz.setBounds(10, 170, 25, 25);
		panel.add(chckKorytarz);
		
		JScrollPane listScrollPane = new JScrollPane();
		String[] ar = {"Kuchnia", "Salon", "Łazienka","Pokój","Korytarz"};
		JList list = new JList(ar);
		list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  ustawHarmonogram((list.getSelectedValue().toString()));
                }
            }
        });
		listScrollPane.setViewportView(list);
		listScrollPane.setBounds(20, 345, 160, 67);
		panel.add(listScrollPane);
		
		harmonogramOswietlenia = new HarmonogramOswietlenia(kuchnia);
		harmonogramOswietlenia.setBounds(0, 420, 0, 0);
		panel.add(harmonogramOswietlenia);
		
		btnWylaczWszystkie = new JButton("Wyłącz wszystkie");
		btnWylaczWszystkie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wylaczWszystkieSwiatla();
			}
		});
		btnWylaczWszystkie.setBounds(20, 215, 160, 40);
		panel.add(btnWylaczWszystkie);
		
		JTextPane txtpnOwietlenie = new JTextPane();
		txtpnOwietlenie.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		txtpnOwietlenie.setBackground(SystemColor.window);
		txtpnOwietlenie.setText("Oświetlenie");
		txtpnOwietlenie.setBounds(54, 19, 91, 25);
		panel.add(txtpnOwietlenie);
		
		txtpnHarmonogram = new JTextPane();
		txtpnHarmonogram.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnHarmonogram.setBackground(SystemColor.window);
		txtpnHarmonogram.setText("Harmonogram");
		txtpnHarmonogram.setBounds(51, 289, 97, 25);
		panel.add(txtpnHarmonogram);
		
		separator = new JSeparator();
		separator.setBounds(20, 267, 160, 10);
		panel.add(separator);
		
		txtpnWybierzPokj = new JTextPane();
		txtpnWybierzPokj.setBackground(SystemColor.window);
		txtpnWybierzPokj.setText("Wybierz pokój:");
		txtpnWybierzPokj.setBounds(19, 322, 161, 18);
		panel.add(txtpnWybierzPokj);
		
		panel.repaint();
		panel.validate();
		
	}
	
	
	void wlaczSwiatlo(Pomieszczenie p){
		p.wlaczSwiatlo();
	}
	

	void wylaczSwiatlo(Pomieszczenie p){
		p.wylaczSwiatlo();
	}
	
	
	void wylaczWszystkieSwiatla(){
		kuchnia.wylaczSwiatlo();
		checkKuchania.setSelected(false);
		salon.wylaczSwiatlo();
		checkSalon.setSelected(false);
		pokoj.wylaczSwiatlo();
		checkPokoj.setSelected(false);
		lazienka.wylaczSwiatlo();
		checkLazienka.setSelected(false);
		korytarz.wylaczSwiatlo();
		chckKorytarz.setSelected(false);
		
	}
	
	void ustawHarmonogram(String nazwa){
		Pomieszczenie tab[] = {kuchnia,pokoj,salon,korytarz,lazienka};
		panel.remove(harmonogramOswietlenia);
		for(int i =0;i<tab.length;i++){
			if(nazwa.equals(tab[i].nazwa)){
			harmonogramOswietlenia = new HarmonogramOswietlenia(tab[i]);
			harmonogramOswietlenia.setBounds(0, 420, 200, 180);
			panel.add(harmonogramOswietlenia);
			Thread hOswietlenia = new Thread(harmonogramOswietlenia);
			hOswietlenia.start();
			panel.validate();
			panel.repaint();
			//System.out.println(tab[i].nazwa);
			}
		}
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;){
			if(kuchnia.stanSwiatlo)lblKuchniaStan.setText("On!");
			else lblKuchniaStan.setText("Off");
			if(salon.stanSwiatlo)lblSalonStan.setText("On!");
			else lblSalonStan.setText("Off");
			if(pokoj.stanSwiatlo)lblPokojStan.setText("On!");
			else lblPokojStan.setText("Off");
			if(lazienka.stanSwiatlo)lblLazienkaStan.setText("On!");
			else lblLazienkaStan.setText("Off");
			if(korytarz.stanSwiatlo)lblKorytarzStan.setText("On!");
			else lblKorytarzStan.setText("Off");
			panel.validate();
			panel.repaint();		
	}
	}
}