import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[1001];
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 3;
		
		
		for(int i=3; i<=N; i++)
		{
			arr[i] = (arr[i-1] + arr[i-2]*2)%10007;
		}
		
		bw.write(Integer.toString(arr[N]));
		bw.flush();
		bw.close();
		br.close();

	}
	
	
	
}
