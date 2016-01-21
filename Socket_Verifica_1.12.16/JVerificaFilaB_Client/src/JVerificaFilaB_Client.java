import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class JVerificaFilaB_Client {
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
			
			
				while(true) //vado avanti finché l'utente non sceglie l'opzione o 1 o 2
				{

					System.out.println("[1]Metti paese o [2]Metti CAP?");  //Menu
						String inputMenu= tastiera.readLine();
					if(inputMenu.equals("1"))
					{			
						sOUT.println("1");
						sOUT.flush();
						
						System.out.println("Inserisci Paese: ");
						msgDaInviare = tastiera.readLine();
						
						sOUT.println(msgDaInviare);
						sOUT.flush();
						break;
					}
					else if(inputMenu.equals("2"))
					{
						sOUT.println("2");
						sOUT.flush();
						
						System.out.println("Inserisci CAP: ");
						msgDaInviare = tastiera.readLine();
						
						sOUT.println(msgDaInviare);
						sOUT.flush();
						break;
					}
					else{ System.out.println("Le opzioni sono o 1 o 2!!!"); } //gestione errore del menu.
					
				}
					
					
					//se prima ho scelto il paese il server mi manda il CAP e viceversa.
					msgRicevuto=sIN.readLine(); 
					System.out.println(msgRicevuto); //Stampo il CAP o il PAESE (a seconda di quello che ho scelto prima) o comunque un mex di errore perché nel DB non è presente quello che gli ho mandato.
				
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
