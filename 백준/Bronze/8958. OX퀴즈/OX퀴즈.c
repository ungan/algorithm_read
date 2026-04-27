#include<stdio.h>

int main()
{
	int num,total=0,cnt=0;
	scanf("%d", &num);

	for (int i = 0; i < num; i++)
	{
		char str[100] = { 0 };
		scanf("%s", str);
		total = 0;
		cnt = 0;
		for (int y = 0; y < 80; y++)
		{
			if (str[y] == 'O')
			{
				cnt++;
				total += cnt;
			}
			if (str[y] == 'X')
			{
				cnt = 0;
			}
		}
		printf("%d\n", total);
	}
}
