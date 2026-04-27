#include <iostream>
#include <string>
#include <algorithm>
#include <cstdlib>

using namespace std;

int main() {
    int a[5];

    for(int i=0; i<5; i++)
    {
        cin >> a[i];
       
    }

    int temp =0;

      for(int i=0; i<5; i++)
    {
        temp += a[i] * a[i];
        // cout << temp<< "\n";
    }

    temp %= 10;

    cout << temp<< "\n";

}