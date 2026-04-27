#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {

	int N;
	int K;

	cin >> N;
	cin >> K;

	int count = 0;

	for (int i = 1; i <= N; i++)
	{
		if (N % i == 0) count++;
		if (count == K)
		{
			cout << i << endl;
			//break;
			return 0;
		}

		
	}
	cout << 0;

	return 0;
}