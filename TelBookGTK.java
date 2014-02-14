/**
 * 
 */
package au01;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * @author Erik
 *
 */
public class TelBookGTK extends JFrame {

	public TelBookGTK(){
		super();
		this.setSize(1000, 1000);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
	}
	/**
	 * @param args
	 */
	public JButton[] buttons = new JButton[6];
	public JTextArea outp = new JTextArea("");

	public static void main(String[] args) {
		TelBookGTK aa = new TelBookGTK();

	}



	public void setOutpText(String text) {
		this.outp.append(text);
	}

}
