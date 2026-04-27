#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
	int n;

	cin >> n;

	int Q, D, N, P;

	for (int i = 0; i < n; i++)
	{
		int t = 0;
		cin >> t;

		Q = t / 25;
		t = fmod(t, 25);

		D = t / 10;
		t = fmod(t, 10);

		N = t / 5;
		t = fmod(t, 5);

		P = t / 1;
		//t = fmod(t, 0.01);

		cout << Q << " " << D << " " << N << " " << P << "\n";

	}

	return 0;
}