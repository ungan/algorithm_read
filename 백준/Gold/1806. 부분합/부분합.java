import java.net.*;
import java.io.*;
import java.util.*;

public class Main {
   
   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   
	   int N = Integer.parseInt(st.nextToken());
	   int S = Integer.parseInt(st.nextToken());
	   
	   int array[] = new int[N];
	   st = new StringTokenizer(br.readLine());
	   
	   for(int i=0; i<N; i++)
	   {
		   array[i] = Integer.parseInt(st.nextToken());
	   }
	   
	   int count=0;
	   int start =0;
	   int end =0;
	   int total = array[start];
	   int min =Integer.MAX_VALUE;
	   while(true)
	   {
		   //System.out.println("start : " + start + " end : " + end + " total : " + total);
		   if(total >= S && min > end -start+1)  min = end -start +1;
		   if(min == 1) break;
		   
		   if(total < S)
		   {
			   end++;
			   if(end >= N) break;
			   total += array[end];
		   }
		   else if(total >= S)
		   {
			   total -= array[start];
			   start++;
		   }
		   
		   
	   }
	   
	   //bw.write(Integer.toString(i));
	   if(min == Integer.MAX_VALUE) min =0;
	   bw.write(Integer.toString(min));
	   bw.flush();
	   bw.close();
	   br.close();
   }
   
}
