#include <stdio.h>


int main()
{
	int N,ans=0;
	char a[100] = {0};
	scanf("%d", &N);
	scanf("%s", a);

	
	for (int i = 0; i < N; i++)
	{
		ans = ans + a[i]-48;
	}
	printf("%d", ans);
	
	return 0;
}