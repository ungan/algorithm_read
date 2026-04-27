#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <list>
#include <vector>

using namespace std;


int main()
{
	int n;
	cin >> n;

	int max_x, min_x, max_y, min_y;

	max_x = -10001;
	min_x = 10001;
	max_y = -10001;
	min_y = 10001;

	if (n < 2)
	{
		cout << 0;
		return 0;
	}

	for (int i = 0; i < n; i++)
	{
		int x, y;

		cin >> x >> y;

		if (max_x < x) max_x = x;
		if (min_x > x) min_x = x;
		if (max_y < y) max_y = y;
		if (min_y > y) min_y = y;


	}

	//cout << min_x << " " << max_x << " " << min_y << " " << max_y;

	cout << ((max_x - min_x) * (max_y - min_y));

	return 0;
}