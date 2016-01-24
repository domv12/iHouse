package iHouse;

public class Pomieszczenie {

	int id;
	boolean stanSwiatlo;
	String nazwa;   				///dodac do diagramu
	
	Pomieszczenie(int Id,String n){
		id=Id;
		nazwa=n;
		stanSwiatlo=false;
	}
	
	 void wlaczSwiatlo(){
		 stanSwiatlo=true;
	 }
	 void wylaczSwiatlo(){
		 stanSwiatlo=false;
	 }
	
}
