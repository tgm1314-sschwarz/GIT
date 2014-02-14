/**
 * 
 */
package au01;

/**
 * @author Erik
 *
 */
public class TelefonBuchEintrag {

	public String Vname;
	public String Nname;
	public String Telnr;
	
	public String fullInfo(int shema){
		switch(shema){
		case 1:
			return  (""+Vname+" "+Nname+" "+Telnr);
		case 2:
			return ( ""+Vname+"\n"+Nname+"\n"+Telnr);
			
		}
		return "";
	}
}
