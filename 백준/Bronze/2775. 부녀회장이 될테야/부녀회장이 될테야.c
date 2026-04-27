#include <stdio.h>
#include <string.h>


int main()
{
	int apt[15][15];
	int i, y;

	for (i = 0; i < 15; i++)
	{
		for ( y = 0; y < 15; y++)
		{
			apt[i][y] = 0;
		}
	}
	for (i = 0; i < 15; i++)
	{
		apt[i][0] = 1;    //이거세로 세로는 층
	}
	for (y = 0; y < 15; y++)
	{
		apt[0][y] = y+1;		//이거 가로는 호수
	}
	
	for (i = 1; i < 15; i++)
	{
		for ( y = 1; y < 15; y++)
		{
			apt[i][y] = apt[i-1][y] + apt[i][y-1];
		}
	}
	int n,a,b;
	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		scanf("%d %d", &a, &b);
		printf("%d\n", apt[a][b-1]);
	}

}