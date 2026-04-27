import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        long last = 2;
        
        for(int i=6; i<=100; i++)
        {
        	arr[i] = arr[i-5] + last;
        	last = arr[i];
        }
        int t = Integer.parseInt(br.readLine());
        
        for(int i=0; i<t; i++)
        {
        	int n = Integer.parseInt(br.readLine());
        	sb.append(arr[n] + "\n");
        }
        
        
        
        
        System.out.println(sb);
        //bw.write();
//        bw.flush();
//        bw.close();
//        br.close();

    }
    
}