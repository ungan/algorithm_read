#include<stdio.h>

int main()
{
	int N;
	scanf("%d", &N);

	for (int i = 0; i < 10; i++)
	{
		for (int y = 0; y < 10; y++)
		{
			for (int v = 0; v < 10; v++)
			{
				for (int a = 0; a < 10; a++)
				{
					for (int b = 0; b < 10; b++)
					{
						for (int c = 0; c < 10; c++)
						{
							if (N == (i+y+v+a+b+c+c+10*b+100*a+1000*v+10000*y+100000*i))
							{
								printf("%d\n", c + 10 * b + 100 * a + 1000 * v + 10000 * y + 100000 * i);
								return 0;
							}
							
						}
					}

				}
			}
		}
	}
	printf("0");

	return 0;

}