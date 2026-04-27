#include<stdio.h>

int main()
{
	int N, x[51] = { 0 }, y[51] = { 0 }, rank[51] = {0};

	scanf("%d",&N);

	for (int i = 0; i < N; i++)
	{
		scanf("%d %d", &x[i], &y[i]);
	}

	for (int i = 0; i < N; i++)
	{
		for (int v = 0; v < N; v++)
		{
			if ((x[i] < x[v]) && (y[i] < y[v]))
			{
				rank[i]++;
			}
		}
	}
	for (int i = 0; i < N; i++)
	{
		printf("%d ",rank[i]+1);
	}
	return 0;

}