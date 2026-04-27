#include<stdio.h>;

int main()
{
	int n=0, a,f,s,b,c;
	scanf("%d", &a);
	b = a;

	while (1)
	{
		
		if (b < 10)
		{
			c = 10 * b;    
			f = c / 10;		
			s = c % 10;			
			b = (f + s) % 10 + b * 10; 
		}
		else
		{
			f = b / 10;
			s = b % 10;
			b = (f + s) % 10 + s * 10;
		}
		if (a == b)
		{
			printf("%d", n+1);
			break;
		}
		else
		{
			n++;
		}
		
	}

	
	return 0;
}
