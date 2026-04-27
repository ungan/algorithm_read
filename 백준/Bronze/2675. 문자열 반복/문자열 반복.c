#include <stdio.h>
#include <string.h>

int main()
{
	int T=0,R=0;
	char S[20] = { 0 };

	scanf("%d", &T);
	
	

	for (int i = 0; i < T; i++)
	{
		scanf("%d", &R);
		scanf("%s", S);
		for (int b = 0; b < strlen(S); b++)
		{
			for (int y = 0; y < R; y++)
			{
				
				printf("%c", S[b]);
			}
		}

		printf("\n");
	}

}