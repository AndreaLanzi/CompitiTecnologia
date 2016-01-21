package clockClient;
import java.net.*;
import java.io.*;

public class clockClient {
	public static void main(String[] args) {
		Socket connessione;
		// parametri di connessione
		String server = "localhost";
		int porta = 3333;
		// stream per gestire il flusso in input
		InputStream in;
		InputStreamReader input;
		BufferedReader sIN;
		try {
			connessione = new Socket(server, porta);
			System.out.println("Connessione aperta.");
			in = connessione.getInputStream();
			input = new InputStreamReader(in);
			sIN = new BufferedReader(input);
			// riceve i dati dal server
			String clock = sIN.readLine();
			System.out.println("Data e ora del server: " + clock);
			sIN.close();
			connessione.close();
			System.out.println("Connessione chiusa.");
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
