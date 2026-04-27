#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

bool isprime(int n)
{
	if (n < 2) return false;

	for (int i = 2; i * i <= n; i++)
	{
		if (n % i == 0) return false;
	}

	return true;
}


int main()
{
	int a;
	int b;

	cin >> a >> b;
	
	int total = 0;
	int min = b + 1;

	for (int i = a; i <= b; i++)
	{
		if (isprime(i)) {
			total += i;
			if (min > i) min = i;
		}
	}
	
	if(total != 0) cout << total << "\n" << min << endl;
	else cout << -1;

}