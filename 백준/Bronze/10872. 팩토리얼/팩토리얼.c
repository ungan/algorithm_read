#include<stdio.h>
int t=1;
void fac(int f)
{
	if (f == 0)
	{
		return;
	}
	t = t * f;
	fac(--f);
}

int main()
{
	int n;
	scanf("%d", &n);
	fac(n);


	printf("%d\n", t);
	return 0;
}