#include <stdio.h>
#include <string.h>

int main()
{
	int Num;
	int i,cnt,n;
	//scanf("%d", &Num);

	
	long long r, t, so[800000] = { 0 };
	
	for (r = 2; r <= 246912; r++)						//개수 
	{
		for (t = r * 2; t <= 246912; t += r)			//숫자의 범위
		{
			so[t] = 1;
		}
	}
	while (1)
	{
		scanf("%d",&n);
		if (n==0)
		{
			break;
		}
		cnt = 0;
		for (i = n+1; i <= n*2; i++)
		{
			if (so[i] == 0)
			{
				//printf("%d\n", i);
				cnt++;
			}
		}
		printf("%d\n", cnt);

	}

	return 0;
}
