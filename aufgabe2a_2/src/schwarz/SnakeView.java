package schwarz;

import java.awt.*;

import javax.swing.*;

public class SnakeView extends JFrame{
	private SnakeModel m;
	private SnakeController c;
	private SnakePanel p;
	
	public SnakeView(SnakeModel m, SnakeController c){
		this.m = m;
		this.c = c;
		this.p = new SnakePanel(this.m);
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.CENTER);
		
		p.addKeyListener(c);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void refresh(int x, int y){
		p.refresh(x, y);
	}
}