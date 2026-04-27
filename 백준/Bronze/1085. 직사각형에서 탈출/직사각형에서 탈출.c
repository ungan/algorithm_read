#include<stdio.h>

// x>=1 x<=w-1 y>=1 y<=h-1
int main()
{
	int x, y, w, h,a[4],t=10001;

	scanf("%d %d %d %d", &x, &y, &w, &h);

	a[0] = w - x;
	a[1] = h - y;
	a[2] = x;
	a[3] = y;

	for (int i = 0; i < 4; i++)
	{
		if (t > a[i])
		{
			t = a[i];
		}
	}
	printf("%d",t);
	return 0;
}