// cplus_study.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <sstream>

using namespace std;

int main()
{
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		for (int j = n; j > i; j--) {
			cout << " ";
		}
		for (int j = 0; j < i * 2 - 1; j++) {
			cout << "*";
		}
		cout << "\n";
	}

	for (int i = n-1; i >=1; i--) {
		for (int j = n; j > i; j--) {
			cout << " ";
		}
		for (int j = 0; j < i * 2 - 1; j++) {
			cout << "*";
		}
		cout << "\n";
	}


    //std::cout << "Hello World!\n";
}
