#include<stdio.h>;

int main()
{
	int a[3], b[2],c=2000,d=2000;

	scanf("%d %d %d %d %d", &a[0], &a[1], &a[2], &b[0], &b[1]);

	for (int i = 0; i < 3; i++)
	{
		if (c > a[i])
			c = a[i];
	}
	for (int y = 0; y < 2; y++)
	{
		if (d > b[y])
			d = b[y];
	}
	printf("%d", c + d - 50);
	return 0;
}