#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {

	while (true)
	{
		int a;
		int b;

		cin >> a;
		cin >> b;

		if (a == 0 && b == 0) break;

		if (b / a >= 1 && b % a == 0)
		{
			cout << "factor\n";
		}
		else if (a / b >= 1 && a % b == 0)
		{
			cout << "multiple\n";
		}
		else
		{
			cout << "neither\n";
		}

	}

	return 0;
}