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

	static BufferedWriter bw;
	static int N;
	static int M;
	static ArrayList<Integer> arrayList = new ArrayList<>();
	static ArrayList<Integer> arrayList_pool = new ArrayList<>();
	static int[] array;

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		array = new int[N];
		
		for(int i=1; i<=N;i++)
		{
			//array[i-1] = i; 
			arrayList_pool.add(i);
		}
		//arrayList.add(0);
		depth(0);
		
		bw.flush();
		bw.close();
	}
	
	static void depth(int d) throws IOException
	{
		if(M == d)
		{
			for(int a: arrayList)
			{
				bw.write(Integer.toString(a) + " ");
			}
			/*
			for(int a =0; a<M; a++)
			{
				bw.write(Integer.toString(array[a]) + " ");
			}*/
			bw.write("\n");
			return;
		}
		
		for(int i =0; i < arrayList_pool.size(); i++)
		{
			int value = arrayList_pool.get(i);
			
			//swap(array,i,d);
			arrayList.add(value);
			arrayList_pool.remove(i);
			depth(d+1);
			//System.out.println("arrayList.size : " + arrayList.size() + "  i : " + i);
			arrayList_pool.add(i, value);
			arrayList.remove(arrayList.size()-1);
			//swap(array,d,i);
		}
	}
	
	static void swap(int array[],int i,int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}
	
}