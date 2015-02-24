package lieberman.snake;

public class SnakeMain {
	
	public static void main(String args[]) {
	
		final SnakeFrame snakeFrame = new SnakeFrame();
		snakeFrame.setVisible(true);
		
		Thread t = new Thread() {
			public void run() {
				while (true) {
					snakeFrame.repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		t.start();
		
	}

}
