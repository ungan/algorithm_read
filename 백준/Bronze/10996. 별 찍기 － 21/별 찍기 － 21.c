#include<stdio.h>;

int main()
{
	int n;

	scanf("%d",&n);

	for (int i = 0; i < n; i++)
	{
		for (int y = 0; y < n / 2 + n % 2; y++)
			printf("* ");
		printf("\n");
		for (int y = 0; y < n / 2; y++)
			printf(" *");
		printf("\n");
		
	}

}