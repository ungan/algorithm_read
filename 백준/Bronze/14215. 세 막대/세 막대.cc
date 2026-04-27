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

	cin >> a >> b >> c;

	if (a < c)
	{
		int temp = a;

		a = c;
		c = temp;
	}

	if (a < b)
	{
		int temp = a;

		a = b;
		b = temp;
	}

	if (a < b + c) {
		cout << a + b + c;
		return 0;
	}

	cout << 2*(b + c)-1;

}