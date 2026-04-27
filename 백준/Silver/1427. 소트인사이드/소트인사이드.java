import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main{
	
    public static void main(String[] args) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String s = br.readLine();
    	int array[] = new int[s.length()];
    	
    	
    	for(int i=0; i<s.length();i++)
    	{
    		int temp = (int)(s.charAt(i) - '0');
    		array[i] = temp;
    		//array[temp]++;
    		//System.out.println("(int)s.charAt(i)" + (int)(s.charAt(i) - '0'));
    	}
    	
    	Arrays.sort(array);
    	
    	for(int i = s.length()-1; i >= 0; i--)
    	{
    		bw.write(String.valueOf(array[i]));
    	}
    	bw.flush();
    	bw.close();
    	//for(int i=0; i<100001)
    }
    
}
