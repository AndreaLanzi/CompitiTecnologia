

import java.net.*;
import java.io.*;


public class JConcerto_Server {
	
	public static void main(String args[])
	{
		ServerSocket sSocket;
		Socket connessione=null;
		int port = 3333;
		
		
		try
		{
			sSocket = new ServerSocket(port);
			System.out.println("In attesa di connessioni...");
			// ciclo infinito
			while (true)
			{
				connessione = sSocket.accept(); //attende che qualcuno si connetta
				System.out.println("Conesso :)");
				Utente ut1 = new Utente(connessione);
				ut1.start();
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
