import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		
		Stack<Character> origin = new Stack<>();
		//Stack<Character> carculate = new Stack<>();
		int cnt=1;
		int total=0;
		
		if(s.length() < 2)
		{
			System.out.println("0");
			return;
		}
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			
			switch(c)
			{
				case '(':
					origin.push(c);
					cnt*=2;
					break;
					
				case '[':
					origin.push(c);
					cnt*=3;
					break;
					
				case ')':
					if(origin.isEmpty())
					{
						System.out.println(0);
						return;
					}
					else if(s.charAt(i-1) == '(') 
					{
						origin.pop();
						//System.out.println("cnt : " + cnt);
						total += cnt;
					}
					else if(!origin.empty()&& '[' != origin.peek())
					{
						origin.pop();
					}
					else if(origin.empty() || '[' == origin.peek())
					{
						//System.out.println("i : " + i + " " + s.charAt(i));
						System.out.println(0);
						return;
					}
					cnt/=2;
					break;
					
				case ']':
					if(origin.isEmpty())
					{
						System.out.println(0);
						return;
					}
					else if(s.charAt(i-1) == '[') 
					{
						origin.pop();
						total += cnt;
						//System.out.println("cnt : " + cnt);
					}
					else if(!origin.empty() && '(' != origin.peek())
					{
						origin.pop();
					}
					else if(origin.empty() || '(' == origin.peek())
					{
						//System.out.println("i : " + i + " " + s.charAt(i));
						System.out.println(0);
						return;
					}
					cnt/=3;
					break;
			}
		}
		
		if(!origin.isEmpty()) total=0;
		
		bw.write(Integer.toString(total));
        bw.flush();
		bw.close();
		br.close();
	}
	

}
