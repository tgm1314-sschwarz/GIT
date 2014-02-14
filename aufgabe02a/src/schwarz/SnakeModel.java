package schwarz;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Model mit logik für das Snake-Spiel
 * 
 * @author stephan schwarz
 */
public class SnakeModel {
	public LinkedList<Point> schlange;
	private int schrittweite;
	private int breite;
	private int hoehe;
	private int x = 0;
	private int y = 0;
	private Iterator <Point> i;
	public boolean moveable = true;
	public final int SCHRITTWEITE = 10;
	private int score = 0;
	private int laenge = 4;
	
	public SnakeModel(int b, int h){
		this.breite = b;
		this.hoehe = h;
		
		this.schlange = new LinkedList<Point>();
		this.schlange.add(new Point(250, 250));
	}
	
	/**
	 * methode, damit die schlange nach oben gehen kann
	 * @return void
	 */
	public void up(){
		Point p = new Point(schlange.getLast());
		p.y -= SCHRITTWEITE;
		schlange.add(p);
		if(schlange.size()==laenge){
			schlange.removeFirst();
		}
	}
	
	/**
	 * methode, damit die schlange nach unten gehen kann
	 * @return void
	 */
	public void down(){
		Point p = new Point(schlange.getLast());
		p.y += SCHRITTWEITE;
		schlange.add(p);
		if(schlange.size()==laenge){
			schlange.removeFirst();
		}
	}
	
	/**
	 * methode, damit die schlange nach links gehen kann
	 * @return void
	 */
	public void left(){
		Point p = new Point(schlange.getLast());
		p.x -= SCHRITTWEITE;
		schlange.add(p);
		if(schlange.size()==laenge){
			schlange.removeFirst();
		}
	}
	/**
	 * methode, damit die schlange nach rechts gehen kann
	 * @return void
	 */
	public void right(){
		Point p = new Point(schlange.getLast());
		p.x += SCHRITTWEITE;
		schlange.add(p);
		if(schlange.size()==laenge){
			schlange.removeFirst();
		}
	}
	/**
	 * überpfrüft, ob die schlange sich selber frisst
	 * @return void
	 */
	public void ueberpruefen(){
		this.i = schlange.iterator();
		while(i.hasNext()){
			Point p = i.next();
			if(i.hasNext()){
				if(p.x == schlange.getLast().x && p.y == schlange.getLast().y){
					System.out.println("Score: " + getScore());
					moveable = false;
					System.exit(0);
				}				
			}
		}
			
	}

	/**
	 * zufallsmethode, die eine random x-koordinate für die frucht berechnet
	 * @return x
	 */
	public int randomEssenX(){
		Random zufall = new Random();
		int x1 = zufall.nextInt(hoehe/10-10);
		int x = x1*10;
		if(x>breite-20){
			x = breite-20;
		}
		if(x<=20){
			x = 20;
		}
		if(x>=590){
			x = 580;
		}
		if(x == 280){
			x = 270;
		}
		if(x == 290){
			x = 300;
		}
		return x;
	}

	/**
	 * zufallsmethode, die eine random y-koordinate für die frucht berechnet
	 * @return y
	 */
	public int randomEssenY(){ //
		Random zufall = new Random();
		int y1 = zufall.nextInt(breite/10-10);
		int y = y1*10;
		if(y>breite-20){
			y = breite-20;
		}
		if(y<=20){
			y = 20;
		}
		if(y>=590){
			y = 580;
		}
		if(y == 280){
			y = 270;
		}
		if(y == 290){
			y = 300;
		}
		return y;
	}

	public LinkedList getLinkedList() { //getter Methode für die schlange
		return schlange;
	}
	public void setLaenge(){ //setter Methode, die die Länge der Schlange erhöht
		this.laenge = laenge+5;
	}
	public int getBreite() { //getter Methode für die breite des Spielfelds
		return this.breite;
	}
	public int getHoehe() { //getter Methode für die höhe des Spielfelds
		return this.hoehe;
	}

	/**
	 * zufallsmethode, die einen random wert zwischen 1 und fünf berechnet, und je nach wert eine farbe für die Frucht zuweist.
	 * @return farbe
	 */
	public int farbe(){
		Random zufall = new Random();
		int farbe = zufall.nextInt(5);
		return farbe;
	}
	public int setScore(){ //setter Methode für den Punktestand
		this.score += 5;
		return score;
	}
	public int getScore(){ //getter Methode für den Punktestand
		return score;
	}
}
