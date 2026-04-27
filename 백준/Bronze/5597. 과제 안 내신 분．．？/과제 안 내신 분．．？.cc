#include <iostream>
using namespace std;
int main()
{
	int array[30];
	fill(array, array + 30, 0);

	for (int i = 0; i < 28; i++)
	{
		int c;
		cin >> c;

		array[c - 1]++;
	}

	for (int i = 0; i < 30; i++)
	{
		if (array[i] == 0) cout << (i + 1) << endl;
	}
	
}