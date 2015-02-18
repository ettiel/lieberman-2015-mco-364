package lieberman.snake;

public class GameLoopThread extends Thread{
	
	private WorldComponent component;

	
	
	public GameLoopThread(WorldComponent comp) {
		
		 this.component = component;
		
		
	}
	
	public void run(){
		while(true){
		
			//generate food
			//move snake
			//check if eats food
			//check if out
			
			component.repaint();
		
		}
	}

	
	
	
}
