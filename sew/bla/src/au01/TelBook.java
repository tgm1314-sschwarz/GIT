/**
 * 
 */
package au01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Erik Brändli
 *
 */
public class TelBook implements ActionListener{

	public TelBook() {
		iff(); // I nter F ace F unktion
	}
	public TelBook(boolean silence){
		if(!silence){
			iff();
		}else{
			gui = new TelBookGTK();
			guiinit();
			
		}
	}
	/**
	 * @param args
	 */
	private TelBookGTK gui;
	public TelefonBuchEintrag[] tbe= new TelefonBuchEintrag[0];  
	public static void main(String[] args) {
		TelBook gain = new TelBook(true);

	}
	public void iffSilenced(char option){
		switch(option){
		case 'e':
			insertE(""+JOptionPane.showInputDialog("Vorname"), ""+JOptionPane.showInputDialog("Nachname"), ""+JOptionPane.showInputDialog("Telefon nummer"));
			break;
		case 'l':
			deleteL(Integer.parseInt("0"+JOptionPane.showInputDialog("id")));
			break;
		case 'x':
			exitX();
			break;
		case 'q':
			searchQ(""+JOptionPane.showInputDialog("Suche was?"));
			break;
		case 'a':
			showA();
			break;
		case 's':
			sortS(""+JOptionPane.showInputDialog("V nach Vornamen, N nach Nachnamen"));
			break;
		}
	}
	private void iff(){
		while(true){
			System.out.println("E Eingeben des Kontaktes\nA Anzeigen der Kontakte\nL Löschen eines Kontaktes\nX zum verlassen des Programmes\n? zum Suchen von kontaktdetails\nS zum sortieren des Telefonbuches");
			String opt = Inputs.readString();
			opt = opt.toLowerCase();
			switch(opt.charAt(0)){
			case 'e':
				TelefonBuchEintrag tbeTMP = new TelefonBuchEintrag();
				//info getter 
				System.out.println("vorname");
				String in = Inputs.readString();
				tbeTMP.Vname = in;
				System.out.println("nachname");
				tbeTMP.Nname = Inputs.readString();
				System.out.println("Telefonnummer");
				tbeTMP.Telnr = Inputs.readString();
				//info getter end
				TelefonBuchEintrag[] tbe1= new TelefonBuchEintrag[tbe.length+1];
				for(int i = 0; i< tbe.length;i++){
					tbe1[i]= tbe[i];
				}
				tbe1[tbe1.length-1]=tbeTMP;
				this.tbe = tbe1;

				break;
			case 'a':
				System.out.print('\f');
				for(int i = 0; i < tbe.length; i++)
					System.out.println(this.tbe[i].fullInfo(1));
				break;
			case 'l':
				System.out.println("index des zu löschenden eintrag 0+");
				int a;
				String sa="",s = Inputs.readString();
				for(int i = 0; i<s.length()-1;i++)
					sa+=s.charAt(i);
				a= Integer.parseInt(sa);
				TelefonBuchEintrag[] newtbe = new TelefonBuchEintrag[this.tbe.length-1];
				for(int i = 0, j=0; i<this.tbe.length;i++){
					if(i!=a){
						newtbe[j] = this.tbe[i];
						j++;
					}
				}
				this.tbe = newtbe;
				break;
			case '?':
				System.out.println("vor oder nachname einer Person");
				String que = Inputs.readString();
				que.replace("\r", "");
				for(int i = 0; i < this.tbe.length;i++){

					if(this.tbe[i].fullInfo(1).contains(que)){
						System.out.println(this.tbe[i].fullInfo(2)+"\n");
					}

				}

				break;
			case 'S':
				System.out.println("V nach Vornamen, N nach Nachnamen");
				que = Inputs.readString();
				if(que.toLowerCase().charAt(0)=='v'){
					arrSort(2);
				}else{
					arrSort(1);
				}
				break;
			case 'x':
				System.exit(0);
				break;

			}
		}
	}
	private void arrSort(int field){
		TelefonBuchEintrag tMP;
		switch(field){
		case 2:
			for(int i = 0; i < this.tbe.length;i++){
				for(int j = 1; j < (this.tbe.length-i);j++){
					if(this.tbe[j-1].Vname.toLowerCase().charAt(0)> this.tbe[j].Vname.toLowerCase().charAt(0)){
						tMP = this.tbe[j-1];
						this.tbe[j-1]=this.tbe[j];
						this.tbe[j]=tMP;
					}
				}
			}
			break;

		case 1:
		default:
			for(int i = 0; i < this.tbe.length;i++){
				for(int j = 1; j < (this.tbe.length-i);j++){
					if(this.tbe[j-1].Nname.toLowerCase().charAt(0)> this.tbe[j].Nname.toLowerCase().charAt(0)){
						tMP = this.tbe[j-1];
						this.tbe[j-1]=this.tbe[j];
						this.tbe[j]=tMP;
					}
				}
			}
			break;
		}
	}
	private void insertE(String Vname,String Nname,String Tel){
		TelefonBuchEintrag tbeTMP = new TelefonBuchEintrag();
		//info getter 
		tbeTMP.Vname =Vname;
		tbeTMP.Nname = Nname;
		tbeTMP.Telnr = Tel;
		//info getter end
		TelefonBuchEintrag[] tbe1= new TelefonBuchEintrag[tbe.length+1];
		for(int i = 0; i< tbe.length;i++){
			tbe1[i]= tbe[i];
		}
		tbe1[tbe1.length-1]=tbeTMP;
		this.tbe = tbe1;

	}
	private void showA(){
		gui.outp.setText("");
		for(int i = 0; i < tbe.length; i++)
			gui.setOutpText(this.tbe[i].fullInfo(1)+System.getProperty("line.separator"));

	}
	private void deleteL(int id){
		if(id>=0){
			int a = id;
			TelefonBuchEintrag[] newtbe = new TelefonBuchEintrag[this.tbe.length-1];
			for(int i = 0, j=0; i<this.tbe.length;i++){
				if(i!=a){
					newtbe[j] = this.tbe[i];
					j++;
				}
			}
			this.tbe = newtbe;
		}
	}
	private void searchQ(String que){
		gui.outp.setText("");
		for(int i = 0; i < this.tbe.length;i++){
			if(this.tbe[i].fullInfo(1).contains(que)){
				gui.setOutpText(this.tbe[i].fullInfo(2)+"\n");
			}
		}
	}
	private void sortS(String que){
		if(que.toLowerCase().charAt(0)=='v'){
			arrSort(2);
		}else{
			arrSort(1);
		}
	}
	private void exitX(){
		gui.dispose();
		gui.setVisible(false);
		System.exit(0);
	}
	private void guiinit(){
		JPanel Buts = new JPanel(new GridLayout(1, 6));
		gui.buttons[0] = new JButton("Eingeben");
		gui.buttons[0].setActionCommand("e");
		gui.buttons[1] = new JButton("Anzeigen");
		gui.buttons[1].setActionCommand("a");
		gui.buttons[2] = new JButton("Löschen");
		gui.buttons[2].setActionCommand("l");
		gui.buttons[3] = new JButton("Suchen");
		gui.buttons[3].setActionCommand("q");
		gui.buttons[4] = new JButton("Sortieren");
		gui.buttons[4].setActionCommand("s");
		gui.buttons[5] = new JButton("Exit");
		gui.buttons[5].setActionCommand("x");
		for(int i = 0; i < gui.buttons.length;i++){
			gui.buttons[i].addActionListener(this);
			Buts.add(gui.buttons[i]);
		}
		gui.add(gui.outp,"Center");
		gui.add(Buts,"South");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		iffSilenced(e.getActionCommand().charAt(0));
	}
}
