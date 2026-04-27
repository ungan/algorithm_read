#include<stdio.h>;

int main()
{
	int a[5], eva=0;
	for (int i = 0; i < 5; i++)
	{
		scanf("%d", &a[i]);
		
		if (a[i] < 40)
		{
			a[i] = 40;
		}
		eva += a[i];
		
	}

	printf("%d", (int)(eva*0.2));

	

	
	return 0;
}