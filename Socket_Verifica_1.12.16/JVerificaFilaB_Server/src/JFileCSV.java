import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class JFileCSV {

	   private String fileName;

	    public JFileCSV() {
	        fileName="\0";
	    }

	   void setFileName(String nomeFile){
	       fileName=nomeFile;
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

	            
	            int posComma1 = riga.indexOf(';', 0);	       
	            String paese = riga.substring(0, posComma1);

	            String cap = riga.substring(posComma1 + 1);


	            Record nuovo = new Record(paese, cap);

	            database.add(nuovo);
	        }                 
	    }
	    catch(Exception E)
	    {

	    }
	}

}
