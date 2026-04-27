import java.util.InputMismatchException;
import java.util.Scanner;


public class Main
{
	
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int arr1[] = new int[n];		// 원본
		int arr2[] = new int[n];		// 소수만 들어갈 배열
		int arr3[] = new int[n];		// 소수가 아닌 약수가 들어갈 배열
		int arr4[] = new int[n];		// 약수이면서 소수의 제곱중 가장 큰약수가 들어갈 배열
		int t=1; 						// 답
		int max=0;
		for(int i=0; i<n; i++)
		{
			arr1[i] = scan.nextInt(); 	// 약수를 받음
		}
		
		int c2=0,c3=0,c4=0;		//arr2 arr3의 갯수를 세어줄 배열들
		
		for(int num=0;num<n;num++)		// 가장큰 약수를 구해줌
		{
			if(max<arr1[num])
			{
				max= arr1[num];
			}
			
		}
		for(int num=0;num<n;num++)
		{
			int ans =0;
			for(int i=2; i<arr1[num];i++)
			{
				if(arr1[num]%i==0)
				{
					//System.out.println("소수가 아닙니다");
					arr3[c3] = arr1[num];
					ans++;
					c3++;
					break;
				}
			}
			
			if(ans == 0)
			{
				arr2[c2] = arr1[num];
				c2++;
				//System.out.println("소수입니다.");
			}
		}
		
		for(int num=0; num < c2; num++)		// 소수인 약수의 개수만큼 돌림
		{
			arr4[c4] = arr2[num];
			
			for(int num2=0; num2 < c3; num2++)		// 소수가 아닌 약수의 개수만큼 돌림
			{
				int count =0;
				int div=arr3[num2];
				boolean so;
				while(true)
				{
					if(div%arr2[num] != 0)
					{
						so = false;
						break;
					}
					div=div/arr2[num];
					//System.out.println("div : " + div + " arr[num] : " + arr2[num]);
					if(div == 1)
					{
						so = true;
						break;
					}
					if((div%arr2[num] != 0) || div == 0)
					{
						
						so = false;
						break;
					}
					count ++;
					
				}
				//System.out.println("so : " + so);
				if((so)&&(arr4[c4]<arr3[num2]))		// 소수의 제곱일경우임과 동시에 원래 있던 숫자 보다 큰경우
				{
					//System.out.println("arr3[num2] : " + arr3[num2] + " arr2[num] : " + arr2[num] + " arr4[c4] : " + arr4[c4]);
					arr4[c4] = arr3[num2];
					
				}
				
			}
			c4++;
			
		}
		//System.out.println("c2 : " + c2);
		if(c2==1)
		{
			//System.out.println("arr2[c2-1] : " + arr2[c2-1] + " arr2[c2-1] : "+ arr2[c2-1]);
			t = t * arr2[c2-1] * arr4[c4-1];
		}
		else
		{
			
			for(int num=0;num<c4; num++)
			{
				//System.out.println("arr4[c4-1] : " + arr4[num]);
				t = t * arr4[num];
			}
		}
		
		System.out.println(t);
		 
	}

}