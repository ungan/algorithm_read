#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int a, b, c;
	int total = 0;

	cin >> a >> b >> c;

	if (a == b && b == c && a == c)
	{
		total = 10000 + a * 1000;
	}
	else if (a != b && b != c && a != c)
	{
		int temp = max(a, b);
		temp = max(temp, c);
		total = temp * 100;
	}
	else
	{
		if (a == c)
		{
			total = 1000 + a * 100;
		}
		else if(a == b)
		{
			total = 1000 + a * 100;
		}
		else
		{
			total = 1000 + b * 100;
		}
	}

	cout << total << endl;
}