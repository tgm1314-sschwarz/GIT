package schwarz;

import java.awt.*;

import javax.swing.*;

/**
 * View, in der das JFrame ist
 * 
 * @author stephan schwarz
 */
public class SnakeView extends JFrame{
	private SnakeModel m;
	private SnakeController c;
	public SnakePanel p;
	
	public SnakeView(SnakeModel m, SnakeController c){
		this.m = m;
		this.c = c;
		this.p = new SnakePanel(this.m, this);
		Color gruen1 = new Color(69,139,0);
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.CENTER);
		
		addKeyListener(this.c);
		setSize(this.m.getBreite()+10,this.m.getHoehe()+10);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}