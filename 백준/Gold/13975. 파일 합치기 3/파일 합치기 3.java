
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;// = new StringTokenizer(br.readLine());
       
       int t = Integer.parseInt(br.readLine());
       
       for(int T=0; T<t; T++)
       {
    	   int N = Integer.parseInt(br.readLine());
    	   
    	   PriorityQueue<Long> q = new PriorityQueue<>();
    	   
    	   st = new StringTokenizer(br.readLine());
    	   
    	   for(int i=0; i<N; i++)
    	   {
    		   q.add(Long.parseLong(st.nextToken()));
    	   }
    	   
    	   long cost=0;
    	   while(q.size() >=2)
    	   {
    		   long sum=0;
    		   sum += q.poll();
    		   sum += q.poll();
    		   cost += sum;
    		   
    		   q.add(sum);
    	   }
    	   
    	   bw.write(Long.toString(cost)+"\n");
    	   
       }
       bw.flush();
       bw.close();
   
       
    }
}

