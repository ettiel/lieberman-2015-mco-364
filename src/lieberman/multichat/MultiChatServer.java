package lieberman.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiChatServer implements ReaderListener {

	private Socket socket;
	private LinkedBlockingQueue<String> messages;
	private List<Socket> sockets;
	private WriterThread writer;

	public MultiChatServer() {
		messages = new LinkedBlockingQueue<String>(); // will block at the take
														// method and wait for
														// there to be something
														// to take
		sockets = new ArrayList<Socket>();
		writer = new WriterThread(messages, sockets);
		writer.start();

		try {

			ServerSocket serverSocket = new ServerSocket(1234);

			while (true) {
				Socket socket = serverSocket.accept();
				sockets.add(socket);
				ReaderThread thread = new ReaderThread(socket, this);
				thread.start();
			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) throws IOException {

		MultiChatServer MCServer = new MultiChatServer();

	}

	@Override
	public void onLineRead(String line) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCloseSocket(Socket socket) {
		// TODO Auto-generated method stub

	}

}
