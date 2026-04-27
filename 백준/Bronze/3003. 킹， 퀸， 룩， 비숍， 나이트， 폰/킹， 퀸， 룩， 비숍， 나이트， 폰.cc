#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;

int main()
{
	int array[] = {1,1,2,2,2,8};

    int n;

    for(int i=0; i<6; i++)
    {
        cin >> n;

        array[i] -= n;
    }

    for(int i=0; i<6; i++)
    {
        cout << array[i] << " ";
    }
}