import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int array[] = new int[K+1];
		array[0] = 1;
		
		for(int i=0; i<N; i++)
		{
			int v = Integer.parseInt(br.readLine());
			
			for(int j=v; j<=K; j++)
			{
				array[j] += array[j-v];
				//System.out.println("array[j] : " + array[j]);
			}
		}
		
		
		bw.write(Integer.toString(array[K]));
		bw.flush();
		bw.close();
		br.close();

	}
	
	
	
}
