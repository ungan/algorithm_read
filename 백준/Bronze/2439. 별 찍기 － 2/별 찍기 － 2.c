#include<stdio.h>;

int main()
{
	int T;
	scanf("%d", &T);

	for (int i = 1; i <= T; i++)
	{
		for (int y = T; i < y; y--)
		{
			printf(" ");
		}
		for (int y= 0;y<i;y++)
		{
			printf("*");

		}
		printf("\n");
	}
	return 0;
}