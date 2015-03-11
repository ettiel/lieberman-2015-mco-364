package lieberman.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String args[]) {

		Socket socket = null;

		try {
			socket = new Socket("localhost", 3771); // ip address, port number

			OutputStream out = socket.getOutputStream();

			PrintWriter writer = new PrintWriter(out);

			writer.println("What's up?");
			
			writer.println("Even in the future nothing works!");
			
			writer.println("Alas, earwax.");
			
			writer.flush();

			socket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}
}