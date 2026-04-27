import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 int n,a,b;
		 int[] number = new int[5];
		 int[] t = new int[6];
		 int total=1000;
		 Scanner scan = new Scanner(System.in);
		 
		 a = scan.nextInt();
		 b = scan.nextInt();
		 n = scan.nextInt();
		 
		 for(int i =0; i<n; i++)
		 {
			 number[i] = scan.nextInt();
		 }
		 t[0] = Math.abs(a-b);
		 
		 for(int i=1; i<n+1;i++)
		 {
			 t[i] = Math.abs(b - number[i-1])+1;
		 }
		 
		 for(int i=0; i<n+1;i++)
		 {
			 if(total > t[i])
				 total = t[i];
		 }
		 
		 
		 System.out.println(total);
		   
	}
		
}