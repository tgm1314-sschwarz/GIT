package sschwarz;

import java.io.File;

public class aufgabe06a {
	public static void main(String[] args){
		verzeichnisBraumR("C:/Program Files (x86)/Adobe/Acrobat 10.0");
	}

	private static void verzeichnisBraumR(String verzeichnis) {
		File f = new File(verzeichnis);
		if(f.isDirectory()){
			String[] vliste=f.list();
			for(int i=0; i<vliste.length ;i++){
				aufgabe06a.verzeichnisBraumR(vliste[i]);
			}
		}else{
			System.out.println(f);
		}
	}
}
