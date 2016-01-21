import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class JVerificaFilaB_Server {
	public static void main(String args[])
	{
		ServerSocket sSocket;
		Socket connessione=null;
		int port = 3333;
		
		JFileCSV file = new JFileCSV();
        file.setFileName("DB.txt");
        
        ArrayList<Record> lista = new ArrayList<Record>();
        file.importaDB(lista);
		
		
		try
		{
			sSocket = new ServerSocket(port);
			System.out.println("In attesa di connessioni...");
			// ciclo infinito
			while (true)
			{
				connessione = sSocket.accept(); //attende che qualcuno si connetta
				System.out.println("Conesso :)");
				Utente ut1 = new Utente(connessione, lista, file);
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
