import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class JConcerto_Client {
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
			
					while(true){
					
						System.out.println("Strumento da suonare?");
						String strumento = tastiera.readLine();
						
						sOUT.println(strumento);
						sOUT.flush();
						
						//Devo attendere la risposta del server
						msgRicevuto=sIN.readLine();
						System.out.println(msgRicevuto);
						if(msgRicevuto.equals("SI"))
							break;
						
						
					};
					
					
					while(true)
					{
						//SUONA
						System.out.println("Nota (maiusc o minusc)");
						String nota = tastiera.readLine();
						sOUT.println(nota);
						sOUT.flush();
						if(nota.equals("BYE"))  //se è BYE esce dal loop.
						{
							System.out.println("Hai chiuso!");
							break;
						}
					};
					
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

