
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        int n =Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n+1];
        
        int before = Integer.parseInt(st.nextToken());
        
        int after;
        int count =0;
        
        for(int i=2; i<=n; i++) {
        	after = Integer.parseInt(st.nextToken());
        	if(before > after) count++;
        	before = after;
        	arr[i] = count;
        }
        
        int N = Integer.parseInt(br.readLine());
       
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	bw.write(Integer.toString(arr[b]-arr[a])+"\n");
        }
        
        
        //bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        
        
    }
}