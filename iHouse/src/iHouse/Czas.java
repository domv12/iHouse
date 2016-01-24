package iHouse;

public class Czas {

	int godziPocz[];
	int godziKon[];
	
	Czas(int pocz[], int koniec[]){
		
		godziPocz = new int[2];
		godziKon = new int[2];
		
		
		for(int i=0;i<pocz.length;i++){
		godziPocz[i]=pocz[i];
		godziKon[i]=koniec[i];
		}
	}
	
}
