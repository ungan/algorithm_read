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

    int n;

    cin >> n;

    vector<int> array(n);

    for(int i=0; i<n; i++)
    {
        cin >> array[i]; 
    }

    sort(array.begin(),array.end());

    for(int i=0; i<n; i++) cout << array[i] << endl;
}