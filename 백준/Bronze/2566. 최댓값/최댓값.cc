#include <iostream>
#include <string>

using namespace std;

int main() {

	int a = 0;
	int b = 0;
	int max = -1;
	int t = 0;

	for (int i = 1; i <= 9; i++)
	{
		for (int j = 1; j <= 9; j++)
		{
			cin >> t;

			if (t > max)
			{
				max = t;
				a = i;
				b = j;
			}
		}
	}

	cout << max << "\n" << a << " " << b;

	return 0;
}