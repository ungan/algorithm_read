#include <iostream>
#include <string>

using namespace std;

int main() {
	int n;

	cin >> n;
	int count = 0;

	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		char temp = s[0];
		bool arr[26] = {false};
		arr[s[0] - 'a'] = true;

		for (int j = 0; j < s.length(); j++) {
			if (temp != s[j] && arr[s[j] - 'a']) {
				count--;
				break;
			}
			else if (temp != s[j] && !arr[s[j] - 'a']) {
				temp = s[j];
				arr[s[j] - 'a'] = true;
			}
		}

		count++;
	}

	cout << count;
	return 0;
}