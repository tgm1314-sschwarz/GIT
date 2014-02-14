package schwarz;

import java.awt.event.*;

public class SnakeController implements KeyListener{
	private SnakeModel m;
	private SnakeView v;
	public SnakeController(int b, int h){
		this.m = new SnakeModel(b, h);
		this.v = new SnakeView(this.m, this);
	}
	@Override
	public void keyPressed(KeyEvent a) {
		System.out.println(a.getKeyChar());
		if(a.getKeyCode() == KeyEvent.VK_LEFT){
			m.left();
			this.v.refresh(this.m.getX(), this.m.getY());
		}
	}
	@Override
	public void keyReleased(KeyEvent a) {
		
	}
	@Override
	public void keyTyped(KeyEvent a) {

	}
}
