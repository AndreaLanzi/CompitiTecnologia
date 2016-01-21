import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Utente extends Thread {
	Socket connessione=null;
	InputStreamReader in, input;
	BufferedReader sIN, tastiera;
	OutputStream out;
	PrintWriter sOUT;
	String msgRicevuto;
	ArrayList<Record> lista;
	JFileCSV file;
	
public Utente(Socket conn,  ArrayList<Record> lista, JFileCSV file)
{
	this.connessione=conn;
	this.lista=lista;
	this.file=file;
	
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
			
			//Messaggio 1 o 2, se 1-> il client ha mandato il paese altrimenti ha mandato il CAP.
			msgRicevuto = sIN.readLine();
			if(msgRicevuto.equals("1"))  //RAMO 1: ricevo il PAESE
			{
				msgRicevuto = sIN.readLine();//pronto a ricevere il PAESE
				int j=0; //check per l'errore
				for(int i=0; i<lista.size(); i++)   //ramo msg=1 quindi faccio i controlli sul paese:
				{
					
					if (msgRicevuto.equals(lista.get(i).paese))
					{
						j=1;//ho trovato una corrispondenza nel mio DB quindi mando il CAP associato al paese ricevuto dal client
						sOUT.println(lista.get(i).CAP); 
						sOUT.flush();
						break; //interrompo il ciclo!!
					}
				}
				
				if(j==0) //controllo se il flag non è mai andato a 1 ed eventualmente stampo il mex di errore.
				{
					//non c'è nessun paese che si chiama così:
					sOUT.println("Non c'è nessun paese che si chiama così :(");
					sOUT.flush();
				}
				
			}
			if(msgRicevuto.equals("2"))//RAMO 2: ricevo il CAP
			{
				msgRicevuto = sIN.readLine();//pronto a ricevere il CAP
				int j=0; //check per l'errore
				for(int i=0; i<lista.size(); i++)   //ramo msg=2 quindi faccio i controlli sul CAP:
				{
					
					if (msgRicevuto.equals(lista.get(i).CAP))
					{
						j=1;//ho trovato una corrispondenza nel mio DB quindi mando il PAESE associato al CAP ricevuto dal client
						sOUT.println(lista.get(i).paese); 
						sOUT.flush();
						break; //interrompo il ciclo!!
					}
				}
				
				if(j==0) //controllo se il flag non è mai andato a 1 ed eventualmente stampo il mex di errore.
				{
					//non c'è nessun paese che ha questo CAP:
					sOUT.println("Non c'è nessun paese che ha questo CAP :(");
					sOUT.flush();
				}
				
			}
		
		}
	}
	catch(IOException e){
		System.out.println(e);
	}
}
}
