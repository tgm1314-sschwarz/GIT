package sschwarz;
import java.awt.*;
import javax.swing.*;

public class MyView extends JFrame{
	//Attribute
	private JButton plus1,minus1,beenden, reset;
	private JLabel zaehler;
	private MyModel m;
	private MyController c;
	//Constructor
	public MyView(MyModel m, MyController c){
		this.m = m;
		this.c = c;
		
		setLayout(new BorderLayout());

		this.zaehler = new JLabel(this.m.getZaehler()+"");
		this.plus1 = new JButton("+");
		this.minus1 = new JButton("-");
		this.reset = new JButton("reset");
		this.beenden = new JButton("exit");
		
		add(plus1, BorderLayout.EAST);
		add(minus1, BorderLayout.WEST);
		add(reset, BorderLayout.NORTH);
		add(beenden, BorderLayout.SOUTH);
		add(zaehler, BorderLayout.CENTER);
		
		this.refresh();
		plus1.setActionCommand("plus");
		minus1.setActionCommand("minus");
		reset.setActionCommand("reset");
		beenden.setActionCommand("beenden");
		this.plus1.addActionListener(this.c);
		this.minus1.addActionListener(this.c);
		this.reset.addActionListener(this.c);
		this.beenden.addActionListener(this.c);
		
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		public void refresh(){
			this.zaehler.setText(this.m.getZaehler()+"");
		}

}
