#include<stdio.h>;

int main()
{
	int N, X, c[10000];

	scanf("%d%d", &N, &X);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &c[i]);
	}
	for (int i = 0; i < N; i++)
	{
		if (c[i] < X)
		{
			printf("%d ", c[i]);
		}
	}

	return 0;
}