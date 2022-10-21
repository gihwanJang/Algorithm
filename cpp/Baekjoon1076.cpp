#include<iostream>
#include<cmath>
#include<unordered_map>
using namespace std;

unordered_map<string,int> map(13);

void setting(){
    map.insert(make_pair("black", 0));
    map.insert(make_pair("brown", 1));
    map.insert(make_pair("red", 2));
    map.insert(make_pair("orange", 3));
    map.insert(make_pair("yellow", 4));
    map.insert(make_pair("green", 5));
    map.insert(make_pair("blue", 6));
    map.insert(make_pair("violet", 7));
    map.insert(make_pair("grey", 8));
    map.insert(make_pair("white", 9));
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long sum = 0;
    string s;

    setting();

    cin >> s;
    sum += map.at(s) * 10;
    cin >> s;
    sum += map.at(s);
    cin >> s;
    sum *= pow(10, map.at(s));

    cout << sum << "\n";
    return 0;
}
