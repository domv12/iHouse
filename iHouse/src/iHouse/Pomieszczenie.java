package iHouse;

/**
 * symuluje pomieszczenie w domu
 */
public class Pomieszczenie {

	int id;
	boolean stanSwiatlo;
	String nazwa;   				
	
	Pomieszczenie(int Id,String n){
		id=Id;
		nazwa=n;
		stanSwiatlo=false;
	}
	
	/**
	 * wlacza swiatlo w danym pomieszczeniu
	 */
	 void wlaczSwiatlo(){
		 stanSwiatlo=true;
	 }
	 /**
	  * wlacza swiatlo w danym pomieszczeniu
	  */
	 void wylaczSwiatlo(){
		 stanSwiatlo=false;
	 }
	
}
