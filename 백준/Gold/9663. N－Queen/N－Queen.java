import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean col[],slash[],bSlash[];
	static int count=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		col = new boolean[N+1];
		slash = new boolean[N*2+1];
		bSlash = new boolean[N*2];
		
		count=0;
		set_qeen(1);
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
	}
	
	static void set_qeen(int row)
	{
		if(row>N)
		{
			count++;
			return;
		}
		
		//System.out.println(row);
		
		for(int c=1; c<=N; c++)
		{
			if(col[c] || slash[row+c]|| bSlash[row-c+N]) continue;
			
			col[c] = slash[row+c] = bSlash[row-c+N] = true;
			
			set_qeen(row + 1);
			
			col[c] = slash[row+c] = bSlash[row-c+N] = false;
		}
	}
	


}

