package iHouse;

/**
 * symuluje czujnik alarmu 
 */
public class CzujnikAlarmu{
	   
    int id;
    boolean stan;
    String name;
   
    CzujnikAlarmu(int id, String name){
        this.name=name;
        this.id=id;
        this.stan=false;
    }
    
    public int getId(){
    	return this.id;
    }
    
    
    public boolean GetStan(){
		return this.stan;
    }
    
    public void SetStan(){
    	this.stan=true;
    }

    
}
