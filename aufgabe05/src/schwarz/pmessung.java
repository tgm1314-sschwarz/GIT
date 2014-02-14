package schwarz;

import java.util.*;
import javax.swing.*;

public class pmessung {
	private static ArrayList aList = new ArrayList();
	private static LinkedList lList = new LinkedList();
	private static int anzahl;
	
	public static void main(String[] args){
		String ein = JOptionPane.showInputDialog(null, "Anzahl der Messungen:");
		anzahl = Integer.parseInt(ein);
		for(int j = 0;j<1;j++){
			MessungArrayList(anzahl);
		}
		System.out.println("");
		for(int k = 0;k<10;k++){
			MessungLinkedList(anzahl);
		}
	}
	
	public static void MessungArrayList(int anzahl){
		long z1 = System.nanoTime();
		for(int i = 0;i<anzahl;i++){
			aList.add(0, i);
		}	
		long z2 = System.nanoTime();
		long laufzeit = z2-z1;
		System.out.println(laufzeit);
	}
	
	public static void MessungLinkedList(int anzahl){
		long z1 = System.nanoTime();
		for(int i = 0;i<anzahl;i++){
			lList.addFirst(i);
		}	
		long z2 = System.nanoTime();
		long laufzeit = z2-z1;
		System.out.println(laufzeit);
	}
}