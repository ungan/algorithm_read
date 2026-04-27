import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	
    public static void main(String[] args) throws Exception
    {
    	
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	//StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(br.readLine());
    	//int k = Integer.parseInt(st.nextToken());
    	StringBuilder sb = new StringBuilder();
    	
    	ArrayList<Integer> list = new ArrayList<>();

    	for(int i=0; i <n; i++)
    	{
    		//array[i] = Integer.parseInt(br.readLine());
    		list.add(Integer.parseInt(br.readLine()));
    	}
    	
    	
    	//parallelSort
    	Collections.sort(list);
    	/*
    	for(int i=0; i < list.size(); i++)
    	{
    		System.out.println(list.get(i));
    	}*/
    	
    	for(int value : list)
    	{
    		sb.append(value).append('\n');
    	}
    	System.out.println(sb);
    	
    }
    
    public static void countingSortEfficient(int[] array) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();

        int[] count = new int[max - min + 1];

        for (int num : array) {
            count[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                array[index++] = i + min;
            }
        }
    }

}
