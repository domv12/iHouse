package iHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * wysyla komunikat do wlasciciela oraz ochrony w razie wlamania
 */
public class Gsm {

	List<Integer> nr;
	
	Gsm(){
	nr = new ArrayList<Integer>();
	nr.add(897652345);
	nr.add(878245763);
	}
	
	/**
	 * wysyla sms z informacja o wlamaniu
	 */
	String wyslijSMS(){
		return("Zgłoszono zagrożenie: "+String.valueOf(nr.get(0))+" \n"+String.valueOf(nr.get(1)));
	}
}
