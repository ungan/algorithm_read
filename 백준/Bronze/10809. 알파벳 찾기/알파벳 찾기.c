#include <stdio.h>
#include <string.h>

int main()
{
	int strl,pcode=0;
	char S[100] = { 0 };
	int ans[26] = { 0 };
	int  a,b;
	scanf("%s", S);
	strl = strlen(S);
	for (int i = 'a'; i <= 'z'; i++)
	{
		pcode = 1;
		for (int y = 0; y <=strl; y++)
		{
			if (i == S[y])
			{
				ans[i-97] = y;
				pcode = 2;
				break;
			}
		}
		if (pcode==1)
		{
			ans[i-97] = - 1;
		}
	}
	for (int i = 0; i <26; i++)
	{
		printf("%d ", ans[i]);
	}
	


	
	return 0;
}