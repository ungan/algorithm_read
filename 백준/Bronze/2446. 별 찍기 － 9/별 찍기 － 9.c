#include<stdio.h>;

int main()
{
	int a,cnt_u=0,n,cnt_d=0,b;
    
	scanf("%d", &a);
	n = a * 2 - 1;
	for (int i = 0; i < n; i++)
	{
		if (i <= n / 2)
		{
			for (int y = 0; y < i; y++)
			{
				printf(" ");
			}
		}

		for (int y = 0; y < n- cnt_u; y++)
		{
			printf("*");
		}
		
		if (i > n/ 2)
		{
			
			b = 3;
			for (int y = 0; y < n - i - 1; y++)
			{
				printf(" ");
			}			
			for (int y = 0; y < b + cnt_d; y++)
			{
				printf("*");
			}
			
			
			cnt_d += 2;
		}
		if(i <= n / 2)
			cnt_u += 2;
		
		printf("\n");
	}
}