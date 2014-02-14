package schwarz;

import java.awt.event.*;

/**
 * Controller mit threads und keyListener für das Snake-Spiel
 * 
 * @author stephan schwarz
 */
public class SnakeController extends Thread implements KeyListener{
	private SnakeModel m;
	private SnakeView v;
	public int wert = 0;
	private int delay = 100;
	public boolean start = false;
	
	public SnakeController(int b, int h, int gesch){
		this.m = new SnakeModel(b, h);
		this.v = new SnakeView(this.m, this);
		switch(gesch){
		case 0:
			this.delay = 200;
			break;
		case 1:
			this.delay = 100;
			break;
		case 2:
			this.delay = 50;
			break;
		}
	}
	
	@Override
	/**
	 * keylistener, für die taste WASD und die Pfeiltasten
	 * @return void
	 */
	public void keyPressed(KeyEvent a) {
		this.start = true;
		if(a.getKeyCode() == 38 || a.getKeyCode() == 87){
			if(wert != 4 && wert != 1){
				wert = 1;
			}
		}
		if(a.getKeyCode() == 37 || a.getKeyCode() == 65){
			if(wert != 3 && wert != 2){
				wert = 2;
			}
		}
		if(a.getKeyCode() == 39 || a.getKeyCode() == 68){
			if(wert != 2 && wert != 3){
				wert = 3;
			}
		}
		if(a.getKeyCode() == 40 || a.getKeyCode() == 83){
			if(wert != 1 && wert != 4){
				wert = 4;
			}
		}
	}
	
	/**
	 * methode, damit die schlange sich dauerhaft bewegt
	 * @return void
	 */
	public void run(){
		for(int i =0;i<1 && m.moveable;){
			try { 
				sleep(this.delay); 
				switch(wert){
					case 1:
						this.m.up();
						break;
					case 4:
						this.m.down();
						break;
					case 2:
						this.m.left();
						break;
					case 3:
						this.m.right();
						break;
				}
			}catch(InterruptedException e) { 	
			} 
			this.v.repaint();
		}
	}
	@Override
	public void keyReleased(KeyEvent a) {	
	}
	@Override
	public void keyTyped(KeyEvent a) {
	}
}