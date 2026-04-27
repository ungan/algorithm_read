#include <iostream>
#include <cctype>

using namespace std;

int main() {
    string s;
    string ans;
    cin >> s;

    for(char c : s)
    {
        if(c>='A' && c <= 'Z')
        {
            ans += tolower(c);
        } 
        else
        {
            ans += toupper(c);
        }
    }

    cout << ans;

}