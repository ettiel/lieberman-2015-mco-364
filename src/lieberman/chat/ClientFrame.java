package lieberman.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame {

	private JPanel panel;
	private JTextField field;
	private JButton button;
	private JTextArea area;

	private Socket socket;

	public ClientFrame() throws IOException {

		setTitle("CHAT");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		field = new JTextField();
		button = new JButton("SEND");

		panel.add(field, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);

		area = new JTextArea();

		add(area, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		socket = new Socket("localhost", 1234);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = field.getText() + "\n";
				area.setText(area.getText() + message);

				try {
					OutputStream out = socket.getOutputStream();
					out.write(message.getBytes());
					out.flush();
					field.setText("");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		setVisible(true);

		new MainThread(socket, area).start();

	}

	public static void main(String[] args) {
		try {
			new ClientFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
