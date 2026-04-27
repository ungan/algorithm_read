import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        int array[][] = new int[3][2];
        
        for(int i=0; i<3;i++)
        {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b=  Integer.parseInt(st.nextToken());
        	
        	array[i][0] = a;
        	array[i][1] = b;
        	
        }
       
        
        int x1 = array[0][0];
        int y1 = array[0][1];
        int x2 = array[1][0];
        int y2 = array[1][1];
        int x3 = array[2][0];
        int y3 = array[2][1];
        
        int n = (x1-x2)*(y1-y3) - (x1-x3)*(y1-y2);
               
        if(n > 0)
        {
        	bw.write("1");
        }
        else if(n==0)
        {
        	bw.write("0");
        }
        else
        {
        	bw.write("-1");
        }
       // bw.write(String.valueOf(cellOn.size() + cellOff.size()));
        bw.flush();
        bw.close();
        br.close();
    }

   
}
