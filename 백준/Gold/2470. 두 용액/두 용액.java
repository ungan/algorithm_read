import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception
    {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	//long n = longeger.parselong(st.nextToken());
    	
    	
    	int num = Integer.parseInt(st.nextToken());
    	
    	long[] array = new long[num];
    	st = new StringTokenizer(br.readLine());
    	long plus=0;
    	int x=0,y=0;
    	for(int i = 0; i < num;i++)
    	{
    		array[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(array);
    	for(long i = 0; i < num;i++)
    	{
    		//System.out.prlong(array[i] + " ");
    	}
    	int s=0; 
    	int e=num-1;
    	x=0;
    	y=1;
    	
    	long min = array[0]+array[1];
    	
    	if(min <0) min = min *(-1);
    	
    	while(s < e)
    	{
    		long temp = array[s]+array[e];
    		if(temp <0) temp = temp *(-1);
    		
    		//System.out.println("min : " + min + "temp : " + temp);
    		
    		if(temp<min) 
    		{
    			min = temp;
    			x= s;
    			y = e;
    			
    		}
    		
    		if((array[s]+array[e]) <0)
    		{
    			s++;
    		}
    		else
    		{
    			e--;
    		}

    	}
    	//System.out.println("temp2 : " + temp2);
    	System.out.println(array[x] + " " + array[y]);
    	
    }
}
// -1000000000