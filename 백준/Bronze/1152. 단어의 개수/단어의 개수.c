#include <stdio.h>
#include <string.h>


int main()
{
	char s1[1000001];
	int d,a = 0,t=0;

	scanf("%[^\n]s",s1);
	d = strlen(s1);

	for (int i = 0; i < d; i++)
	{
		//if (s1[0] == ' ')
			//continue;
		if (d == 1)
		{
			if (('a' <= s1[i]) && (s1[i] <= 'z') || ('A' <= s1[i]) && (s1[i] <= 'Z'))
			{
				a++;
			}
		}
		else
			if (t == 0)
			{
				if (('a' <= s1[i]) && (s1[i] <= 'z') || ('A' <= s1[i]) && (s1[i] <= 'Z'))
				{
					a++;
					t = 1;
				}
			}
			if (s1[i] == ' ')
			{
				t = 0;
			}

		
	}
	printf("%d", a);

	return 0;

}