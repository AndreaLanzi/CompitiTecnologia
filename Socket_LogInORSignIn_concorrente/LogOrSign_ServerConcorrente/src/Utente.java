import java.net.*; 
import java.util.StringTokenizer;
import java.io.*;

public class Utente  extends Thread {

	Socket connessione=null;
	InputStreamReader in, input;
	BufferedReader sIN, tastiera;
	OutputStream out;
	PrintWriter sOUT;
	String msgRicevuto;
	
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
		while (true)
		{
			// stampa il messaggio ricevuto
			msgRicevuto = sIN.readLine();
			if (msgRicevuto == null)
			{
				 System.out.println("Il client ha chiuso");
				 break;
			}
			System.out.println(msgRicevuto);
			
		}
	}
	catch(IOException e){
		System.out.println(e);
	}
	
	
	
}
}
