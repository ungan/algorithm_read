import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[10];
        
        for(int i=1; i<10; i++)
        {
        	arr[i] = 1;
        }
        
        for(int i=1; i<n ; i++)
        {
        	long temp[] = new long[10];
        	
        	for(int j=1; j<9; j++)
        	{
        		temp[j-1] += arr[j];
        		temp[j+1] += arr[j];
        	}
        	temp[1] += arr[0];
        	temp[8] += arr[9];
        	
        	 for(int j=0; j<=9; j++)
             {
        		 temp[j] = temp[j] % 1000000000;
             }
        	 
        	arr = temp;
        }
        
        
        
        long total=0;
        
        for(int i=0; i<=9; i++)
        {
        	total += arr[i];
        }
        System.out.println(total % 1000000000);

    }
    
}