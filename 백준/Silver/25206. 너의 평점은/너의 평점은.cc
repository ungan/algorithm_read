#include <iostream>
#include <string>

using namespace std;

int main() {

	double total_Credit = 0;
	double total_grade = 0;
	for (int i = 0; i < 20; i++)
	{
		string s;
		cin >> s;

		double d;
		cin >> d;

		string grade;
		cin >> grade;

		if (grade == "P") continue;

		if (grade == "A+") total_grade += 4.5 * d;
		if (grade == "A0") total_grade += 4.0 * d;
		if (grade == "B+") total_grade += 3.5 * d;
		if (grade == "B0") total_grade += 3.0 * d;
		if (grade == "C+") total_grade += 2.5 * d;
		if (grade == "C0") total_grade += 2.0 * d;
		if (grade == "D+") total_grade += 1.5 * d;
		if (grade == "D0") total_grade += 1.0 * d;
		
		total_Credit += d;
	}

	cout << total_grade / total_Credit;

	return 0;
}