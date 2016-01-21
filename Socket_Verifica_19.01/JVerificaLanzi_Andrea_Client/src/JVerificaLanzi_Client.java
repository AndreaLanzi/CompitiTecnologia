import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JVerificaLanzi_Client {
	public static void main(String args[])
	{  
		//QUESTO é IL PROGRAMMA CHAT_CLIENT DA MODIFICARE
		Socket connessione = null;
		String server = "localhost";
		int port = 3333;
		InputStreamReader in, input;
		BufferedReader sIN, tastiera;
		OutputStream out;
		PrintWriter sOUT;
		String msgDaInviare;
		String msgRicevuto;
		try
			{
			connessione = new Socket(server, port);
			System.out.println("Connessione eseguita.");
			}
		catch (IOException e)
			{
			System.out.println(e);
			System.exit(-1);
			}
		try
			{
			// flusso in ingresso da socket
			in = new InputStreamReader(connessione.getInputStream());
			sIN = new BufferedReader(in);
			
			// flusso in uscita su socket
			out = connessione.getOutputStream();
			sOUT = new PrintWriter(out);
			
			// flusso in ingresso da tastiera
			input = new InputStreamReader(System.in);
			tastiera = new BufferedReader(input);
			
			
			
			//TODO:
			System.out.println("Comunica al server che vuoi partecipare all'asta inserendo il tuo nome:");
			msgDaInviare = tastiera.readLine();
			sOUT.println(msgDaInviare);
			sOUT.flush();
			
			while(true)  //il client continua ad aspettarsi che il server mandi articoli, quando il server invia "FINEASTA" il client muore.
			{
			
				
				//il server mi dice nomePrimoArticolo;prezzoInizialeArticolo:
				msgRicevuto = sIN.readLine();
				if(msgRicevuto.equals("FINEASTA"))
				{
					break; //kill client.
				}
				
				ArrayList<String> articolo = new ArrayList<String>(); //lista di due elementi: nome - prezzoIniziale
				
				StringTokenizer st = new StringTokenizer(msgRicevuto, ";");
			     while (st.hasMoreTokens()) {
			    	 articolo.add( st.nextToken() );
			     }
			     
			     
			     System.out.println("Nome articolo: " + articolo.get(0) + "\n Prezzo di partenza:" + articolo.get(1));
				
			     
			     //dico al server la mia offerta inerente all'articolo:
			     System.out.println("Comunica al server la tua offerta (oppure 0, se non sei interessato)");
			     //non posso inserire un numero piu piccolo del prezzo di partenza.
			     do{
				msgDaInviare = tastiera.readLine();
			     }while((Integer.parseInt(msgDaInviare)) < (Integer.parseInt(articolo.get(1))) );
			     
				sOUT.println(msgDaInviare);
				sOUT.flush();
					
				
				//attendo che tutti facciano l'offerta.
				
				
				//il server mi dice nomeVincitore;prezzoFinale:
				msgRicevuto = sIN.readLine();
				ArrayList<String> vincita = new ArrayList<String>(); //lista di due elementi: acquirenteVincente - prezzoFinale
				
				
				StringTokenizer str = new StringTokenizer(msgRicevuto, ";");
			     while (str.hasMoreTokens()) {
			    	 vincita.add( str.nextToken() );
			     }
			     System.out.println("Nome acquirente vincente: " + vincita.get(0) + "\n Prezzo finale:" + vincita.get(1));
					
			     
			     
			     
			}//end while loop
			
		}
		
		catch (IOException e)
		{
		System.out.println(e);
		}
		try
		{
		connessione.close();
		}
		catch (IOException e)
		{
		System.out.println(e);
		}
	
		}
}
