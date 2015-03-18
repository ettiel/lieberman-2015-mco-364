package lieberman.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatFrame extends JFrame{

	private JPanel panel;
	private JTextField field;
	private JButton button;
	private JTextArea area;
	
	private ChatClient chatClient;
	
	public ChatFrame() throws UnknownHostException, IOException{
		
		setTitle("CHAT");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		chatClient = new ChatClient();
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		field = new JTextField();
		button = new JButton("SEND");
	
		panel.add(field, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);

		area = new JTextArea();
		
		add(area, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String message = field.getText() + "\n";
				area.setText(area.getText() + message);
				
				OutputStream out;
				try {
					out = chatClient.getSocket().getOutputStream();
					out.write(message.getBytes());
					out.flush();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
	
}
