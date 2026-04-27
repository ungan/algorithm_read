import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static char map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i=0; i<N; i++)
		{
			String s = br.readLine();
			
			for(int j=0; j<N; j++)
			{
				map[i][j]= s.charAt(j);
			}
		}
		
		String total = partition(0,0,N);
		
		System.out.println(total);
		
	}
	
	static String partition(int row,int col, int size)
	{
		if(check(row,col,size)) return Character.toString(map[row][col]);
		
		int nsize = size/2;
		String c = "";
		c += '('+partition(row,col,nsize);
		c += partition(row,col+nsize,nsize);
		c += partition(row+nsize,col,nsize);
		c += partition(row+nsize,col+nsize,nsize);
		c += ')';
		
		return c;
		
	}
	
	static boolean check(int row, int col, int size)
	{
		char start = map[row][col];
		for(int i = row; i<row+size; i++)
		{
			for(int j= col; j<col+size;j++)
			{
				if(map[i][j] != start) return false;
			}
		}
		 return true;
	}

}
