#include <stdio.h>


int main()
{
	int ans = 0, bcode = 0, a[10000] = {0};
	for (int i = 1; i <= 10000; i++)
	{
		a[i] = i;
	}
	for (int i = 1; i <= 10000; i++)
	{
		ans = i + i / 1000 + (i%1000) / 100 + (i%100) / 10 + i % 10;  // ans 는 셀프넘버가 아닌수가 생성
		if (ans <= 10000)
		{
			a[ans] = a[ans] - ans;
		}
	}
	for (int i = 0; i < 10000; i++)
	{
		if (a[i] > 0)
			printf("%d\n", a[i]);
	}
	return 0;
}