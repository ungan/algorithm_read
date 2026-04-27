#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
	int n;

	cin >> n;

	int t = 2;

	for (int i = 0; i < n; i++)
	{
		t += t - 1;
	}

	cout << t * t;

	return 0;
}