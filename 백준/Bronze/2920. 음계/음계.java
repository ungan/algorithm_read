import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	//StringBuilder sb = new StringBuilder();
    	String state = "0";
    	int arr[] = new int[8];
    	arr[0] = Integer.parseInt(st.nextToken());
    	
    	for(int i=1; i<8; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		if(Math.abs(arr[i] - arr[i-1]) != 1) state = "mixed";
    	}
    	
    	if(state.equals("0")) {
    		if(arr[0] < arr[1]) state = "ascending";
    		else state = "descending";
    	}
    	
    	
    	bw.write(state);
    	bw.flush();
    	bw.close();
    	br.close();
    }
    
	
}
