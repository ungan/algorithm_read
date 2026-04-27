#include <iostream>
using namespace std;
int main()
{
	int n;
	cin >> n;

	int* array = new int[n];

	for (int i = 0; i < n; i++)
	{
		cin >> array[i];
	}

	int t;
	cin >> t;
	int count = 0;
	for (int i = 0; i < n; i++) {
		if (array[i] == t) count++;
	}

	cout << count << endl;

}