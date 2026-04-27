#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>
#include<bits/stdc++.h>

using namespace std;

int main()
{
	ios :: sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> array(5);
    int total =0;
    int center =0;

    for(int i=0; i<5; i++)
    {
        cin >> array[i];
        total += array[i];
    }

    sort(array.begin(),array.end());

    cout << (total/5) << "\n" << array[2] << endl;

}
