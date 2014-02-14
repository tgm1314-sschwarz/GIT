/**
 * 
 */
package au01;

import java.io.IOException;

/**
 * @author Erik Brändli
 *
 */
public class Inputs {
	    public static String readString()
	    {
	        char c= ' ';
	        String s = "";
	        do
	        {
	            try
	            {
	                int i = System.in.read();
	                c = (char)i;
	                s+=c;
	            }catch(IOException e){
	                e.printStackTrace(); 
	            }
	        }while(c != '\n');
	        
	        if(s.charAt(0) == '\n')
	            return "";
	        String[] array = new String[2];
	        if(array.length != 1)
	        {
	            array = s.split("\n");
	            s = array[0];
	        }
	        
	        return s;
	    }
	    
	    public static int readInt()
	    {
	        int i = 0;        
	            try
	            {
	                String eingabe = readString();
	                if(eingabe == "")
	                    return 0;
	                i = Integer.parseInt(eingabe);
	            }catch(NumberFormatException e){
	                i = Integer.MIN_VALUE;
	            }
	        return i;
	    }
	    
	
}
