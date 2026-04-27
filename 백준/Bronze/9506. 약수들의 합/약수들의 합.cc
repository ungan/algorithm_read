#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {

	while (true)
	{
		int N;

		cin >> N;

		if (N == -1) break;


		int total = 0;
		string s = to_string(N) + " =";

		for (int i = 1; i <= N / 2; i++)
		{
			if (N%i == 0) {
				s += " " + to_string(i);
				total += i;
				if (i != N / 2) s += " +";
			}

		}

		if (total == N) {
			cout << s << "\n";
		}
		else
		{
			cout << N << " is NOT perfect.\n";
		}
	}

	return 0;
}