package lieberman.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class MultiChatClient implements ReaderListener{
	private Socket socket;
	private OutputStream out;
	private JTextArea textArea;
	
	private PrintWriter writer;

	public MultiChatClient(JTextArea textArea) throws UnknownHostException, IOException {
		socket = new Socket("localhost", 5003);
		out = socket.getOutputStream();
		this.textArea=textArea;
		writer = new PrintWriter(out);
		
		ReaderThread thread = new ReaderThread(socket,this);
		thread.start();
		
	}

	public void sendMessage(String text) {
		writer.println(text);

		writer.flush();
	}

	@Override
	public void onLineRead(String text) {
		textArea.append(text+"\n");
		
	}

	@Override
	public void onCloseSocket(Socket socket) {
		// TODO Auto-generated method stub
		
	}


}
