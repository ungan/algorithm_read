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
	static int [][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	static int size=0;
	static int n=0;
	static int m=0;
    public static void main(String[] args) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	//String s = br.readLine();
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	int[][] array = new int[n][m];
    	
    	int count=0;
    	int maxsize=0;
    	for(int i=0; i<n; i++)
    	{
    		//System.out.println("aa");
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<m; j++)
    		{
    			//System.out.println("nnn");
    			array[i][j] = Integer.parseInt(st.nextToken());
    		}
    		
    	}
    			
    	for(int i=0; i<n; i++)
    	{
    		for(int j=0; j<m; j++)
    		{
    			
    			if(array[i][j] == 1)
    			{
    				dfs(array,i,j);
    				count++;
    				if(maxsize < size) maxsize = size; 
    				size=0;
    			}
    		}
    	}


    	bw.write(count + "\n" + maxsize);
    	bw.flush();
    	bw.close();
    	
    }
    
    static void dfs(int[][] array, int i, int j)
    {
    	array[i][j] =0;
    	size++;
    	for(int w=0; w<delta.length; w++)
    	{
    		int x=i + delta[w][0];
    		int y=j + delta[w][1];
    		
    		if(x >= 0 && x<n && y <m && y >=0)
    		{
    			if(array[i + delta[w][0]][j + delta[w][1]] == 1)
        		{
    				array[i][j] = 0;
        			dfs(array,i + delta[w][0],j + delta[w][1]);
        		}
    		}
    	
    	}
    	
    }


    
}
