package lieberman.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	private Socket socket;

	public ChatClient() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 1234); // establishes connection
		
		// InputStream in = socket.getInputStream();
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(in));
	}

	public static void main(String[] args) throws IOException {
		ChatFrame window = new ChatFrame();
		window.setVisible(true);
	}

	public Socket getSocket() {
		return socket;
	}
}
