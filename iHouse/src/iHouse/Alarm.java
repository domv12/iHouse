package iHouse;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alarm extends Thread {

	List<CzujnikAlarmu> czujnik ;

	
	public Alarm(){
		 czujnik = new ArrayList<CzujnikAlarmu>();
		 czujnik.add(new CzujnikAlarmu(1,"kuchnia"));
		 czujnik.add(new CzujnikAlarmu(2,"pokoj"));
		 czujnik.add(new CzujnikAlarmu(3,"salon"));
		 czujnik.add(new CzujnikAlarmu(4,"garaz")); 
	}
	
	public boolean sprawdzStan(){
		boolean stan = false;
		for(int i=0;i<czujnik.size();i++)
		{
			if(czujnik.get(i).GetStan()){
				stan=true;
				break;
			}
			else
			{	
				stan=false;
			}
		}
	return stan;
	}
	
	public void wlamSie() throws InterruptedException
	{
		Random rand = new Random();
		int  n = rand.nextInt(10);
		sleep(2000);
		System.out.println("Wylosowana liczba : " + n);
		for(int i=0;i<czujnik.size();i++){
			if(czujnik.get(i).getId()== n){
				System.out.println("Zmienilem stan czujnika : " + czujnik.get(i).getId());
				czujnik.get(i).SetStan();
				
				
			}
		};
	}
	
	@Override
	public void run() {
		for(;;){
			
			sprawdzStan();
			
			try {
			Thread.sleep(2000);
				wlamSie();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
			
		}
		
	}

	
	

