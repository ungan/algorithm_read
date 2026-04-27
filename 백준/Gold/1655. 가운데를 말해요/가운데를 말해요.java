
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;// = new StringTokenizer(br.readLine());
       
       int N = Integer.parseInt(br.readLine());
       PriorityQueue<Integer> q_min = new PriorityQueue<>();			// 중앙값 보다 큰 것 넣기
       PriorityQueue<Integer> q_max = new PriorityQueue<>(Collections.reverseOrder());		// 중앙값 보다 작은 것 넣기
       
       for(int i=0; i<N; i++)
       {
    	   int num = Integer.parseInt(br.readLine());
    	   //q_min.add(Integer.parseInt(br.readLine()));
    	   if(q_max.isEmpty())
    	   {
    		   q_max.add(num);    		   
    	   }
    	   else
    	   {
    		   if(q_max.peek() < num)
    		   {
    			   q_min.add(num);
    	
    		   }
    		   else
    		   {
    			   q_max.add(num);
    		   }
    	   }
    	   
    	   if(q_min.size() - q_max.size() >=2)
    	   {
    		   q_max.add(q_min.poll());
    	   }
    	   else if(q_max.size() -q_min.size() >=2)
    	   {
    		   q_min.add(q_max.poll());
    	   }
    	   
    	   if(i%2 == 1)
    	   {
    		   //System.out.println("a1");
    		   bw.write( q_max.peek()+"\n");
    	   }
    	   else
    	   {
    		   if(q_min.size() > q_max.size())
    		   {
    			   //System.out.println("a2");
    			   bw.write(q_min.peek() + "\n");
    		   }
    		   else
    		   {
    			   //System.out.println("a3");
    			   bw.write(q_max.peek() + "\n"); 
    		   }
    	   }
    	   
       }
       
       //bw.write(null);
       bw.flush();
       bw.close();
   
       
    }
}

