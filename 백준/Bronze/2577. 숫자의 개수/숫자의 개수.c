#include<stdio.h>;

int main(void)
{
	int a, b=0, c=0,t,portion,remainder;
	int num[10] = { 0,1,2,3,4,5,6,7,8,9 };
	int num_n[10] = { 0 };

	scanf("%d %d %d", &a, &b, &c);

	t = a * b*c;

	while (1)
	{
		remainder = t % 10;
		t /= 10;
		

		num_n[remainder]++;
		

		if (t / 10 == 0)
		{
			num_n[t]++;
			break;
		}
	}
	for (int i = 0; i < 10; i++)
	{
		printf("%d\n",num_n[i]);
	}
	return 0;

}
