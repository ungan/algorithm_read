import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
	
    public static void main(String[] args) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	
    	String[][] array = new String[n][2];

    	for(int i=0; i<n; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		array[i][0] = st.nextToken();
    		array[i][1] = st.nextToken();
    	}

    	Arrays.sort(array,(String[] s1, String[] s2)->{
    		if( s1[0] == s2[0])
    		{
    			return s1[1].compareTo(s2[1]);
    		}
    		else
    		{
    			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
    		}
    			
    	});
    	
    	
    	for(int i=0; i<array.length; i++)
    	{
			bw.write(array[i][0] + " " + array[i][1] + "\n");
    	}
    	/*
    	for(int i=array.length-1; i>=0; i--)
    	{
			bw.write(array[i][0] + " " + array[i][1] + "\n");
    	}
    	*/
    	bw.flush();
    	bw.close();
    	
    }


    
}
