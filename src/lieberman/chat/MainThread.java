package lieberman.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class MainThread extends Thread {
	private Socket socket;
	private JTextArea area;

	public MainThread(Socket socket, JTextArea area) {
		this.socket = socket;
		this.area = area;
	}

	public void run() {
		try {
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				area.append(line);
				area.append("\n");

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
