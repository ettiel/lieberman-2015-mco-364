package lieberman.snake;

import java.awt.Point;

public class GameLoopThread extends Thread {

	private WorldComponent component;

	public GameLoopThread(WorldComponent component) {

		this.component = component;

	}

	public void run() {
		while (true) {

			component.placeFood(); //generate new food
			
			component.getWorld().getSnake().move(); //move snake (add head, remove tail)
			
			 
			
			if(component.getWorld().getSnake().getPoints().contains(component.getWorld().getFood())){	// check if eats food (if yes, add)
				
				Point head = component.getWorld().getSnake().getPoints().peekFirst();
				Point newPoint = head;
				
				Point addPoint = (Point) newPoint.clone();
				
				switch (component.getWorld().getSnake().getDirection()){
				case Direction.UP:
					newPoint = new Point (head.x, head.y-1);
					break;
				case Direction.DOWN:
					newPoint = new Point (head.x, head.y+1);
					break;
				case Direction.RIGHT:
					newPoint = new Point (head.x-1, head.y);
					break;
				case Direction.LEFT:
					newPoint = new Point (head.x+1, head.y);
					break;
					
				}
				component.getWorld().getSnake().getPoints().push(addPoint);
			
			}
		
			

			component.repaint();
			
			

		}
	}

}