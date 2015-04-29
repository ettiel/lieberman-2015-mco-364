package lieberman.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiChatServer {

	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(1234);
		List<Socket> sockets = new ArrayList<Socket>();
		
		LinkedBlockingQueue<String> messages = new LinkedBlockingQueue<String>(); // will block at the take method and wait for there to be something to take
		
		while (true) {
			Socket socket = serverSocket.accept();
			sockets.add(socket);
		
		
		
		}
		
		
	}
	
}
