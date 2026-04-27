
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int singer[] = new int[N+1];
    	ArrayList<ArrayList<Integer>> node = new ArrayList<>();
    	
    	Queue<Integer> ans = new LinkedList<>();
    	
    	for(int i=0; i<=N; i++) {
    		node.add(new ArrayList<Integer>());
    	}
    	
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int arr[] = new int[n];
    		
    		for(int j=0; j<n; j++) {
    			//System.out.println("aa1");
    			arr[j] = Integer.parseInt(st.nextToken());
    		}
    		
    		for(int j=0; j<n-1; j++) {
    			
				node.get(arr[j]).add(arr[j+1]);
				singer[arr[j+1]]++;
    			
    		}
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	
    	for(int i=1; i<=N; i++) {
    		if(singer[i] == 0) {
    			
    			//System.out.println("ii : " + i);
    			q.add(i);
    		}
    	}
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		
    		for(int n : node.get(cur)) {
    			singer[n]--;
    			//System.out.println("n : " + n);
    			if(singer[n] == 0) q.add(n);
    		}
    		ans.add(cur);
    	}
    	
    	if(ans.size() != N) {
    		bw.write("0");
    	}
    	else {
    		for(int i: ans) {
    			bw.write(Integer.toString(i) + "\n");
    		}
    	}
    	
    	//bw.write(state);
    	bw.flush();
    	bw.close();
    	br.close();
    }
    
	
}
