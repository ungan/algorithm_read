#include <stdio.h>
#include <string.h>


int main()
{
	int W, H,N,T;   //w는 가로길이 h는 세로길이
	scanf("%d", &T);
	for (int i = 0; i < T; i++)
	{
		scanf("%d %d %d", &H, &W, &N);

		if (N / H < 1)
		{
			printf("%d\n", N*100+1);

		}
		else if (N%H == 0)
		{
			printf("%d\n",N/H+H*100);
		}
		else
			printf("%d\n", ((N / H)+1) + (N%H)*100);
	}
	return 0;
}