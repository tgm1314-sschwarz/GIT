package schwarz;

import java.util.*;
import javax.swing.*;

public class pmessung {
	private static HashSet<Integer> hset = new HashSet<>();
	private static TreeSet<Integer> tset = new TreeSet<>();
	private static int anzahl;
	
	public static void main(String[] args){
		String ein = JOptionPane.showInputDialog(null, "Anzahl der Messungen:");
		anzahl = Integer.parseInt(ein);
		for(int j = 0;j<10;j++){
			MessungHashSet(anzahl);
		}
		System.out.println("");
		for(int k = 0;k<10;k++){
			MessungTreeSet(anzahl);
		}
	}
	
	public static void MessungHashSet(int anzahl){
		long z1 = System.nanoTime();
		for(int i = 0;i<anzahl;i++){
			hset.add(i);
		}	
		long z2 = System.nanoTime();
		long laufzeit = z2-z1;
		System.out.println(laufzeit);
	}
	
	public static void MessungTreeSet(int anzahl){
		long z1 = System.nanoTime();
		for(int i = 0;i<anzahl;i++){
			tset.add(i);
		}	
		long z2 = System.nanoTime();
		long laufzeit = z2-z1;
		System.out.println(laufzeit);
	}
}