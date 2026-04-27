#include<stdio.h>

int main()
{
	int Num=10000;
	int i, t, r;
	//scanf("%d", &Num);
	int so[10001];
	int cnt = 0;
	int sot[1300];
	for(int i=2;Num>=i;i++)
	{
		so[i] = 1;
	}
	
	for (r = 2; r <= 1000; r++)
	{
		//printf("r\n");
		if (so[r] == 0)
		{
			continue;
		}
		for (t = r*2; t <= Num; t += r)			//num이있어서 2나 나올떄 가장 큰값까지 뺼수있음
		{
			//printf("t %d r %d\n",t,r);
			so[t] = 0;

		}
	}
	for (i = 1; i < Num; i++)
	{
		if (so[i] == 1)
		{
			//printf("%d : %d\n ", cnt,i);
			sot[cnt] = i;
			cnt++;
		}
	}
	
	int n;
	
	scanf("%d",&n);			//몇번돌지
	for(int y=0; y<n;y++)
	{
		int even,ecnt=0;
		int fir=0, sec=0,t;
		scanf("%d",&even);
		cnt = 0;
		if (even >= 9973)
		{
			cnt = 1228;
		}
		else {
			while (1)
			{
				if (even < sot[cnt])
				{
					cnt--;
					break;
				}
				cnt++;

			}

		}
		//if (even == 5)
		//{
		//	printf("2 3");
		//}
		t = 10000;
		//for (int a = (cnt / 2 + cnt % 2); a >= 0; a--)
		for(int a=0; a<=cnt;a++)
		{
			//for (int b = (cnt / 2 + cnt % 2); b <= cnt; b++)
			for(int b=cnt;b>=a;b--)
			{
				if ((sot[a] + sot[b]) == even)
				{
					if (t > b - a)
					{
						t = b - a;
						fir = a;
						sec = b;
					}
				}
			}
		}
		printf("%d %d\n", sot[fir], sot[sec]);
	}
	return 0;
}
