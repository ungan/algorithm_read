import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
	static Stack<SimpleEntry<Integer,Integer>> cook = new Stack<>();
	static int min;

	public static void main(String[] args) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(br.readLine());
		int array[][] = new int[n][2];
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		min = (array[0][0]> array[0][1]) ? array[0][0] - array[0][1] : array[0][1] - array[0][0];
		
		dep(array,0);
		
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}

	static void dep(int array[][],int cnt)
	{
		//System.out.println("cnt : " + cnt);
		for(int i=cnt; i<array.length;i++)
		{
			//System.out.println("a");
			cook.push(new SimpleEntry<>(array[i][0],array[i][1]));
			cal(cook);
			dep(array,i+1);
			cook.pop();
		}
	}
	
	static void cal(Stack<SimpleEntry<Integer,Integer>> cook)
	{
		int S=0;
		int b=0;
		for(SimpleEntry<Integer,Integer> c : cook)
		{
			int x = (int) c.getKey();
			b += (int) c.getValue();

			
			if(S==0) S = x;
			else
			{
				S *=x;
			}
		}
		
		int t_min = (S>b)? S-b:b-S;
		
		if(min >t_min) min = t_min;
	}

}
