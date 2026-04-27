#include<stdio.h>
int t=0;
int fn[21] = {0};
int cnt=0;

void fac(int f)
{
	fn[1] = 1;


	if (cnt > 0)
	{
		t = fn[cnt] + fn[cnt - 1];
		fn[cnt + 1] = t;
		//printf("%d : %d  %d : %d t: %d \n", cnt,fn[cnt],cnt-1,fn[cnt - 1],t);
	}
	else
	{
		t = 0;
	}

	cnt++;
	if (f == 0)
	{
		return;
	}
	fac(--f);
}

int main()
{
	int n;
	scanf("%d", &n);
	fac(n);


	printf("%d\n", fn[n]);
	return 0;
}