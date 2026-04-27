import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int array[][] = new int[n][2];

    	for(int i=0; i<n; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		array[i][0] = Integer.parseInt(st.nextToken());
    		array[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(array,(int[] e1,int[] e2)->{
    		if(e1[1] == e2[1]) {
    			return e1[0] - e2[0];
    		}
    		else {
    			return e1[1] -e2[1];
    		}
    	});
    	
    	for(int i=0; i<n; i++)
    	{
    		bw.write(String.valueOf(array[i][0] ) + " " + String.valueOf(array[i][1]) + "\n");
    	}
    	
    	bw.flush();
    	bw.close();
    }
    
}
