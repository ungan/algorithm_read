#include<stdio.h>;

int main()
{
	int n;

	scanf("%d", &n);
	n = 2 * n - 1;

	for (int i = 1; i <= n; i++)
	{
		if (i <= n / 2 + n % 2)
		{
			for (int y = 0; y < i; y++)
			{
				printf("*");
			}
		}
		else
		{
			for (int y = n; y >= i; y--)
			{
				printf("*");
			}
		}


		printf("\n");
	}
	return 0;
}