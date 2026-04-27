#include<stdio.h>;

int main(void)
{

	int c;

	int n,num[1001],sum=0,eva,cnt;
	double total;

	scanf("%d", &c);

	for (int i = 0; i < c; i++)
	{
        sum =0;
		cnt = 0;
		scanf("%d", &n);
		
		for (int y = 0; y < n; y++)
		{
			scanf("%d", &num[y]);
		}
		for (int y = 0; y < n; y++)
		{
			sum += num[y];
		}
		eva = sum / n;
		for (int y = 0; y < n; y++)
		{
			if (eva < (double)num[y])
			{
				cnt++;
			}
		}
		total = cnt*1.0 / n;
		printf("%0.3lf%%\n", total*100);
	}
	
	return 0;

}
