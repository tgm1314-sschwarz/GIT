package sschwarz;

import java.util.*;
import javax.swing.*;

public class a03a {
	public static void main(String[] args){
		String uebersetzt = "";
		String woerter = "";
		String ausg = "";
		HashMap<String, String> map = new HashMap<>();
		
		while(true){ 
			woerter = JOptionPane.showInputDialog(null, "Bitte ein Satz/Wort eingeben"); 
			String[] wort=woerter.split(" "); 
			
			for(int i = 0; i < wort.length;i++){ 
				if(!map.containsKey(wort[i])){ 
					uebersetzt= JOptionPane.showInputDialog(null,"Bitte �besetzung f�r "+wort[i]+" eingeben");
					map.put(wort[i],uebersetzt); 
				} 
				ausg+= " "+map.get(wort[i]); 
			}
			System.out.println(ausg); ausg=""; 
		}
	}
}