#include <iostream>
#include <string>

using namespace std;

int main()
{
	string s;
	int n;

	cin >> s;
	cin >> n;

	cout << s.at(n-1);
}