package lieberman.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class Snake {
	private LinkedList<Point> points;
	private int direction = Direction.NONE;
	
	public Snake(){
		points = new LinkedList<Point>();
		points.add(new Point(1, 1));
		points.add(new Point(1, 2));
		points.add(new Point(1, 3));
	}

	public void move(){
		Point head = points.peekFirst();
		Point newPoint = head;
		switch (direction){
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
		
		points.remove(points.peekLast());
		
		if (newPoint.x <0 || newPoint.x > 50){
			//out of bounds - end thread
			return;
		}
		else if (newPoint.y<0 || newPoint.y>50){
			//out of bounds - end thread
			return;

		}
		
		else if (points.contains(newPoint)){
			//ate itself - end thread
			return;
			
		}
		else{
			points.push(newPoint);
		}
		
		}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}

	public LinkedList<Point> getPoints() {
		return points;
	}


}
