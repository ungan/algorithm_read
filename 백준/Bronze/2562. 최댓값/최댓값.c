#include<stdio.h>;
#include <stdlib.h>

int main(void)
{

	int  a=9, max, num;

	int n[9] = {0};
	

	for (int i = 0; i < a; i++)
	{

		scanf("%d", &n[i]);
	}
	max = 0;
	for (int i = 0; i < a; i++)
	{
		if (max < n[i])
		{
			max = n[i];
			num = i;
		}
	}
	printf("%d\n%d", max, num +1);

	return 0;


}
