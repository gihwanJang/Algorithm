#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int k;

bool cmp(string s1, string s2){
    if(s1[k] < s2[k]) return true;
    else if(s1[k] > s2[k]) return false;
    else{
        string small = s1.length() < s2.length() ? s1 : s2;
        string big = s1.length() < s2.length() ? s2 : s1;
        for(int i = 0; i < small.length(); ++i){
            if(small[i] < big[i]) return big == s2 ? true : false;
            else if(small[i] > big[i]) return big == s2 ? false : true;
        }
        return big == s2 ?  true : false;
    }
}

vector<string> solution(vector<string> strings, int n) {
    k = n;
    sort(strings.begin(), strings.end(), cmp);
    return strings;
}

int main(int argc, char const *argv[]){
    vector<string> strings = {"abced", "abce", "cda"};
    vector<string> answer = solution(strings, 2);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << "\n";
    return 0;
}
