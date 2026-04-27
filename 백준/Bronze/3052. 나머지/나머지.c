#include<stdio.h>;

int main(void)
{
	int num[10];
	int remainder[10],cnt=0;

	for (int i = 0; i < 10; i++)
	{
		scanf("%d", &num[i]);
	}
	for (int i = 0; i < 10; i++)
	{
		remainder[i]=num[i]% 42;
	}
	for (int i = 0; i <= 41; i++)
	{
		for (int y = 0; y < 10; y++)
		{
			if (i == remainder[y])
			{
				cnt++;
				break;
			}
		}
	}

	printf("%d",cnt);

	return 0;

}
