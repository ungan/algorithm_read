import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		Stack<Integer> s = new Stack<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++)
		{
			int a = Integer.parseInt(st.nextToken());
			array[i] = a;
			
			
			while(!s.isEmpty() && a > array[s.peek()])
			{
				//System.out.println("s.peek() : " + s.peek() + " a : " + a);
				array[s.pop()] = a; 
			}
			s.push(i);
		}
		
		for(int i : s)
		{
			array[i] = -1;
		}
		for(int i : array)
		{
			bw.write(Integer.toString(i) + " ");
		}
		
        bw.flush();
		bw.close();
		br.close();
	}
	

}
