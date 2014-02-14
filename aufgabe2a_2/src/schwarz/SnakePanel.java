package schwarz;

import javax.swing.*;

import java.awt.*;

public class SnakePanel extends JPanel{
	private SnakeModel m;
	private int x = 200;
	private int y = 150;
	
	public SnakePanel(SnakeModel m){
		this.m = m;
		this.m.setX(this.x);
		this.m.setY(this.y);
	}
	
	public void paint(Graphics g){
		super.paintComponent(g);
		g.drawOval(x, y, 12, 12);
	}
	public void refresh(int x, int y){
		this.y = y;
		this.x = x;
		paint(this.getGraphics());
	}
}