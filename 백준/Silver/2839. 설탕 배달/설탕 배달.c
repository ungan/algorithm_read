#include <stdio.h>
#include <string.h>


int main()
{
	int a, b=5, c=3,t=0;

	scanf("%d", &a);
	//t = a / b + (a%b)/c;
	//if ((a%b) % c != 0)
		//if (a%c != 0)
	if (a%b == 0)
	{
		printf("%d", a / b);
	}
	else if ((a%b) % c == 0)
	{
		printf("%d", a / b + (a%b) / c);
	}
	else if (a%b == 4)
		if (a < 9)
			printf("-1");
		else
			printf("%d", a / b + (a%b) / c+1);
	else if (a%b == 2)
	{
		if (a < 12)
			printf("-1");
		else
			printf("%d", a / b + (a%b) / c + 2);
	}
	else if (a%b == 1)
	{
		if (a < 6)
			printf("-1");
		else
			printf("%d", a / b + (a%b) / c + 1);
	}

}