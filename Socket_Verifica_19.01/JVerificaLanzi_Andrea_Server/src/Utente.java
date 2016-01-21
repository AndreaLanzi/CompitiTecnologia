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
	DatiCondivisi datiCondivisi;
	ArrayList<Record> dataBase;
	Semaphore semaforo;
	
	
public Utente(Socket conn, DatiCondivisi datiCondivisi, ArrayList<Record> dataBase, Semaphore sem)
{
	this.connessione= conn;
	this.datiCondivisi= datiCondivisi;
	this.dataBase=dataBase;
	this.semaforo= sem;
	
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
			int indexItem=0; //INDICE DELLA LISTA DEGLI ARTICOLI (nel primo ciclo mando il primo art. nel secondo il secondo ecc ecc...)
			
			// riceve il nome dal client
			msgRicevuto = sIN.readLine();
			if(msgRicevuto == null)
			{
				System.out.println("Il client non era interessato all'asta.");
				break;
			}

			//il client ha messo correttamente il suo nome quindi procedo:
			
			//aggiungo il nome alla lista utenti attivi (essendo una lista potrò sempre sapere quanti utenti attivi ci sono!
			Sessione nuovaSessione = new Sessione(msgRicevuto, indexItem); //creo un oggetto sessione con il nome utente che si riferisce ad uno specifico elemento del DB.
			//la sessione è composta da nomeUtente e da prezzoProposto, quindi la passo ai datiCondivisi solo dopo aver saputo il prezzo dal client
			
			
			while(true)
			{
			//invio nomeArticolo;prezzoIniziale
			String msgDaInviare =   dataBase.get(indexItem).nomeArticolo +";"+dataBase.get(indexItem).prezzoPartenza;
			
			sOUT.println(msgDaInviare);
			sOUT.flush();
			
			//ricevo il prezzo inviatomi dall'acquirente:
			msgRicevuto = sIN.readLine();
			nuovaSessione.setPrezzoProposto(Integer.parseInt(msgRicevuto));  //metto nella sessione (inizializzata alla riga 64) il prezzo proposto
			
			
			//nei dati condivisi c'è una lista di sessioni (ArrayList<Sessioni>) chiamata sessions.
			
			
			semaforo.P();
			datiCondivisi.sessions.add(nuovaSessione);  //boh non va ma è giusto cosi!!!!
			semaforo.V();
			
			
			
			//prendo il nome del vincitore (solo quando viene scritto) e poi stampo sul client il nome.
			while(true)
			{
				if(datiCondivisi.sessions.size()==3)
				{
					msgDaInviare = datiCondivisi.cercaVincitore();
					break;
				}
			}

			sOUT.println(msgDaInviare);
			sOUT.flush();
			
			indexItem++;
			if(indexItem>dataBase.size())
				break;
			}//end while della continuazione della lettura file.
		}
	}
	catch(IOException e){
		System.out.println(e);
	}
	
	
	
}

}
