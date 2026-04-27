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
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=K; j>=0; j--)
			{
				if(j<w) break; // 배낭 무게 보다 크다면 제외
				
				
				array[j] = array[j] > v + array[j-w] ? array[j] : v+array[j-w];
				//System.out.println("j : " + j + " array[j] : " + array[j]);
			}
		}
		
		
		bw.write(Integer.toString(array[K]));
		bw.flush();
		bw.close();
		br.close();

	}
	
	
	
}
