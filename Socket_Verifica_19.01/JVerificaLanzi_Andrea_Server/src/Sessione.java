import java.util.ArrayList;

public class Sessione {
	
	  String nomeUtente;
	  Integer prezzoProposto;
	  int indiceItemDB;
	  
	    public Sessione(String nome, int index) {
	    	nomeUtente= nome;
	    	indiceItemDB=index;
	    }
	    
	    public void setPrezzoProposto(int prezzo){
	    	prezzoProposto=prezzo;
	    }
}
