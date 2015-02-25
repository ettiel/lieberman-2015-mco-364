package lieberman.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JComponent;

public class WorldComponent extends JComponent{ 
	//responsible to draw everything to the screen
	
	private World world;
	private final int boxH = 10;
	private final int boxW = 10;
	private final int gridH = 50;
	private final int gridW = 50;

	
	public WorldComponent(World world){
		this.world = world;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
		//either pass graphics object and inside world do g.___
			//world.draw(g);
		
		//or get stuff from world
			//Snake snake = world.getSnake();
			//g.fillRect(arg0, arg1, arg2, arg3);
		
	}
	public void draw(Graphics g){
		g.clearRect(0, 0, boxW*gridW, boxH*gridH);
		drawGrid(g);
		drawSnake(g);
		//placeFood();
		drawFood(g);
	}
	
	public void drawGrid(Graphics g){
		g.drawRect(0, 0, gridW * boxW, gridH*boxH);
		for (int i = boxW; i<gridW*boxW; i+=boxW){ //vertical lines
			g.drawLine(i, 0, i, boxH*gridH);
		}
		
		for (int y=boxH; y<gridH*boxH; y+=boxH){
			g.drawLine(0, y, gridW*boxW, y); //horizontal lines
		}
	}
	
	public void drawSnake(Graphics g){
		g.setColor(Color.GREEN);
		for (Point p: world.getSnake().getPoints()){
			g.fillRect(p.x * boxW, p.y*boxH, boxW, boxH);
		}
		g.setColor(Color.BLACK);
	}
	
	public void drawFood(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(world.getFood().getFoodPoint().x *boxW, world.getFood().getFoodPoint().y *boxH, boxW, boxH);
		g.setColor(Color.BLACK);
	}

	public World getWorld() {
		return world;
	}
	
	public void placeFood(){
		Random rand = new Random();
		int randomX = rand.nextInt(gridW);
		int randomY = rand.nextInt(gridH);
		Point randomPoint = new Point(randomX, randomY);
		while(world.getSnake().getPoints().contains(randomPoint)){
			 randomX = rand.nextInt(gridW);
			 randomY = rand.nextInt(gridH);
			 randomPoint = new Point(randomX, randomY);
		}
		
		world.getFood().setFoodPoint(randomPoint);
		
	}



}