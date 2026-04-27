#include <stdio.h>
#include <string.h>


int main()
{
	int N,i,d=0,a=2,b=8,d2=6;
	scanf("%d", &N);
	
	if (N == 1)
	{
		printf("1");
		return 0;

	}
	if((2<=N)&&(N<=7))
	{
		printf("2");
		return 0;
	}
	for (i = 2;;i++)
	{
		d += 6;
		d2 += 6;
		a += d ;
		b += d2;
		if ((a <= N) && (N < b))
		{
			printf("%d", i+1);
			break;
		}
	}
}