import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception
    {
    	
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	//StringTokenizer st = new StringTokenizer(br.readLine());
    	int a = Integer.parseInt(br.readLine());
    	
    	int total_count=0;
    	
    	int c=665;
    	int n=0;
    	//while(true)
    	
    	//for(int i=0; i<2000;i++)
    	while(true)
    	{
    	
    		c++;
    		String s = c+"";
    		
    		if(s.indexOf("666") != -1)
    		{
    			//System.out.println(s);
    			n++;
    		}
    		
    		if(n == a)
    		{
    			break;
    		}
    	}
    	
    	System.out.println(c);
    	
    	
    }
}
