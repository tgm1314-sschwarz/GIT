package schwarz;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Panel in der die Schlange sich bewegt, mit hintergrund und paint Methode
 * 
 * @author stephan schwarz
 */
public class SnakePanel extends JPanel{
	public SnakeModel m;
	public SnakeView v;
	private int x1;
	private int y1;
	private int farbe;
	
	public SnakePanel(SnakeModel m, SnakeView v){
		this.m = m;
		this.v = v;
		this.x1 = m.randomEssenX();
		this.y1 = m.randomEssenY();
		this.farbe = this.m.farbe();
	}
	
	//colours
	Color rot = new Color(255,0,0);
	Color schlange = new Color(124,252,0);
	Color grau = new Color(82,82,82);
	Color grauH = new Color(143,143,143);
	Color gruen2 = new Color(107,142,35);
	Color blau = new Color(0,191,255);
	Color gelb = new Color(255,215,0);
	Color rosa = new Color(240,128,128);
	Color orange = new Color(255,69,0);
	Color black = new Color(0,0,0);
	Color weiss = new Color(255,255,255);
	Font f = new Font("Arial", Font.BOLD, 20);
	
	//images pfade nicht dynamisch...
	Image background1 = Toolkit.getDefaultToolkit().getImage("C://Users/d4rkor3/Desktop/sew/bilder/snake_background.png");
	Image walls1 = Toolkit.getDefaultToolkit().getImage("C://Users/d4rkor3/Desktop/sew/bilder/snake_walls.png");
	Image walls2 = Toolkit.getDefaultToolkit().getImage("C://Users/d4rkor3/Desktop/sew/bilder/snake_walls2.png");
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(background1, 0, 0, this);
		Iterator <Point> i = m.getLinkedList().iterator();
		Point p = new Point();
		for(;i.hasNext()==true;){
			p = i.next();
			g.setColor(schlange);
			g.fillRect(p.x, p.y, 10, 10);
			this.m.ueberpruefen();
		}
		//Walls
		g.setColor(grau);
		g.drawImage(walls1, 280, 0, this);
		g.drawImage(walls2, 0, 280, this);
		//g.fillRect(280, 0, 20, 600);
		//g.fillRect(0, 280, 600, 20);
		
		//Frucht
		switch(farbe){
		case 0:
			g.setColor(rot);
			break;
		case 1:
			g.setColor(blau);
			break;
		case 2:
			g.setColor(gelb);
			break;
		case 3:
			g.setColor(rosa);
			break;
		case 4:
			g.setColor(orange);
			break;
		}
		g.fillRect(x1, y1, 10, 10);
		
		//Rand
		g.setColor(gruen2);
		g.fillRect(0, 0, 10, 600);
		g.fillRect(0, 0, 600, 10);
		g.fillRect(585, 0, 20, 600);
		g.fillRect(0, 565, 600, 20);
		
		//Score Rect
		g.setColor(grauH);
		g.fillRect(277, 277, 25, 25);
		//Score
		g.setColor(black);
		g.setFont(f);
		g.drawString(m.getScore()+"",280,297);
		
		//Fruchtabfrage
		if(y1==p.y && x1==p.x){
			//Fruchtspawn
			this.x1 = m.randomEssenX();
			this.y1 = m.randomEssenY();
			this.farbe = m.farbe();
			this.m.setLaenge();
			this.m.setScore();
			g.drawString(m.getScore()+"",300,300);
		}
		//Spielfeldrandabfrage + wandabfrage
		if(p.x>=m.getBreite()-10){
			p.x = 10;
		}
		if(p.y>=m.getHoehe()-30){
			p.y = 10;
		}
		if(p.x<=0){
			p.x = m.getBreite()-10;
		}
		if(p.y<=0){
			p.y = m.getHoehe()-30;
		}
		
		if(290==p.x){
			System.out.println("Score: " + m.getScore());
			m.moveable = false;
			System.exit(0);
		}
		if(280==p.x){
			System.out.println("Score: " + m.getScore());
			m.moveable = false;
			System.exit(0);
		}
		if(290==p.y){
			System.out.println("Score: " + m.getScore());
			m.moveable = false;
			System.exit(0);
		}
		if(280==p.y){
			System.out.println("Score: " + m.getScore());
			m.moveable = false;
			System.exit(0);
		}
	}
	public void setBackground(int i, int j, int k) {
		
	}
}