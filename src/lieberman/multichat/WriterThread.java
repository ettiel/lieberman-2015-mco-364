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

	public void run() { //need to synchronize access to the sockets so they dont mess each other up

		while (true) {
			String message;
			try {
				message = messages.take();
				//writeToSockets(message);
				//} catch (InterruptedException e){
				//e.printStackTrace();
				//}
				
				
				
				/*
				 * private void writeToSockets(String message){
				 * synchronized(sockets){
				 * Iterator<Socket> iter = sockets.iterator(); //more efficient to use iterator and linkedList than for loop and arrayList
				 * while(iter.hasNext()){
				 * try{
				 * PrintWriter out = new PrintWriter(s.getOutputStream());
				 * out.println(message);
				 * out.flush();
				 * } catch(IOException e){
				 * iter.remove();
				 * e.printStackTrace();
				 * }
				 * }
				 * }
				 * }
				 */

				for (Socket socket : sockets) {


					try { //has to be INSIDE for loop so that one closed socket doesnt stop looping to further sockets on the list
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