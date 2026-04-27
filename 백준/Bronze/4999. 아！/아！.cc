#include <iostream>
#include <cctype>

using namespace std;

int main() {
    string a,b;

    cin >> a >> b;

    if(a.size() >= b.size()) cout << "go";
    else cout << "no";

}