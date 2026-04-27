import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] decimal = new boolean[N+1];
        
        decimal[1] = true;
        for(int i=4; i<=N;i+=2)
        {
        	//System.out.println("i : " + i);
        	decimal[i] = true; 
        }
        
        for(int i=3; i*i<=N; i++)
        {
        	//System.out.println("out i : " + i);
        	if(!decimal[i])
    		{
        		//System.out.println("i : " + i);
        		for(int j=i*i; j<=N; j+=i) 
    			{
        			//System.out.println("j : " + j);
        			decimal[j] = true;
    			}
    		}
        }
        
        
        for(int i=M; i<=N; i++)
        {
        	if(!decimal[i]) bw.write(Integer.toString(i) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
	}

}
