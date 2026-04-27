#include <iostream>
#include <string>

using namespace std;

int main() {

	int N;
	int M;

	cin >> N;
	cin >> M;

	int array_A[101][101];
	int array_B[101][101];

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> array_A[i][j];
		}

	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> array_B[i][j];
		}
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cout << array_A[i][j] + array_B[i][j] << " ";
		}

		cout << "\n";
	}

	return 0;
}