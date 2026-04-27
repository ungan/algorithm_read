#include<stdio.h>

int main()
{
	int a[8];

	scanf("%d %d %d %d %d %d",&a[0],&a[1],&a[2],&a[3],&a[4],&a[5]);

	if (a[0] == a[2])
	{
		a[6] = a[4];
	}
	else if (a[0] == a[4])
	{
		a[6] = a[2];
	}
	else {
		a[6] = a[0];
	}

	if (a[1] == a[3])
	{
		a[7] = a[5];
	}
	else if (a[1] == a[5])
	{		
		a[7] = a[3];
	}
	else
	{

		a[7] = a[1];
	}

	printf("%d %d\n", a[6], a[7]);

	return 0;
}