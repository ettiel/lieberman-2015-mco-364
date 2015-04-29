package lieberman.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread {

	private LinkedBlockingQueue<String> messages;
	private List<Socket> sockets;

	public WriterThread(LinkedBlockingQueue<String> messages,
			List<Socket> sockets) {
		this.messages = messages;
		this.sockets = sockets;
	}

	public void run() {

		while (true) {
			String message;
			try {
				message = messages.take();

				for (Socket socket : sockets) {


					try {
						OutputStream out = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(out);
						writer.println(message);
						writer.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
}