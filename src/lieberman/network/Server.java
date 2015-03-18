package lieberman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{


	
	public static void main(String args[]) {

		try {
			ServerSocket serverSocket = new ServerSocket(1234); // listens for
																// server's
																// socket
			ServerThread t = new ServerThread(serverSocket);
			t.start();
			
						
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
		
	}


