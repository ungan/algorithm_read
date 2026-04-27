#include <iostream>
using namespace std;
int main()
{
	int N;
	int M;

	cin >> N >> M;

	int* array = new int[N];

	for (int i = 0; i < N; i++)
	{
		array[i] = i+1;
	}

	for (int i = 0; i < M; i++)
	{
		int temp = 0;
		int a, b;
		cin >> a >> b;

		temp = array[a-1];
		array[a - 1] = array[b - 1];
		array[b - 1] = temp;
	}

	for (int i = 0; i < N; i++)
	{
		cout << array[i] << " ";
	}
}