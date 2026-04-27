import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception
    {
    	
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());

    	
    	int []array = new int[n];
    	st = new StringTokenizer(br.readLine());
    	int sum=0;
    	for(int i=0; i <n; i++)
    	{
    		array[i] = Integer.parseInt(st.nextToken());
    	}

    	Arrays.sort(array);
    	
    	
    	System.out.println(array[n-k]);
    	/*
    	for(int i=0; i <a; i++)
    	{
    		System.out.println(array[i]);
    	}*/
    }
}
