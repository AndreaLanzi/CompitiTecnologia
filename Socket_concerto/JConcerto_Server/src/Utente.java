import java.net.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;

public class Utente  extends Thread {

	Socket connessione=null;
	InputStreamReader in, input;
	BufferedReader sIN, tastiera;
	OutputStream out;
	PrintWriter sOUT;
	String msgRicevuto;
	ArrayList <String> lista;
	
	
public Utente(Socket conn)
{
	this.connessione=conn;
	try{
		//apre i flussi in e out della socket
		out = connessione.getOutputStream();
		sOUT = new PrintWriter(out);
		in = new InputStreamReader(connessione.getInputStream());
		sIN = new BufferedReader(in);

		// anche il flusso in ingresso da tastiera
		input = new InputStreamReader(System.in);
		tastiera = new BufferedReader(input);	
	}
	catch(IOException e){
		System.out.println(e);
	}
	
}


public void run() {
	// TODO Auto-generated method stub
	try{
		
		importaVettore("listaStrumenti.txt");
		while (true)
		{
			msgRicevuto = sIN.readLine();
			int j=0; //check per l'errore
			for(int i=0; i<lista.size(); i++)
			{
				
				if (msgRicevuto.equals(lista.get(i)))
				{
					sOUT.println("SI");
					sOUT.flush();
					j=1;
					break;
				}
			}
				if(j==0)
				{
					sOUT.println("NO");
					sOUT.flush();
				}
					
			
			System.out.println(msgRicevuto); //SCRIVO SU FILE lo strumento
			
			while(true)
			{
				String nota = sIN.readLine();
				System.out.println(nota); //SCRIVO SU FILE la nota
				if(nota.equals("BYE"))
					break;
			}
			
		}
	}
	catch(IOException e){
		System.out.println(e);
	}
	
	
	
}

	public void importaVettore(String nomeFile)
	{	try{
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(nomeFile));
		String linea="";
		lista = new ArrayList<String>();
		while ( (linea = reader.readLine()) != null)
		{
			   lista.add( linea );
			
			
		}
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
