#include<stdio.h>

int main()
{
	int N, M,num[101],t=0,s;
	scanf("%d %d",&N,&M);

	for (int i = 0; i < N; i++)
	{
		scanf("%d",&num[i]);
	}

	for (int i = 0; i < N-2 ; i++)
	{
		for (int y = i+1; y < N-1; y ++)
		{
			for (int v = y + 1; v < N; v++)
			{
				s = num[i] + num[y] + num[v];
				if (M >= s)
				{
					if ((M - t) > (M - s))
					{
						//printf("%d\n",s);
						t = s;
					}
				}
			}
		}
	}

	printf("%d", t);
}