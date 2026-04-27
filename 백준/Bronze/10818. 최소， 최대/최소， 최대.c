#include<stdio.h>;
#include <stdlib.h>

#define MAX_SIZE 1000000

int main(void)
{

	int  a, min, max;
	scanf("%d",&a);

	int *n;
	n = (int *)malloc(sizeof(int) * MAX_SIZE);

	for (int i = 0; i < a; i++)
	{

		scanf("%d", &n[i]);
	}
	min = n[0];
	max = n[0];
	for (int i = 1; i < a; i++)
	{
		if (min > n[i])
		{
			min = n[i];
		}
		if (max < n[i])
		{
			max = n[i];
		}
	}
	printf("%d %d", min, max);

	return 0;


}
