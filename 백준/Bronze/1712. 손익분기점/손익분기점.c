#include <stdio.h>
#include <string.h>


int main()
{
	int a, b, c, d;

	scanf("%d %d %d", &a, &b, &c);
	if (b >= c)
	{
		printf("-1");
	}
	else
	{
		d = c - b;
		a = a / d;
	
		printf("%d", a + 1);

	}
}