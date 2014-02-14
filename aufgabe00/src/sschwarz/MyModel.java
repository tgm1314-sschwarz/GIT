package sschwarz;

public class MyModel {
	//Attribute
	private int zaehler;
	//Constructor
	public MyModel(){
		this.zaehler = 0;
		this.reset();
	}
	public void reset(){
		this.zaehler = 0;
	}
	public int getZaehler(){
		return this.zaehler;
	}
	public void plus1(){
		this.zaehler++;
	}
	public void minus1(){
		this.zaehler--;
	}

}
