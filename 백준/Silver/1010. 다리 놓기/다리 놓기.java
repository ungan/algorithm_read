import java.util.InputMismatchException;
import java.util.Scanner;


public class Main
{
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int c = scan.nextInt();
		
		for(int y = 0; y<c; y++)
		{
			int N = scan.nextInt();
			int M = scan.nextInt();
			long ans = 1;
			long ans2 = 1;
			int a,b;
			
			
			a = M - N > N ? M-N : N;
			b = M - N < N ? M-N : N;
			//System.out.println("a : " + a + " b : "  +b);
			for(int i = M; i > a; i--)		// M - N > N ? M-N : N
			{
				//System.out.println(i);
				ans *=i;
			}
			for(int i = b; i>1; i--)
			{
				//System.out.println(i);
				ans2 *= i;
			}
			
			//System.out.println("ans : " + ans);
			//System.out.println("ans2 : " + ans2);
			//System.out.println("ans/ans2 " + ans/ans2);
			System.out.println(ans/ans2);
		}
		
	}

}
