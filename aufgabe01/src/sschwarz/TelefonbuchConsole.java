package sschwarz;
/**
 * Verwaltet das gesammte Programm
 * @author stephan schwarz
 * @version 11.10.2013
 */
import java.io.Console;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TelefonbuchConsole implements ActionListener{
	private gui g;
	private Telefonbuch tb = new Telefonbuch(this);
	
	//Constructor
	public TelefonbuchConsole(){
		this.g = new gui(this);
	}
	public void logik(){
	while(true){
		String text = TelefonbuchConsole.read();
		char c = text.toUpperCase().charAt(0);
		
		switch(c){ //consolensteuerung
		case 'E': //eingabe
			TelefonbuchEintrag t = new TelefonbuchEintrag();
			t.vname = TelefonbuchConsole.read();
			t.nname = TelefonbuchConsole.read();
			t.tel = TelefonbuchConsole.read();
			this.tb.add(t);
			write();
			break;
		case 'A': //ausgabe
			for(int i = 0;i<tb.getTb().size();i++) {
				System.out.println(this.tb.getTb().get(i).vname);
				System.out.println(this.tb.getTb().get(i).nname);
				System.out.println(this.tb.getTb().get(i).tel);
				System.out.println("----------------------------------------------------------\n");
			}
			write();
			break;
		case 'X': //beenden
			this.tb.ende();
			break;
		case 'L': //delete
			int x = Integer.parseInt(TelefonbuchConsole.read());
			this.tb.remove(x);
			write();
			break;
		case '?': //suchen
			String a = TelefonbuchConsole.read();
			this.tb.contains(a);
		case 'S': //sortieren
			String typ = TelefonbuchConsole.read();
			this.tb.sort(typ);
			break;
		}
	}
}
	public static String read()
		{
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				String text = null;
				try {
					text = input.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return text;
		}
	@Override
	public void actionPerformed(ActionEvent e) { //actionlistener
		if(e.getActionCommand().equals("add")){ //eingabe eines neuen Eintrags
			TelefonbuchEintrag t1 = new TelefonbuchEintrag();
			t1.vname = JOptionPane.showInputDialog(null, "Neuer Eintrag:\nVorname: ");
			t1.nname = JOptionPane.showInputDialog(null, "Neuer Eintrag:\nNachname: ");
			t1.tel = JOptionPane.showInputDialog(null, "Neuer Eintrag:\nTelefonnummer: ");
			this.tb.add(t1);
			write(); //anzeige methode
		}
		if(e.getActionCommand().equals("delete")){ //löschen und indexangabe
			String index = JOptionPane.showInputDialog(null, "Eintrag Löschen:\nIndexnummer: ");
			int x = Integer.parseInt(index);
			this.tb.remove(x);
			write(); //anzeige methode
		}
		if(e.getActionCommand().equals("search")){ //gibt das gesuchte aus und fragt wonach suchen
			String a = JOptionPane.showInputDialog(null, "Suchen: ");
			this.tb.contains(a);
		}
		if(e.getActionCommand().equals("sort")){ //gibt das sortierte aus und fragt wonach sortieren
			String typ = JOptionPane.showInputDialog(null, "Einträge sortieren:\nVorname oder Nachname?");
			this.tb.sort(typ);
			write(); //anzeige methode
		}
		if(e.getActionCommand().equals("show")){ //gibt immer die gesammte Datenbank aus
			write(); //anzeige methode
		}
	}
	public void write() { //anzeige methode, die alles anzeig
		g.area.setText("");
		for(int i = 0;i<tb.getTb().size();i++){
			g.area.append(this.tb.getTb().get(i).vname);
			g.area.append("		" + this.tb.getTb().get(i).nname);
			g.area.append("		" + this.tb.getTb().get(i).tel + "\n");
			g.area.append("----------------------------------------------------------\n");
		}
	}
	public void writeSearch(int das) { //anzeige methode, die nur das gesuchte anzeigt
		g.area.setText("");			
		g.area.append(this.tb.getTb().get(das).vname);
		g.area.append("		" + this.tb.getTb().get(das).nname);
		g.area.append("		" + this.tb.getTb().get(das).tel + "\n");
		g.area.append("----------------------------------------------------------\n");
	}
}