import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int array[] = new int[10];
		int n = Integer.parseInt(br.readLine());
		
		while(true)
		{
			array[n%10]++;
			n/=10;
			
			if(n==0) break;
		}
		
		int sum = array[6]+array[9];
		int nam = sum%2;
		sum/=2;
		array[6] = sum+nam;
		array[9] = sum;
		
		Arrays.sort(array);
		
		bw.write(Integer.toString(array[9]));
		bw.flush();
		bw.close();
		br.close();
		
	}

}
