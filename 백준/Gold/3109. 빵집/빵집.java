import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;


public class Main{
	static boolean[] row;
	static boolean building[][];
	static int R;		// 세로
	static int C;		// 가로
	static int count=0;
	static int count2=0;
	static int delta[][] = {{-1,1},{0,1},{1,1}};
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char array[][] = new char[R][C];
		building = new boolean[R][C];
		row = new boolean[R];
		
		for(int i=0; i<R; i++)
		{
			String s = br.readLine();
			for(int j=0; j<C;j++)
			{
				array[i][j] = s.charAt(j);          //Stringto.parseInt(st.nextToken());
				//System.out.println("j : " + j + " array[i][j] : " + array[i][j]);
				
				if(array[i][j] == 'x')
				{
					building[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<R; i++)
		{
			if(building[i][0] == false)
			{
				building[i][0] = true;
				depth(0,i,new Point(i,0));
				
			}
			
		}
		
		bw.write(Integer.toString(count) + "\n");
		bw.flush();
		bw.close();
	}
	
	static void depth(int d,int r,Point point)
	{
		//System.out.println("x : " + point.x + " y : " + point.y);
		
		if(d == C-1) // 끝까지 갔을 때
		{
			//System.out.println("stop : "+ r );
			row[r] = true;	// 가지 치기용			
			count++;
			return;
		}
		for(int i=0; i<3; i++)
		{
			int dx = point.x + delta[i][0];
			int dy = point.y + delta[i][1];
			if(dx>=0 && dx < R && dy>=0 && dy <C)
			{
				if(building[dx][dy] == false)
				{
					
					Point new_point = new Point(dx,dy);
					building[dx][dy] = true;
					depth(d+1,r,new_point);
					if(row[r] == true) 
					{
						return;	// 더이상 길 찾기 x
					}
					
					//building[dx][dy] = false;	// 맞는길 아니라면 되돌려준다.
				}
				
			}
		}
	}
	
	
	
}