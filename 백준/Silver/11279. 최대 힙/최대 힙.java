import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;// = new StringTokenizer(br.readLine());
       
       int N = Integer.parseInt(br.readLine());
       
       PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
       
       for(int i=0; i<N; i++)
       {
    	   int num = Integer.parseInt(br.readLine());
    	   if(num == 0)
    	   {
    		   if(q.peek() == null)
    		   {
    			   bw.write("0\n");
    		   }
    		   else
    		   {
    			   bw.write(Integer.toString(q.poll()) + "\n");
    		   }
    	   }
    	   else
    	   {
    		   q.add(num);
    	   }
       }
       
       bw.flush();
       bw.close();
   
       
    }
}

