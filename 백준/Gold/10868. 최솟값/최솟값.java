import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int tree[];
	
	static int build(int node, int start, int end, int arr[]) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start+end) / 2;
		int leftMin = build(node * 2, start, mid, arr);
		int rightMin = build(node * 2 + 1, mid + 1, end, arr);
		tree[node] = Math.min(leftMin, rightMin);
		return tree[node];
	}
	
	static int query(int node, int start, int end, int left, int right) {
		if(right < start || end < left) return Integer.MAX_VALUE;
		if(left <= start && end <= right) return tree[node];
		
		int mid = (start+end)/2;
		int leftMin = query(node * 2, start, mid, left, right);
		int rightMin = query(node * 2 +1, mid+1, end, left, right);
		return Math.min(leftMin, rightMin);
	}
	
	static void update(int node, int start, int end, int idx, int val)
	{
		if(idx < start || idx > end) return;
		if(start == end) {
			tree[node] = val;
			return;
		}
		
		int mid = (start + end)/2;
		update(node *2, start, mid, idx, val);
		update(node * 2+ 1, mid + 1, end, idx, val);
		tree[node] = Math.min(tree[node *2],tree[node * 2+1]);
	}
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int array[] = new int[n];
    	tree = new int[n*4];
    	for(int i=0; i<n; i++) {
    		array[i] = Integer.parseInt(br.readLine());
    	}
    	
    	build(1,0,n-1,array);
    	
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		int num = query(1, 0, n-1, a-1, b-1);
    		bw.write(Integer.toString(num) + "\n");
    	}
    	
    	//bw.write(longeger.toString(dp[n]));
    	bw.flush();
    	bw.close();
    	br.close();
    }
    
}
