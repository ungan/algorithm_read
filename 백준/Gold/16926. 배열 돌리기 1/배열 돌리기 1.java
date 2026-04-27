import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception
    {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int temp=0;
		int min =0;
		if(N<=M)
		{
			min = N;
		}
		else
		{
			min =M;
		}
		
		for(int a2 = 0; a2<R;a2++)
		{
			
			for(int t =0; t<min/2; t++)	// 몇번 돌아가는지
			{
				for(int i=t; i<M-t-1;i++)
				{
					if(i == t)
					{					
						temp = array[t][t];
						array[t][i] = array[t][i+1];
					}
					else
					{
						array[t][i] = array[t][i+1];
					}
				}
				
				for(int i=t; i<N-t-1;i++)
				{
					array[i][M-1-t] = array[i+1][M-1-t];
				}
				for(int i=M-t-1; i > t;i--)
				{
					array[N-1-t][i] = array[N-1-t][i-1];
					
				}
				for(int i=N-t-1; i > t;i--)
				{
					if(i-1 == t)
					{
						array[i][t] = temp;
					}
					else
					{					
						array[i][t] = array[i-1][t];
					}
				}
				
			}
			
		}

		for(int i=0; i < N; i++)
		{
			for(int y=0; y<M; y++)
			{
				System.out.print(array[i][y] + " ");
				
			}
			System.out.print("\n");
		}
    }
}