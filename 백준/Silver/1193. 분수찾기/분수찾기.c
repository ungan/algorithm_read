#include <stdio.h>
int main()
{
	int a=0,X,i,u,d;

	scanf("%d", &X);
	for (i = 1;; i++)
	{
		a += 1;
		X -= a;
		if (X  <= 0)
		{
			X += a;
			break;
		}
	}

	if (i % 2 == 0)
	{
		u = X;
		d = i-X+1;
		printf("%d/%d", u,d);
	}
	else
	{
		u = i - X + 1;
		d = X;
		printf("%d/%d", u, d);
	}
}