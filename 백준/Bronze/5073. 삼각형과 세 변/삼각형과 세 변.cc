#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <list>
#include <vector>

using namespace std;


int main()
{
	int a, b, c;


	while (true)
	{
		cin >> a >> b >> c;
		
		if (a == 0 && b == 0 && c == 0)
		{
			return 0;
		}
		if (a < b)
		{
			int temp = a;
			a = b;
			b = temp;
		}

		if (a < c)
		{
			int temp = a;
			a = c;
			c = temp;
		}

		if (a >= b + c)
		{
			cout << "Invalid" << endl;
		}
		else if (a == b && a== c)
		{
			cout << "Equilateral" << endl;
		}
		else if (a == b || a == c || b == c)
		{
			cout << "Isosceles" << endl;
		}
		else
		{
			cout << "Scalene" << endl;
		}

	}
	return 0;
}