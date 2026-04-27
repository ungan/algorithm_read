#include <iostream>

using namespace std;
int main()
{
	int N, M;

	cin >> N >> M;

	int* array = new int[N];
	fill(array, array + N, 0);
	for (int i = 0; i < M; i++)
	{
		int a;
		int b;
		int c;
		cin >> a >> b >> c;

		for (int j = a-1; j <= b-1; j++)
		{
			array[j] = c;
		}
	}

	for (int i = 0; i < N; i++)
	{
		cout << array[i] << " ";
	}
}