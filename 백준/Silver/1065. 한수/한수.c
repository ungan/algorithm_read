#include <stdio.h>


int main()
{
	int a,ans=0, d[3];
	scanf("%d", &a);
	for (int i = 1; i <= a; i++)
	{
		if (1000 == i)
			break;
		
		if(i<100)
			ans++;
		
		if (i >= 100)
		{
		
			d[0] = i / 100;
			d[1] = (i % 100) / 10;
			d[2] = i % 10;

			
			if ((d[1] == ((d[0] + d[2]) / 2))&&((d[0] + d[2]) % 2 == 0))
			{

				ans++;
			}
		}

			
	}
	printf("%d",ans);

	return 0;
}