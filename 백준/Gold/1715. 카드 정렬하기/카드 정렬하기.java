import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;// = new StringTokenizer(br.readLine());
       
       int N = Integer.parseInt(br.readLine());
       
       PriorityQueue<Integer> q = new PriorityQueue<>();
       
       for(int i=0; i<N; i++)
       {
    	   q.add(Integer.parseInt(br.readLine()));
       }
       
      
       int t_sum=0;
       
       while(q.size() >= 2)
       {
    	 int sum=0;
    	 
    	 sum += q.poll();  
    	 sum += q.poll();
    	 
    	 q.add(sum);
    	 t_sum += sum;
       }
       
       bw.write(Integer.toString(t_sum));
       bw.flush();
       bw.close();
   
       
    }
}
