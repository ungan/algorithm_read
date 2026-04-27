
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int array[] = new int[N];
		int sum=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
		{
			//sum = Integer.parseInt(st.nextToken()) *(N-i);
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		for(int i=0; i<N; i++)
		{
			sum += array[i]*(N-i);
		}
		bw.write(Integer.toString(sum));
		
		bw.flush();
		bw.close();
	}
	
}

