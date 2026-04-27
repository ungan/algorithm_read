import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        arr[1] = 1;
        if(n==1) {
        	System.out.println("1");
        	return;
        }
        
        arr[2] = 2;
        
        for(int i=3; i<=n; i++)
        {
        	arr[i]= arr[i-1]% 15746  + arr[i-2]% 15746 ;
        }
       
        System.out.println(arr[n]% 15746);
        //bw.write();
//        bw.flush();
//        bw.close();
//        br.close();

    }
    
}