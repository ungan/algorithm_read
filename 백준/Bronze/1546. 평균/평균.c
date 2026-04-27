#include<stdio.h>;

int main(void)
{
	int num[1000],num_sub,max,sum=0;
	double ans;

	scanf("%d", &num_sub);

	for (int i = 0; i < num_sub; i++)
	{
		scanf("%d", &num[i]);

	}
	max = num[0];
	for (int i = 1; i < num_sub; i++)
	{
		if (max < num[i])
			max = num[i];
	}
	for (int i = 0; i < num_sub; i++)
	{
		sum += num[i];
	}

	ans=sum *1.0 / num_sub / max * 100;

	printf("%f", ans);

	return 0;

}
