package sschwarz;

import javax.swing.*;
import java.util.*;

public class Lotto {
	public static void main(String[] args){
		String eing = JOptionPane.showInputDialog(null, "Anzahl an Tipps eingeben: ");
		int anzahl = Integer.parseInt(eing);
		
		TreeSet<Integer>[] t1 = new TreeSet[anzahl];
		TreeSet<Integer> t2 = new TreeSet<Integer>();
		Random zufall = new Random();
		
		float gewinn = -10*anzahl;
		int einser = 0;
		int zweier = 0;
		int dreier = 0;
		int vierer = 0;
		int fünfer = 0;
		int sechser = 0;
		
		int temp = 0;
		int tipp[] = new int[6];
		int ziehung[] = new int[6];
		int anzahlwins[] = new int[anzahl];
		
		for(int i = 0;i<ziehung.length;i++){
			if(t2.add(ziehung[i]) == false){
				ziehung[i] = zufall.nextInt(44) + 1;
				t2.add(ziehung[i]);
			}
		}
		for(int j = 0;j<t1.length;j++){
			t1[j] = new TreeSet<>();
			for(int i = 0;i<tipp.length; i++){
				tipp[i] = zufall.nextInt(44) + 1;
				if(t1[j].add(tipp[i]) == false){
					tipp[i] = zufall.nextInt(44) + 1;
					t1[j].add(tipp[i]);
				}
			}
		}
			
		for(int i = 0; i<t1.length; i++){
			for(int j = 0; j<ziehung.length;j++){
				if(t1[i].contains(ziehung[j])){
					temp += 1;
				}
			}
			switch(temp){
				case 1:
					einser += 1;
					break;
				case 2:
					zweier += 1;
					gewinn += 1;
					break;
				case 3:
					dreier += 1;
					gewinn += 4.60;
					break;
				case 4:
					vierer += 1;
					gewinn += 45.30;
					break;
				case 5:
					fünfer += 1;
					gewinn += 1431.80;
					break;
				case 6:
					sechser += 1;
					gewinn += 735038.30f;
					break;
			}
			anzahlwins[i] = temp;
			//System.out.println(anzahlwins[i]);
			temp = 0;
			System.out.println(t1[i]);
		}
		System.out.println("\n");
		System.out.println(t2 + "\n");
		System.out.println(anzahl + " Tipps: " + einser + "x1 " + zweier + "x2 " + dreier + "x3 " + vierer + "x4 " + fünfer + "x5 " +  + sechser + "x6 ");
		//System.out.println("Gewinn/Verlust: " + gewinn + "€");
	}
}