package iHouse;

import java.util.ArrayList;
import java.util.List;

public class CzujnikTemperatury extends Thread{

	double aktualnaTemperatura;
	
	CzujnikTemperatury(){
		aktualnaTemperatura =20;
		
	}
	
	double odczytajTemperature(){
		return aktualnaTemperatura;
	}
	
	public void run(){
		for(;;){
		aktualnaTemperatura-=0.1;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(aktualnaTemperatura);
		}
		
		
	}
	
}
