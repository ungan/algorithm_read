import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			switch(s)
			{
				case "push":
					int a = Integer.parseInt(st.nextToken());
					stack.push(a);
					break;
					
				case "top":
					if(stack.empty()) bw.write("-1\n");
					else bw.write(Integer.toString(stack.peek()) + "\n");

					break;
					
				case "size":
					bw.write(Integer.toString(stack.size()) + "\n");
					break;
					
				case "pop":
					if(stack.empty()) bw.write("-1\n");
					else bw.write(Integer.toString(stack.pop()) + "\n");
					break;
				case "empty":
					if(stack.empty()) bw.write("1\n");
					else bw.write("0\n");
			}
		}
		
		//bw.write(Integer.toString(count));
		bw.flush();
		bw.close();

	}
	

	
}
