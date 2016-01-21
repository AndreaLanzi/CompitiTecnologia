package clockServer;
import java.net.*;
import java.io.*;
import java.util.Date;

public class clockServer {
	public static void main(String[] args) {
		ServerSocket sSocket;
		Socket connessione;
		int porta = 3333;
		// stream per gestire il flusso in output
		OutputStream out;
		PrintWriter sOUT;

		try {
			sSocket = new ServerSocket(porta);
			while (true) {
				System.out.println("In attesa di connessioni...");
				connessione = sSocket.accept();
				System.out.println("Connessione stabilita.");
				out = connessione.getOutputStream();
				sOUT = new PrintWriter(out);
				// invia l'informazione al client
				Date oggi = new Date();
				String info = oggi.toString();
				sOUT.println(info);
				sOUT.close();
				connessione.close();
				System.out.println("Connessione chiusa.");
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
