import java.util.InputMismatchException;
import java.util.Scanner;


public class Main
{
	
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int x[] = new int[4];
		int y[] = new int[4];
		int ans =0;
		
		double min,max;		
		int slope[][] = new int[4][2];		//slope 1 => 1,2, slope2 => 2,3, slope3 => 1,3
		double segment[] = new double[3];
		double hypotenuse[] = new double[3];
		
		for(int i=0; i<3; i++)
		{
			x[i] = scan.nextInt();
			y[i] = scan.nextInt();
			
			
		}

		slope[0] = slope(x[0],x[1],y[0],y[1]);	//(double)(x[0]-x[1])/(y[0] - y[1]);
		slope[1] = slope(x[1],x[2],y[1],y[2]);	//(double)(x[1]-x[2])/(y[1] - y[2]);
		slope[2] = slope(x[2],x[0],y[2],y[0]);	//(double)(x[2]-x[0])/(y[2] - y[0]);
		
		if(((slope[0][0]*slope[1][1])==(slope[1][0]*slope[0][1]))&&((slope[1][0]*slope[2][1])==(slope[2][0]*slope[1][1]))&&((slope[2][0]*slope[0][1])==(slope[0][0]*slope[2][1])))
		{
			ans = -1;
		}

		segment[0] = distance(x[0],x[1],y[0],y[1]);
		segment[1] = distance(x[1],x[2],y[1],y[2]);
		segment[2] = distance(x[2],x[0],y[2],y[0]);
		
		// 01 02 12
		
		hypotenuse[0] = (segment[0] + segment[1]) * 2;
		hypotenuse[1] = (segment[1] + segment[2]) * 2;
		hypotenuse[2] = (segment[2] + segment[0]) * 2;
		
		min = hypotenuse[0]; 
		max = hypotenuse[0];
		for(int i=0 ; i<3; i++)
		{
			//System.out.println("i : " + i + " " + slope[i]);
		}
		for(int i=0 ; i<3; i++)
		{
			//System.out.println("i : " + i + " " + segment[i]);
		}
		for(int i=0 ; i<3; i++)
		{
			//System.out.println("i : " + i + " " + hypotenuse[i]);
		}
		if(min > hypotenuse[1])
		{
			min = hypotenuse[1];
		}
		if(max < hypotenuse[1])
		{
			max = hypotenuse[1];
		}
		
		if(min > hypotenuse[2])
		{
			min = hypotenuse[2];
		}
		if(max < hypotenuse[2])
		{
			max = hypotenuse[2];
		}
		if(ans == -1)
		{
			System.out.println(ans);
		}
		else 
		{			
			System.out.println(String.format("%.15f",max-min));
		}
		
	}
	
	public static int[] slope(int x1, int x2, int y1, int y2)
	{
		String ans_;
		double ans;
		int x,y;
		
		if(x1 > x2)
		{
			x = x1;
			x1 = x2;
			x2 = x;
			
			y = y1;
			y1 = y2;
			y2 = y;
		}
		
		ans = (((double)(y2 - y1))/(x2 -x1));
		int a,b;
		a= x2- x1;
		b = y2 - y1;
		
		int c[] = new int[2];
		
		c[0] = a;
		c[1] = b;
		//ans_ = String.format("%.15f",ans);
		return c;
	}
	
	public static double distance(int x1, int x2, int y1, int y2)
	{
		
		double ans=1;
		
		ans = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		
		//System.out.println("ans : " + ans);
		
		return ans;
	}
}