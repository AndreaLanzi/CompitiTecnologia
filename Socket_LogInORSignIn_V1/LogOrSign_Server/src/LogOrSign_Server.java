

import java.net.*;
import java.io.*;

public class LogOrSign_Server {
	public static void main(String args[])
	{
		ServerSocket sSocket;
		Socket connessione=null;
		int port = 3333;
		InputStreamReader in, input;
		BufferedReader sIN, tastiera;
		OutputStream out;
		PrintWriter sOUT;
		String msgRicevuto;
		
		try
		{
			sSocket = new ServerSocket(port);
			System.out.println("In attesa di connessioni...");
			// ciclo infinito
			while (true)
			{
				connessione = sSocket.accept(); //attende che qualcuno si connetta
				System.out.println("Connesso...");
				// flusso in uscita su socket
				out = connessione.getOutputStream();
				sOUT = new PrintWriter(out);
				
				// flusso in ingresso da socket
				in = new InputStreamReader(connessione.getInputStream());
				sIN = new BufferedReader(in);
				
				// flusso in ingresso da tastiera
				input = new InputStreamReader(System.in);
				tastiera = new BufferedReader(input);
			
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
