#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	int N;
	int B;

	cin >> N;
	cin >> B;

	string s = "";

	while (N != 0)
	{
		int remainder = N % B;

		if (remainder < 10) {
			s += (char)(remainder + '0');
		}
		else {
			s += (char)(remainder - 10 + 'A');
		}

		N /= B;
	}

	reverse(s.begin(), s.end());

	cout << s;
	return 0;
}