import java.util.InputMismatchException;
import java.util.Scanner;


public class Main
{
	
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();	// 집합s의 개수
		int s[] = new int[num];		// 집합s의 개수만큼 배열 생성
		int min=1000,max=-1;

		for(int i=0;  i < num; i++)
		{
			s[i] = scan.nextInt();
		}
		
		int x = scan.nextInt(); 	// x 값 받아옴
		
		int ans=-1;		// 답
		
		for(int i=0; i< num; i++)
		{
			if((s[i] < min))
			{
				min = s[i];
			}
			if(s[i] > max)
			{
				max = s[i];
			}
		}
		//System.out.println("x : " + x + " min : " + min);
		

		if( x < min)
		{
			ans = x * (min-x)-1;
		}

		min = -1;
		max = 1000;	// A <= x <= B 일떄 A = min, B= max 초기값으로 x를 넣어줌 min,max -1보다 크고 1000보다 작다.이용
		if(ans == -1)
		{
			//System.out.println("a");
			for(int i=0; i<num; i++)
			{
				if(s[i] == x)		// 만약 같은 수 존재 그러면 좋은 구간 존재 불가
				{
					ans =0;
				}
				else		// 같은 수 아닐경우 돌아가는 부분
				{
					if(s[i] - x < 0)	// min 은 x보다 작은것중 가장큰것
					{
						if(min < s[i])
						{
							min = s[i];
						}
					}
					else
					{
						if(max > s[i])		// max는 x보다 큰것중 가장 작은것
						{
							max = s[i];
						}
					}
				}
				
			}
			//if(((x-min)==1)&&((max-x)==1))
			//{
				
			//}
			if(ans == -1)
			{
				ans = (x-min) * (max-x)-1;
			}
		}
		
		System.out.println(ans);
	}

}
