package sschwarz;

import java.awt.event.*;

public class MyController implements ActionListener{
	//Attribute
	private MyModel m;
	private MyView v;
	
	//Constructor
	public MyController(){
		this.m = new MyModel();
		this.v = new MyView(this.m,this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("plus")){
			this.m.plus1();
			this.v.refresh();
		}
		if(e.getActionCommand().equals("minus")){
			this.m.minus1();
			this.v.refresh();
		}
		if(e.getActionCommand().equals("reset")){
			this.m.reset();
			this.v.refresh();
		}
		if(e.getActionCommand().equals("beenden")){
			System.exit(0);
		}
	}
}
