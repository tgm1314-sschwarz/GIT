package sschwarz;
/**
 * Gui für die Datenbank
 * @author stephan schwarz
 * @version 11.10.2013
 */
import javax.swing.*;

import java.awt.*;

public class gui extends JFrame{
	private TelefonbuchConsole tc;
	private JButton sort;
	private JButton newOne;
	private JButton search;
	private JButton delete;
	private JButton show;
	private JPanel p1;
	private JPanel p2;
	public TextArea area;
	
	public gui(TelefonbuchConsole tc){
		this.tc = tc;
		setLayout(new GridLayout(1,2));
		
		this.p1 = new JPanel();
		this.p2 = new JPanel();
		this.p1.setLayout(new GridLayout(2, 2));
		this.p2.setLayout(new BorderLayout());
		this.area = new TextArea();
		this.area.disable();
		this.show = new JButton("show");
		this.sort = new JButton("sort");
		this.search = new JButton("search");
		this.delete = new JButton("delete");
		this.newOne = new JButton("add");
		
		this.show.setActionCommand("show");
		this.newOne.setActionCommand("add");
		this.sort.setActionCommand("sort");
		this.search.setActionCommand("search");
		this.delete.setActionCommand("delete");
		
		this.show.addActionListener(tc);
		this.newOne.addActionListener(tc);
		this.sort.addActionListener(tc);
		this.search.addActionListener(tc);
		this.delete.addActionListener(tc);
		
		p1.add(newOne, GridLayout(1,1));
		p1.add(delete, GridLayout(1,2));
		p1.add(search, GridLayout(2, 1));
		p1.add(sort, GridLayout(2, 2));
		p2.add(area, BorderLayout.CENTER);
		p2.add(show, BorderLayout.NORTH);
		
		add(p1, GridLayout(1,1));
		add(p2, GridLayout(1,2));
		
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private Object GridLayout(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
}
