package iHouse;

import java.util.ArrayList;
import java.util.List;


public class Gsm {

	List<Integer> nr;
	
	Gsm(){
	nr = new ArrayList<Integer>();
	nr.add(897652345);
	nr.add(878245763);
	}
	
	String wyslijSMS(){
		return("Zgłoszono zagrożenie: "+String.valueOf(nr.get(0))+" \n"+String.valueOf(nr.get(1)));
	}
}
