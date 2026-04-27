import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		//List<Character> list = new LinkedList<Character>();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for(int i=0; i<s.length();i++)
		{
			left.push(s.charAt(i));
		}
		int n = Integer.parseInt(br.readLine());
		int index = s.length();
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			
			switch(temp)
			{
				case "L":
					if(!left.isEmpty())
					{
						right.push(left.pop());
						
						//index--;
					}
					break;
					
				case "D":
					if(!right.isEmpty())
					{
						left.push(right.pop());
						//index++;
					}
					break;
					
				case "B":
					if(!left.isEmpty())
					{
						left.pop();
						//index--;
					}
					break;
					
				case "P":
					Character p = st.nextToken().charAt(0);
					left.push(p);
					//index++;
					break;
			}
		}
		
		while(!left.isEmpty())
		{
			//System.out.println("c1 : ");
			//System.out.println("c : " + left.peek());
			right.push(left.pop());
		}
		
		while(!right.isEmpty())
		{
			//char c = right.pop();
			//System.out.println("c2 : ");
			bw.write(Character.toString(right.pop()));
		}
		
		
        bw.flush();
		bw.close();
		br.close();
	}
	

}
