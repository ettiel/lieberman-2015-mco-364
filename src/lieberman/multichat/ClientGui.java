package lieberman.multichat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGui extends JFrame {

	private JPanel panel;
	private JTextField field;
	private JButton button;
	private JTextArea area;

	private MultiChatClient chatClient;

	public ClientGui() throws UnknownHostException, IOException {
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sendText();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		

		});

		chatClient = new MultiChatClient(area);
	}
	public void sendText() throws IOException {
		
		chatClient.sendMessage(field.getText());
		field.setText("");
	}

	public static void main(String args[]) {
		ClientGui chat;
		try {
			chat = new ClientGui();
			chat.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}