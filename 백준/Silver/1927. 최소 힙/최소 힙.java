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
       PriorityQueue<Integer> q = new PriorityQueue<Integer>();
       
       for(int i=0; i<N; i++)
       {
    	   int num = Integer.parseInt(br.readLine());
    	   if(num ==0)
    	   {
    		   if(q.size() == 0)
    		   {
    			   bw.write(Integer.toString(0) + "\n");
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
