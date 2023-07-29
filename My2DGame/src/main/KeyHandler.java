package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public boolean upPressed,downPressed,leftPressed,rightPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();
		if(code==KeyEvent.VK_W) {//when user presses W key
			upPressed=true;
		}
        if(code==KeyEvent.VK_S) {//when user presses S key
			downPressed=true;
		}
        if(code==KeyEvent.VK_A) {//when user presses A key
			leftPressed=true;
		}
        if(code==KeyEvent.VK_D) {//when user presses D key
			rightPressed=true;
		}
        
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code=e.getKeyCode();
		if(code==KeyEvent.VK_W) {//when user presses W key
			upPressed=false;
		}
        if(code==KeyEvent.VK_S) {//when user presses S key
			downPressed=false;
		}
        if(code==KeyEvent.VK_A) {//when user presses A key
			leftPressed=false;
		}
        if(code==KeyEvent.VK_D) {//when user presses D key
			rightPressed=false;
		}
	}

}
