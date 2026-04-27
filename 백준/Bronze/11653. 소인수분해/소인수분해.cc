#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int main()
{
	int n;

	cin >> n;

	for (int i = 2; i * i <= n; i++)
	{
		while (n %i == 0)
		{
			n /= i;
			cout << i << endl;
		}
	}

	if(n != 1) cout << n << endl;

}