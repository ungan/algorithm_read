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

	if (a + b + c != 180)
	{
		cout << "Error";
		return 0;
	}
	
	if (a == b && b == c)
	{
		cout << "Equilateral";
	}
	else if (a == b || a == c || b == c)
	{
		cout << "Isosceles";
	}
	else
	{
		cout << "Scalene";
	}


	return 0;
}