
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;// = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(br.readLine());
       
       ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
       
       for(int i=0; i<N; i++)
       {
    	   st = new StringTokenizer(br.readLine());
    	   int a = Integer.parseInt(st.nextToken());
    	   int b = Integer.parseInt(st.nextToken());
    	   ArrayList<Integer> p = new ArrayList<>();
    	   
    	   p.add(a);
    	   p.add(b);
    	   arrayList.add(p);
       }
       
       Collections.sort(arrayList,new Comparator<ArrayList<Integer>>() {

		@Override
		public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
			return o1.get(0) - o2.get(0);

		}
	});
       
       PriorityQueue<Integer> q = new PriorityQueue<>();
       q.add(arrayList.get(0).get(1));
       
       for(int i=1; i<arrayList.size();i++)
       {
    	   int end_time = q.peek();
    	   
    	   if(end_time <= arrayList.get(i).get(0))
    	   {
    		   q.poll();
    		   q.add(arrayList.get(i).get(1));
    	   }
    	   else
    	   {
    		   q.add(arrayList.get(i).get(1));
    	   }
       }
       
       bw.write(Integer.toString(q.size()));
       bw.flush();
       bw.close();
       //System.out.println(q.size());
       
    }
}