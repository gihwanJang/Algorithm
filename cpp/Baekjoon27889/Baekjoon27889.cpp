#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    string s;
    cin >> s;

    if(s == "NLCS")
        cout << "North London Collegiate School" << "\n";
    else if(s == "BHA")
        cout << "Branksome Hall Asia" << "\n";
    else if(s == "KIS")
        cout << "Korea International School" << "\n";
    else
        cout << "St. Johnsbury Academy" << "\n";
    return 0;
}