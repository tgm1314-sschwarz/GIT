import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class WD {

	public static void main(String[] args) {
		System.out.println("Datenbank:");
		ArrayList<TelefonbuchEintrag> tb = new ArrayList<TelefonbuchEintrag>();
		
		while(true)
		{
			String text = read();
			char c = text.charAt(0);
			
			switch(c)
			{
			case 'E':
				TelefonbuchEintrag t = new TelefonbuchEintrag();
				t.vname = read();
				t.nname = read();
				t.tel = read();
				
				tb.add(t);
			
				
				break;
			case 'A':
				for(int i = 0;i<tb.size();i++)
				{
					System.out.println(tb.get(i).vname);
					System.out.println(tb.get(i).nname);
					System.out.println(tb.get(i).tel);
				}
				break;
			case 'X':
				System.exit(0);
				break;
			case 'L':
				int x = Integer.parseInt(read());
				tb.remove(tb.get(x-1));
			
			case '?':
				String a = read();
				for(int i = 0;i<tb.size();i++){
					if((tb.get(i).vname.contains(a)) || (tb.get(i).nname.contains(a)) || (tb.get(i).tel.contains(a))){
						System.out.println(tb.get(i).vname);
						System.out.println(tb.get(i).nname);
						System.out.println(tb.get(i).tel);
					}
				}
			case 'S':
				String ein = read();
				if(ein.charAt(0)=='V'){
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
				if(ein.charAt(0)=='N'){
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

}


