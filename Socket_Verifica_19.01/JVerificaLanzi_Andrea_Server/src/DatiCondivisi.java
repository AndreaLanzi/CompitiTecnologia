import java.util.ArrayList;

public class DatiCondivisi {

	 private ArrayList<Record> DB; //
	  public  ArrayList<Sessione> sessions;
	  public String nomeVincitore;
	  JFileCSV gestoreFile;
	    public DatiCondivisi(ArrayList<Record> dataBase, JFileCSV gestoreFile) {
	
	    	this.DB= dataBase;
	    	sessions = new ArrayList<Sessione>();
	    	nomeVincitore="";
	    	this.gestoreFile= gestoreFile;
	    	
	    }
	    
	  
	    
	    
	    
	    public String cercaVincitore(){
	    	
	    	
	    	/*while(true)
	    	{
	    		//attendo che la lista sessioni sia arrivata a 3 elementi
	    		if(sessions.size()==3)
	    			break;
	    		
	    	}*/
	    	
	    	
	    	//questo non avverrà se non ci sono le proposte di tutti e 3 gli utenti!
	    	
	    	int max = 0;
	    	
	    	for(int i=0; i<sessions.size(); i++){
	    		int prezzoProp = sessions.get(i).prezzoProposto;
		    	if (prezzoProp>max)
		    		max = prezzoProp;
	    	}
	    	
	    	Sessione questaSessione = null;  //la tengo per usarla dopo.
	    	for(int i=0; i<sessions.size(); i++){
	    		if(sessions.get(i).prezzoProposto == max)
	    		{
	    			nomeVincitore = sessions.get(i).nomeUtente;
	    			questaSessione=sessions.get(i);
	    		}
	    	}
	    	
	    	
	    	//qui devo aggiungere il nome acquirente vincente e il prezzo finale al db ma non ho tempo!
	    	
	    	
	    	Record vecchio = DB.get(questaSessione.indiceItemDB);  //capisco a quale Item mi sto riferendo.
	    	Record nuovo = new Record(vecchio.nomeArticolo, vecchio.prezzoPartenza,questaSessione.prezzoProposto.toString(), questaSessione.nomeUtente);
	    	DB.set(questaSessione.indiceItemDB, nuovo); //Database sovrascritto.
	    	gestoreFile.scriviSuFile(DB);
	    	
	    	return nomeVincitore+";"+max;
	    	
	    }
	    
	   
	
	
}
