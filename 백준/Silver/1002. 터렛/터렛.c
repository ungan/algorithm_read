#include<stdio.h>
#include<math.h>
//c = sqrt((a + b));
int main()
{
	int x1, x2, y1, y2, r1, r2;

	double t; //t는 두 중심사이의 거리
	double a,b,c; //a는 |x+x|값 제곱,b는 |y+y|제곱 c는 두원의 반지름의 차
	double br, sr; //b 큰반지름  s 작은 반지름

	int n; // n값은 도는 횟수
	int i;
	scanf("%d", &n);
	
	for (i = 0; i < n; i++)
	{

		scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);
	
		
		if (x1 > x2)
		{
			a = x1 - x2;
		}
		else
		{
			a = x2 - x1;
		
		}
		if (y1 > y2)
		{
			b = y1 - y2;
		}
		else
		{
			b = y2 - y1;
		}
		if (r1 > r2)
		{
			c = r1 - r2;
			br = (double)r1;
			sr = (double)r2;
		}
		else
		{
			c = r2 - r1;
			br = (double)r2;
			sr = (double)r1;
		}
		a = a*a;
		b = b*b;
		int y = 0;
		t = sqrt((a + b));
		//printf("r1 : %d r2 : %d", r1, r2);
		//printf("sr : %lf br : %lf t : %lf\n", sr, br, t);
		if ((x1 == x2) && (y1 == y2)&&(r1 == r2))
		{
			printf("-1\n");
		}
		else if((sr + t) < br)
		{
			printf("0\n");
		}
		else if (t>(br+sr))
		{
			printf("0\n");
		}
		else if((br < (sr + t))&&(t < (br + sr)))
		{
			printf("2\n");
		}
		else
		{
			printf("1\n");
		}
		
	}

	return 0;

}
