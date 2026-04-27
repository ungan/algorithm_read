
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count=0;
		int array[] = new int[N];
		
		//st = new StringTokenizer(br.readLine());
		for(int i=N-1; i>=0; i--)
		{
			array[i] =  Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<N; i++)
		{
			count += K/array[i];
			K -= (K/array[i])*array[i] ;
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}
	

	
	


}

