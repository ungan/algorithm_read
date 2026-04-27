import java.io.*;
import java.util.*;

class Main {
	
	static PriorityQueue<Integer> max_pq;
	static PriorityQueue<Integer> min_pq;
	
    public static void main(String[] args) throws IOException {		// 할당 및 입출력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(br.readLine());
        
        for(int T=0; T<t; T++)
        {
        	max_pq = new PriorityQueue<Integer>();					// 오른쪽 부분 큰것 중에 가장 작은게 peek
        	min_pq = new PriorityQueue<Integer>(Collections.reverseOrder());		// 왼쪽 부분 작은것 중에 가장 큰게 peek
        	
        	int n = Integer.parseInt(br.readLine());
        	
        	st = new StringTokenizer(br.readLine());
        	
        	bw.write(Integer.toString(n/2+1) + "\n");
        	
        	int count =0;
        	
        	for(int i=1; i<=n; i++)
        	{
        		//System.out.print("i : " + i);
        		
        		int num = Integer.parseInt(st.nextToken());
        		
        		if(i % 10 == 0) st = new StringTokenizer(br.readLine());
        		
        		//System.out.println(" num : " + num);
        		if(min_pq.size() <= max_pq.size()) {
        			min_pq.add(num);
        		}
        		else
        		{
        			max_pq.add(num);
        		}
        		
        		if((!min_pq.isEmpty() && !max_pq.isEmpty()) && min_pq.peek() > max_pq.peek()) {
        			int temp_min = min_pq.poll();
        			int temp_max = max_pq.poll();
        			min_pq.add(temp_max);
        			max_pq.add(temp_min);
        		}
        		
        		if(i%2 == 1)
        		{
        			count++;
        			bw.write(Integer.toString(min_pq.peek()) + " ");
        		}
        		
        		if(count == 10 && i != n) {
        			count = 0;
        			bw.write("\n");
        		}
        		
        	}
        	bw.write("\n");
        }

        bw.flush();
        bw.close();       
    }

}