import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;


public class Main{
	static int N;
	static int S;
	static int array[];
	static int save[];
	static int count=0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		save = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
		{
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		if(S == 0) {
			count--;
		}
		
		depth(0,0);
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
	}
	
	static void depth(int d,int sum)
	{
		//System.out.println("d : " + d);
		if(N == d)
		{
			if(sum == S)
			{
				count++;
			}
			return;
		}
		

		
		depth(d+1,sum+ array[d]);
		

		depth(d+1,sum);

		
	}



}