package lieberman.snake;

public class SnakeMain {
	
	public static void main(String args[]) {
	
		final SnakeFrame snake = new SnakeFrame();
		snake.setVisible(true);
		
		Thread t = new Thread() {
			public void run() {
				while (true) {
					snake.repaint();
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
