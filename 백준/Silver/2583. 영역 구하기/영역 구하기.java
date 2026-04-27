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
	static int [][] delta = {{-1,0},{1,0},{0,1},{0,-1}};
	static ArrayList<Integer> area = new ArrayList<>();
	static int count=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//String s = br.readLine();
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int array[][] = new int[m][n];
		
		for(int i=0; i<k;i++)
		{
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			
			for(int w=x1; w<x2;w++)
			{
				for(int j=y1; j<y2; j++)
				{
					array[w][j] = 1;
				}
			}
			
		}
		
		//bw.write("#"+Integer.toString(t)+ " " + Integer.toString(sum)+ "\n");	
		
		for(int i =0; i < array.length;i++)
		{
			for(int j=0; j< array[0].length;j++)
			{
				if(array[i][j] == 0)
				{
					array[i][j] =1;			
					count++;
					dfs(array,i,j);
				}
				
				//System.out.println("count : " + count);
				if(count !=0) area.add(count);
				count=0;
			}
		}
		Collections.sort(area);
		
		bw.write(Integer.toString(area.size()) + "\n");
		
		for(int a : area)
		{
			bw.write(Integer.toString(a) + " ");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int array[][],int n1, int n2)
	{

		//count++;
		for(int w=0; w < delta.length; w++)
		{
			int x = n1+delta[w][0];
			int y = n2+delta[w][1];
			
			if(x>=0 && x < array.length && y>=0 && y<array[0].length && array[x][y] == 0)
			{
				count++;
				array[x][y] = 1;
				dfs(array,x,y);
			}
			
		}
	}

}
