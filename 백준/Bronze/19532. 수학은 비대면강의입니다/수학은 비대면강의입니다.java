import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int x = a+d;
		int y = b + e;
		int t = c +f;
		
		for(int i=-999; i<1000;i++)
		{
			for(int j=-999; j<1000; j++)
			{
				int temp1 = a * i + b * j;
				int temp2 =  d * i + e * j;
				if(temp1 == c && temp2 == f)
				{
					System.out.println(i + " " + j);
					break;
				}
			}
		}
		
	}
	

}
