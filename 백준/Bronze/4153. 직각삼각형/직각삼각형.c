#include<stdio.h>

int main()
{
	int a, b, c;
	int A, B, C;

	while (1)
	{
		scanf("%d %d %d", &a, &b, &c);
		if ((a == 0)&&(b == 0)&&(c == 0))
		{
			break;
		}
		A = a*a;
		B = b*b;
		C = c*c;
		if ((A+B)==C)
		{
			printf("right\n");
		}
		else if (A+C==B)
		{
			printf("right\n");
		}
		else if (B+C==A)
		{
			printf("right\n");
		}
		else
		{
			printf("wrong\n");
		}
	}

	return 0;
}