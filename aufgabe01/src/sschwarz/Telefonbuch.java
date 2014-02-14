package sschwarz;
/**
 * logik für die eingegeben Befehle
 * @author stephan schwarz
 * @version 11.10.2013
 */
import java.util.ArrayList;

public class Telefonbuch {
	private TelefonbuchConsole tc;
	
	public Telefonbuch(TelefonbuchConsole tc){
		this.tc = tc;
	}
	
	public static ArrayList<TelefonbuchEintrag> tb = new ArrayList<TelefonbuchEintrag>();
	public static boolean add(TelefonbuchEintrag neu){
		tb.add(neu);
		return true;
	}
	public static ArrayList<TelefonbuchEintrag> getTb() {
		return tb;
	}
	public static boolean remove(int x){
		tb.remove(tb.get(x-1));
		return false;
	}
	public void contains(String a){
		int das = 0;
		for(int i = 0;i<tb.size();i++){
			if((tb.get(i).vname.contains(a)) || (tb.get(i).nname.contains(a)) || (tb.get(i).tel.contains(a))){
				das = i;
				this.tc.writeSearch(das);
			}
		}
	}
	public void sort(String typ){
		if(typ.toUpperCase().charAt(0)=='V'){
			TelefonbuchEintrag tmp = new TelefonbuchEintrag();
			for(int i = 0;i<tb.size();i++){
				for(int j = 1;j<tb.size()-i;j++){
					if(tb.get(j-1).vname.toLowerCase().charAt(0) > tb.get(j).vname.toLowerCase().charAt(0)){
						tmp = tb.get(j-1);
						tb.set(j-1, tb.get(j));
						tb.set(j, tmp);
					}
				}
			}
			}
			if(typ.toUpperCase().charAt(0)=='N'){
				TelefonbuchEintrag tmp = new TelefonbuchEintrag();
				for(int i = 0;i<tb.size();i++){
					for(int j = 1;j<tb.size()-i;j++){
						if(tb.get(j-1).nname.toLowerCase().charAt(0) > tb.get(j).nname.toLowerCase().charAt(0)){
							tmp = tb.get(j-1);
							tb.set(j-1, tb.get(j));
							tb.set(j, tmp);
						}
					}
				}
			}
	}
	public void ende(){
		System.exit(0);
	}
}