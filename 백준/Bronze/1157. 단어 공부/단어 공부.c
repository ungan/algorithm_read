#include <stdio.h>
#include <string.h>

int main()
{
	int max=0,mcode, strl, apbet[26] = {0},t;
	char word[1000000] = {0};
	int a;
	scanf("%s", word);
	a = 'a';
	strl = strlen(word);
	for (int i = 0; i < strl; i++)
	{
		if ('a' > word[i])
		{
			word[i] = word[i] + 32;
		}
	}

	for (int i = 'a'; i <= 'z'; i++)
	{
		for (int y = 0; y < strl; y++)
		{
			if (i == word[y])
			{
				apbet[i - 97]++;
			}
		}
	}
	for (int i = 0; i < 26; i++)
	{
		if (max < apbet[i])
		{
			max = apbet[i];
			t = i;
			mcode = 0;
		}
		else if (max == apbet[i])
			mcode = 1;
	}
	if (mcode == 1)
	{
		printf("?");
	}
	else
		printf("%c", t + 65);
}