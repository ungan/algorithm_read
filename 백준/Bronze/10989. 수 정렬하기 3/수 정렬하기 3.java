import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main{
	
    public static void main(String[] args) throws Exception
    {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	//StringBuilder sb = new StringBuilder();
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	//StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(br.readLine());
    	int[] array = new int[100001];
    	
    	
    	//StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i=0; i<n; i++)
    	{
    		int a=Integer.parseInt(br.readLine())-1;
    		
    		array[a]++;
    		//System.out.println("a : " + a + "array[a]" + array[a]);
    	}
    	
       	
    	for(int j=0; j<100001;j++)
    	{
    		for(int i=0; i<array[j];i++)
        	{
        		//System.out.print((j+1)+ "\n");
        		//sb.append((j+1)+ "\n");
    			bw.write((j+1)+"\n");
        	}
    	}
    	bw.flush(); // 꼭 호출해줘야 실제 출력됨
    	bw.close();
    	/*
    	for(int value : array)
    	{
    		sb.append(value + '\n');
    	}*/
    	//System.out.print(sb);
    	
    	
    }
    
}
