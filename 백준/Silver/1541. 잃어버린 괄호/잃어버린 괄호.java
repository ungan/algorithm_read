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
		//StringTokenizer st = new StringTokenizer(br.readLine());

		//
		String[] subtractionParts = br.readLine().split("-");
		
		int result = 0;
		
		//첫 덩어리는 - 안되므로 뺄셈이 없으므로, 모두 더해줍니다
		result += sumAllNumbers(subtractionParts[0]);
		
		//System.out.println("result : " + result);
		
		for(int i=1; i<subtractionParts.length; i++)
		{
			result -= sumAllNumbers(subtractionParts[i]);
		}
		
		bw.write(Integer.toString(result));
		
		bw.flush();
		bw.close();
	}
	
	public static int sumAllNumbers(String s) {
		int sum =0;
		
		String[] addParts = s.split("\\+");
		
		for(String part : addParts) {
			sum += Integer.parseInt(part);
		}
		return sum;
	}
}

