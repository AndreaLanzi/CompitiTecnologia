import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class JVerificaLanzi_Server {
	public static void main(String args[])
	{
		ServerSocket sSocket;
		Socket connessione=null;
		int port = 3333;
		
		
		//IMPORTO IL DB da CSV a LISTA DI RECORD(classe contenente i 4 valori).
		ArrayList<Record> dataBase = new ArrayList<Record>();
		JFileCSV leggiDB = new JFileCSV();
		leggiDB.setFileName("database.txt");
		leggiDB.importaDB(dataBase);
		
		DatiCondivisi datiCondivisi = new DatiCondivisi(dataBase, leggiDB);
		Semaphore sem = new Semaphore(1);
		
		
		try
		{
			sSocket = new ServerSocket(port);
			System.out.println("In attesa di connessioni...");
			
			
			
			// ciclo infinito
			while (true)
			{
				connessione = sSocket.accept(); //attende che qualcuno si connetta
				System.out.println("Conesso :)");
				Utente ut1 = new Utente(connessione, datiCondivisi, dataBase, sem);
				
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
