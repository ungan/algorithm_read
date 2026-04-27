#include<stdio.h>;

int main()
{
	int a[3],b;

	scanf("%d %d %d", &a[0], &a[1], &a[2]);

	for (int i=0;i<3;i++)
	{
		for (int y = i;y<3;y++)
		{
			if (a[i] < a[y])
			{
				b = a[i];
				a[i] = a[y];
				a[y] = b;
			}
		}
	}
	printf("%d", a[1]);
	return 0;
}