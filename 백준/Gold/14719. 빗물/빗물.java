import java.io.*;
import java.util.*;

public class Main {
	
	static int H;
	static int W;
	static int[][] map;
	static int total=0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        
        st = new StringTokenizer(br.readLine());
        
        
    	for(int j=0; j<W; j++)
        {
        	int n = Integer.parseInt(st.nextToken());
        	
        	for(int i=n-1; i>=0; i--)
        	{
        		map[i][j] = 1;
        	}
        }
        
    	for(int j=0; j<W; j++)
        {
        	
        	for(int i=H-1; i>=0; i--)
        	{
        		if(map[i][j] == 1) water(i, j);
        	}
        }
    	
        bw.write(Integer.toString(total));
        bw.flush();
        bw.close();
        br.close();
    
    }
    
    public static void water(int x, int y)
    {
    	//System.out.println(x + " " + y);
    	int count=0;
    	y++;
    	while(y < W && map[x][y] == 0)
    	{
    		//System.out.println("in : " + x + " " + y);
    		y++;
    		count++;
    		if(y >= W) break;
    		if(map[x][y] == 1) 
			{
    			total += count;
    			break;
			}
    	}
    }
   
}
