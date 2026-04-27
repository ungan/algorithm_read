#include<stdio.h>;

int main()
{
	int n,s;
	scanf("%d", &n);
	s = 0;
	for (int i=1; i <= n; i++)
	{
		s = s + i;
	}
	printf("%d", s);

}