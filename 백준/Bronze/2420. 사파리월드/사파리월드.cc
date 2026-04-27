#include <iostream>
#include <string>
#include <algorithm>
#include <cstdlib>

using namespace std;

int main() {
    long long A,B;
    cin >> A >> B;
    long long ans;

    if(A>B)
    {
        ans = A-B;
    }
    else ans = B-A;

    cout << ans<< "\n";

}