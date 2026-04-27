#include <stdio.h>
#include <string.h>


int main()
{
	int A, B, V,u,t;

	scanf("%d %d %d", &A, &B, &V);
	u=A - B;
	t = (V-A)/ u;

	if ((V - A) % u == 0)
	{
		printf("%d", t + 1);
	}
	else
		printf("%d", t + 2);
}