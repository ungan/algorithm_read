#include <iostream>
using namespace std;

int main()
{
	int X;
	int N;

	cin >> X >> N;

	int a, b;
	for (int i = 0; i < N; i++)
	{
		cin >> a >> b;

		X -= a * b;
	}

	if (X == 0) cout << "Yes" << endl;
	else cout << "No" << endl;
	
}