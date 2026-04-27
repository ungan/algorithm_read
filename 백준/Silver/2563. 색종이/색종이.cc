#include <iostream>
#include <string>

using namespace std;

int main() {

	int map[100][100];

	int n = 0;
	cin >> n;

	for (int i = 0; i < 100; i++)
	{
		for (int j = 0; j < 100; j++)
		{
			map[i][j] = 0;
		}
	}

	for (int i = 0; i < n; i++)
	{
		int a;
		int b;

		cin >> a;
		cin >> b;

		for (int x = a; x < a + 10; x++)
		{
			for(int y=b; y < b+ 10; y++)
			{
				map[x][y] = 1;
			}
		}
	}

	int count = 0;

	for (int i = 0; i < 100; i++)
	{
		for (int j = 0; j < 100; j++)
		{
			count += map[i][j];
		}
	}

	cout << count;

	return 0;
}