package lieberman.pong; 

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameInput implements KeyListener{
	
	GameMain game;

	
	public GameInput(GameMain game){
		this.game = game;
		game.addKeyListener(this);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	int	key = e.getKeyCode();
		
		if (key==e.VK_W){
			game.player1.down = false;
			game.player1.up = true;
		}
		if (key==e.VK_S){
			
			game.player1.up = false;
			game.player1.down = true;
			
		}
		if (key==e.VK_UP){
			game.player2.down = false;
			game.player2.up = true;
		}
		if (key==e.VK_DOWN){
			
			game.player2.up = false;
			game.player2.down = true;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
//	key = e.getKeyCode();
//		
//		if (key==e.VK_W){
//			GameMain.player1.down = false;
//			GameMain.player1.up = true;
//		}
//		if (key==e.VK_S){
//			
//			GameMain.player1.up = false;
//			GameMain.player1.down = true;
//			
//		}
//		if (key==e.VK_UP){
//			GameMain.player2.down = false;
//			GameMain.player2.up = true;
//		}
//		if (key==e.VK_DOWN){
//			
//			GameMain.player2.up = false;
//			GameMain.player2.down = true;
//			
//		}
		
	}

}
