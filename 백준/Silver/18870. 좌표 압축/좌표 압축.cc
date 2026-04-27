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

    if(!(cin>>n)) return 0;
    vector<long long> a(n),b;
    for(int i=0; i<n; i++){
        cin >> a[i];
    }

    b = a;
    sort(b.begin(),b.end());
    b.erase(unique(b.begin(),b.end()),b.end());


    for(int i=0; i<n; i++){
        int idx = lower_bound(b.begin(),b.end(),a[i]) - b.begin();
        cout << idx;
        if(i+1 <n) cout << ' ';
    }

    cout << '\n';
    return 0;

}