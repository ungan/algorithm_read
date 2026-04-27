import java.util.InputMismatchException;
import java.util.Scanner;


public class Main
{
	
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cnt = 0;
		for(int i=64; i>=1; i/=2)
		{
			if(n >= i)
			{
				cnt++;
				n = n-i;
			}
			
			if(n==0)
			{
				break;
			}
		}
		
		System.out.println(cnt);
	}
}

