import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		HashMap<Integer,Integer> map = new HashMap<>();
		Queue<Character> q = new LinkedList<>();
		int max=0;
		
		for(int i=0; i<s.length(); i++)
		{
			int c = s.charAt(i);
			
			q.add(s.charAt(i));
			if(map.containsKey(c))
			{
				//int temp = map.remove(c);
				int num = map.get(c);
				//map.remove(c);
				map.put(c,num+1);
				//System.out.println("map : " + map.get(c));
				//System.out.println("c : " + c);
			}
			else
			{
				map.put(c,1);				
			}
			//System.out.println("map.size : " + map.size());
			//System.out.println("q.size() : " + q.size());
			if(map.size()>n)
			{
				//System.out.println("a");
				//System.out.println("map.size : " + map.size());
				while(map.size() >n)
				{
					char ch2 = q.peek();
					int ch = q.poll();
					//System.out.println(ch2 + " " + map.get(99));
					
					int num = map.get(ch);
					if(num-1 == 0)
					{
						map.remove(ch);
						continue;
					}
					
					map.put(ch,num-1);
				}
			}
			
			if(max<q.size()) max = q.size();
		}
		
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
		br.close();
		
	}

}
