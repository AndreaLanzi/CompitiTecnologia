import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JFileCSV {


	   private String fileName;

	    public JFileCSV() {
	        fileName="\0";
	    }

	   void setFileName(String nomeFile){
	       fileName=nomeFile;
	   }
	   
	  public void scriviSuFile(ArrayList<Record> database){
		  try
		     {
		          FileOutputStream prova = new FileOutputStream(fileName);
		          PrintStream scrivi = new PrintStream(prova);
		          for(int i=0;i<database.size();i++)
		          {
		                scrivi.println(database.get(i).nomeArticolo+";"+database.get(i).prezzoPartenza+";"+database.get(i).prezzoFinale+";"+database.get(i).nomeAcquirente+"\n");
		                
		          }
		      }
		      catch (IOException e)
		      {
		          System.out.println("Errore: " + e);
		          System.exit(1);
		      }
	  }
	   
	    
	   
	   @SuppressWarnings("resource")
	public void importaDB(ArrayList<Record> database)
		{
			
	        try{
	         FileReader f;
	         f= new FileReader(fileName);

	         BufferedReader b;
	         b=new BufferedReader(f);
	         
	                    
	        String riga="";
	      
	        while(true)
	        {
	            riga = b.readLine();
	            if(riga==null)
	                break;

	            
	            //nomeArticolo,prezzoPartenza,prezzoFinale,nomeAcquirente
	            
	            int posComma1 = riga.indexOf(';', 0);	//12       
	            String nomeArticolo = riga.substring(0, posComma1);//nomeArticolo
	            int posComma2 = riga.indexOf(';', posComma1+1);//15
	            String prezzoPartenza = riga.substring(posComma1 + 1,posComma2);
	            int posComma3 = riga.indexOf(';', posComma2+1);
	            String prezzoFinale = riga.substring(posComma2 + 1, posComma3);
	            String nomeAcquirente = riga.substring(posComma3+1);
	            

	            Record nuovo = new Record(nomeArticolo, prezzoPartenza, prezzoFinale, nomeAcquirente);

	            database.add(nuovo);
	        }
	        
	            
	        
	    }
	    catch(Exception E)
	    {

	    }
	}

}
