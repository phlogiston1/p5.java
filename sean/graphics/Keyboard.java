package sean.graphics;

import java.awt.event.*;

public class Keyboard extends Mouse implements KeyListener{
    public boolean keyIsPressed = false;
    public char key = ' ';
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    public void addKeyboardListener(){
        System.out.println("adding listener");
        this.addKeyListener(this);
        if(frame  != null){
            frame.addKeyListener(this);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyIsPressed = true;
        key = e.getKeyChar();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyIsPressed = false;
    }
}