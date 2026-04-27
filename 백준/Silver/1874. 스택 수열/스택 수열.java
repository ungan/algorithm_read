import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		Stack<Integer> stack = new Stack<>();
		int start =0;
		for(int i=0; i<n;i++)
		{
			int a = Integer.parseInt(br.readLine());
			//s += Integer.toString(a)+"\n";
			for(int j=start+1; j<=a;j++)
			{
				stack.push(j);
				sb.append('+').append('\n');
			}
			if(start < a) start = a;
			
			if(stack.pop() != a) 
			{
				//sb.append("NO").append('\n');
				System.out.println("NO");
				return;
			}
			else 
			{
				
				sb.append('-').append('\n');
			}
			
		}
		System.out.println(sb);
		//bw.write(s);
		bw.flush();
		bw.close();
	}
}