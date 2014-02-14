package sschwarz;
/**
 * Main Methode für die Datenbank
 * @author stephan schwarz
 * @version 11.10.2013
 */
public class Main {
	public static void main(String[] args){
		System.out.println("Datenbank:");
		TelefonbuchConsole tbc = new TelefonbuchConsole();
		tbc.logik();
	}
}