import java.util.*;
import java.io.*;

public class Main{
	static int delta[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static int jump[][] = {{2,1},{2,-1},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-1,-2}};
	static int array[][];
	static boolean visit[][];
	static int K;
	static int W;
	static int H;
	static int min;
	
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String[] sa = br.readLine().split(" ");
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visit = new boolean[H][W];
        array = new int[H][W];
        min = W*H+1;
        
        for(int i=0; i<H;i++)
        {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<W; j++)
        	{
        		array[i][j] = Integer.parseInt(st.nextToken()); 
        		if(array[i][j] == 1) visit[i][j] = true;
        	}
        }

        bfs();
        //if(min == W*H+1) min = -1;
        
        System.out.println(min);
    }
    
    static class State {
    	int x,y,moves,jumps;
    	
    	public State(int x, int y, int moves, int jumps)
    	{
    		this.x = x;
    		this.y = y;
    		this.moves = moves;
    		this.jumps = jumps;
    	}
    }
    
    static void bfs()
    {
    	Queue<State> q = new LinkedList<>();
    	
    	boolean[][][] visit = new boolean[H][W][K+1];
    	
    	q.add(new State(0,0,0,0));
    	visit[0][0][0] = true;
    	
    	while(!q.isEmpty())
    	{
    		//System.out.println("a");
    		State current = q.poll();
    		int x = current.x;
    		int y = current.y;
    		int move = current.moves;
    		int jumps = current.jumps;
    		
    		if(H-1 == x && W -1 == y) 
			{
    			min = move;
    			return;
			}
    		
    		for(int i=0; i<delta.length; i++)
        	{
        		int dx = x + delta[i][0];
        		int dy = y + delta[i][1];
        		
        		if(dx>=0 && dx<H && dy >=0 && dy <W && !visit[dx][dy][jumps] && array[dx][dy] == 0)
        		{
        			visit[dx][dy][jumps] = true;
        			q.add(new State(dx,dy,move+1,jumps));
        		}
        	}
    		
    		if(jumps >= K) continue;
        	
        	for(int i=0; i<jump.length; i++)
        	{
        		int dx = x + jump[i][0];
        		int dy = y + jump[i][1];
        		
        		if(dx>=0 && dx<H && dy >=0 && dy <W && !visit[dx][dy][jumps+1] && array[dx][dy] == 0)
        		{
        			visit[dx][dy][jumps+1] = true;
        			q.add(new State(dx,dy,move+1,jumps+1));
        		}
        	}
        	
    	}
    	 min = -1;
    }
    
}