package schwarz;

import java.awt.*;

public class SnakeModel {
	private Point schlange;
	private int schrittweite;
	private int breite;
	private int hoehe;
	private int x = 0;
	private int y = 0;
	
	public SnakeModel(int b, int h){
		this.breite = b;
		this.hoehe = h;
	}

	public void up(){
		this.y-=10;
	}
	public void down(){
		this.y+=10;
	}
	public void left(){
		this.x-=10;
	}
	public void right(){
		this.x+=10;
	}
	public void init(){
		
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
