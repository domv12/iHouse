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
	
	/**
	 * Create the panel.
	 */
	public SterowanieOswietleniem() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		panel.setLayout(null);
		
		kuchnia = new Pomieszczenie(1,"kuchnia");
		salon = new Pomieszczenie(2,"salon");
		pokoj = new Pomieszczenie(3,"pokoj");
		lazienka = new Pomieszczenie(4,"lazienka");
		korytarz = new Pomieszczenie(5,"korytarz");
		
		JLabel lblKuchnia = new JLabel("kuchnia");
		lblKuchnia.setBounds(10, 11, 46, 14);
		panel.add(lblKuchnia);
		
		JLabel lblSalon = new JLabel("salon");
		lblSalon.setBounds(10, 36, 46, 14);
		panel.add(lblSalon);
		
		JLabel lblLazienka = new JLabel("lazienka");
		lblLazienka.setBounds(10, 61, 46, 14);
		panel.add(lblLazienka);
		
		JLabel lblPokoj = new JLabel("pokoj");
		lblPokoj.setBounds(10, 86, 46, 14);
		panel.add(lblPokoj);
		
		JLabel lblKorytarz = new JLabel("korytarz");
		lblKorytarz.setBounds(10, 114, 46, 14);
		panel.add(lblKorytarz);
		
		lblKuchniaStan = new JLabel("");
		lblKuchniaStan.setBounds(66, 11, 86, 14);
		panel.add(lblKuchniaStan);
		
		lblSalonStan = new JLabel("");
		lblSalonStan.setBounds(66, 36, 86, 14);
		panel.add(lblSalonStan);
		
		lblLazienkaStan = new JLabel("");
		lblLazienkaStan.setBounds(76, 61, 76, 14);
		panel.add(lblLazienkaStan);
		
		lblPokojStan = new JLabel("");
		lblPokojStan.setBounds(66, 86, 86, 14);
		panel.add(lblPokojStan);
		
		lblKorytarzStan = new JLabel("");
		lblKorytarzStan.setBounds(66, 114, 86, 14);
		panel.add(lblKorytarzStan);
		
		checkKuchania = new JCheckBox("");
		checkKuchania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(	checkKuchania.isSelected()) kuchnia.wlaczSwiatlo();
				else kuchnia.wylaczSwiatlo();
			}
		});
		
		checkKuchania.setBounds(158, 11, 27, 23);
		panel.add(checkKuchania);
		
		checkSalon = new JCheckBox("");
		checkSalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkSalon.isSelected()) salon.wlaczSwiatlo();
				else salon.wylaczSwiatlo();
			}
		});
		
		checkSalon.setBounds(158, 27, 27, 23);
		panel.add(checkSalon);
		
		checkLazienka = new JCheckBox("");
		checkLazienka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkLazienka.isSelected()) lazienka.wlaczSwiatlo();
				else lazienka.wylaczSwiatlo();
			}
		});
		
		checkLazienka.setBounds(158, 52, 27, 23);
		panel.add(checkLazienka);
		
		checkPokoj = new JCheckBox("");
		checkPokoj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkPokoj.isSelected()) pokoj.wlaczSwiatlo();
				else pokoj.wylaczSwiatlo();
			}
		});
		checkPokoj.setBounds(158, 78, 27, 23);
		panel.add(checkPokoj);
		
		chckKorytarz = new JCheckBox("");
		chckKorytarz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckKorytarz.isSelected()) korytarz.wlaczSwiatlo();
				else korytarz.wylaczSwiatlo();
			}
		});
		chckKorytarz.setBounds(158, 105, 27, 23);
		panel.add(chckKorytarz);
		
		JScrollPane listScrollPane = new JScrollPane();
		String[] ar = {"kuchnia", "salon", "lazienka","pokoj","korytarz"};
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
		listScrollPane.setBounds(32, 160, 86, 54);
		panel.add(listScrollPane);
		
		harmonogramOswietlenia = new HarmonogramOswietlenia(kuchnia);
		panel.add(harmonogramOswietlenia);
		
		btnWylaczWszystkie = new JButton("wylacz wszystkie");
		btnWylaczWszystkie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wylaczWszystkieSwiatla();
			}
		});
		btnWylaczWszystkie.setBounds(10, 237, 142, 23);
		panel.add(btnWylaczWszystkie);
		
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
			harmonogramOswietlenia.setBounds(200, 15, 115, 180);
			panel.add(harmonogramOswietlenia);
			Thread hOswietlenia = new Thread(harmonogramOswietlenia);
			hOswietlenia.start();
			panel.validate();
			panel.repaint();
			System.out.println(tab[i].nazwa);
			}
		}
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;){
			if(kuchnia.stanSwiatlo)lblKuchniaStan.setText("wlaczone!");
			else lblKuchniaStan.setText("wylaczone");
			if(salon.stanSwiatlo)lblSalonStan.setText("wlaczone!");
			else lblSalonStan.setText("wylaczone");
			if(pokoj.stanSwiatlo)lblPokojStan.setText("wlaczone!");
			else lblPokojStan.setText("wylaczone");
			if(lazienka.stanSwiatlo)lblLazienkaStan.setText("wlaczone!");
			else lblLazienkaStan.setText("wylaczone");
			if(korytarz.stanSwiatlo)lblKorytarzStan.setText("wlaczone!");
			else lblKorytarzStan.setText("wylaczone");
			panel.validate();
			panel.repaint();		
	}
	}
}