import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class LogOrSign_Client {
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
			
			System.out.println("[R]egistrare o [L]oggarsi?");
				if(tastiera.readLine().equals("L"))
				{			
					System.out.println("Inserisci Usn: ");
					String usn = tastiera.readLine();
					
					System.out.println("Inserisci Psw: ");
					String psw = tastiera.readLine();
					
					msgDaInviare = "\"L\";\" "+usn+"\";\""+psw+"\"";  // mess= "nome";"psw"
					sOUT.println(msgDaInviare);
					sOUT.flush();
				}
				else
				{
					System.out.println("Inserisci Email: ");
					String email = tastiera.readLine();

					System.out.println("Inserisci Usn: ");
					String usn = tastiera.readLine();
					
					System.out.println("Inserisci Psw: ");
					String psw = tastiera.readLine();
					
					msgDaInviare = " \"R\";\""+email+"\";\""+usn+"\";\""+psw+"\"";  // mess= "email";"nome";"psw"
					sOUT.println(msgDaInviare);
					sOUT.flush();
					
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
