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
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		String[][] s = new String[M][N];
		
		for(int i=0; i<M; i++)
		{
			String s_input = br.readLine();
			
			for(int y=0; y<N; y++)
			{
				s[i][y]=String.valueOf(s_input.charAt(y));
			}
		}
		int min=M*N;
		
		for(int x=0; x<=M-8; x++)
		{
			for(int y2=0; y2<=N-8;y2++)
			{
				int [] array = new int[2];
				for(int i=x; i<8+x; i++)
				{
					for(int y=y2; y<8+y2; y++)
					{
						if(i%2==0)
						{
							//System.out.println("i" + i + "y : " + y);
							if(y%2 ==0 && s[i][y].equals("W"))
							{
								//ans_B[i][y] = "B";
								array[0]++;
							}
							else if(y%2 ==1 && s[i][y].equals("B"))
							{
								//ans_B[i][y] = "W";
								array[0]++;
							}
						}
						else
						{
							if(y%2 ==0 && s[i][y].equals("B"))
							{
								//ans_B[i][y] = "W";
								array[0]++;
							}
							else if(y%2 ==1 && s[i][y].equals("W"))
							{
								//ans_B[i][y] = "B";
								array[0]++;
							}
						}
						
						if(i%2==0)
						{
							if(y%2 ==0 && s[i][y].equals("B"))
							{
								//ans_W[i][y] = "W";
								array[1]++;
							}
							else if(y%2 ==1 && s[i][y].equals("W"))
							{
								//ans_W[i][y] = "B";
								array[1]++;
							}
						}
						else
						{
							if(y%2 ==0 && s[i][y].equals("W"))
							{
								//ans_W[i][y] = "B";
								array[1]++;
							}
							else if(y%2 ==1 && s[i][y].equals("B"))
							{
								//ans_W[i][y] = "W";
								array[1]++;
							}
						}
						
					}
				}
				//System.out.println("array[0] " + array[0] + "array[1] : " + array[1]);
				if(min > array[0])
				{
					min = array[0];
				}
				
				if(min > array[1])
				{
					min = array[1];
				}
				
			}
		}
		
		
		//Arrays.sort(array);
		System.out.println(min);
		
	}
	

}

/*
String[][] ans_B = new String[8][8];
String[][] ans_W = new String[8][8];

for(int i=0; i<8; i++)
{
	String s_input = br.readLine();
	
	for(int y=0; y<8; y++)
	{
		s[i][y]=String.valueOf(s_input.charAt(y));
	}
}

for(int i=0; i<8; i++)
{
	for(int y=0; y<8; y++)
	{
		if(i%2==0)
		{
			if(y%2 ==0)
			{
				ans_B[i][y] = "B";
			}
			else
			{
				ans_B[i][y] = "W";
			}
		}
		else
		{
			if(y%2 ==0)
			{
				ans_B[i][y] = "W";
			}
			else
			{
				ans_B[i][y] = "B";
			}
		}
	}
}

for(int i=0; i<8; i++)
{
	for(int y=0; y<8; y++)
	{
		if(i%2==0)
		{
			if(y%2 ==0)
			{
				ans_W[i][y] = "W";
			}
			else
			{
				ans_W[i][y] = "B";
			}
		}
		else
		{
			if(y%2 ==0)
			{
				ans_W[i][y] = "B";
			}
			else
			{
				ans_W[i][y] = "W";
			}
		}
	}
}
*/
