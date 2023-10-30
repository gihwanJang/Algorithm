#include <algorithm>
#include <iostream>
#include <string>

using  namespace std;

char getMostChar(string&s) {
    if(s.length() == 1) return toupper(s[0]);

    vector<pair<int,int>> charMap(26);
    for(int i = 0; i < 26; ++i) 
        charMap[i].second = i;
    for(int i = 0; i < s.length(); ++i) 
        --charMap[toupper(s[i]) - 'A'].first;
    sort(charMap.begin(), charMap.end());

    if(charMap[0].first == charMap[1].first) return '?';
    return charMap[0].second + 'A';
}

int main(int argc, char const *argv[]){
    string s;
    cin >> s;
    cout << getMostChar(s) << "\n";
    return 0;
}