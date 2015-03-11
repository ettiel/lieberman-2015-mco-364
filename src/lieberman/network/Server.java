package lieberman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String args[]) {

		try {
			ServerSocket serverSocket = new ServerSocket(3771); // listens for
																// server's
																// socket
			while (true) {
				Socket socket = serverSocket.accept(); // listens (called a
														// 'blocking call' b/c
														// will
														// stay at this line
														// until a
														// socket is returned)

				//HOMEWORK
				//once someone connects - start a thread that does all this!
				//this way the server can handle multiple sockets at once
				//test by running client twice
				InputStream in = socket.getInputStream();

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));

				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
