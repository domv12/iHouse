package iHouse;

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
		aktualnaTemperatura-=1;
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(aktualnaTemperatura);
		}
		
		
	}
	
}
