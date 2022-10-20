#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer(2,0);
    int cnt, currNum;
    while(true){
        cnt = 0;
        for(int i = 0; i < s.length(); ++i)
            if(s[i] == '0') ++cnt;
        answer[1] += cnt;
        currNum = s.length() - cnt;
        if(currNum == 1) break;
        s.clear();
        s += currNum & 1 ? '1' : '0';
        reverse(s.begin(), s.end());
        ++answer[0];
    }
    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> ans = solution("110010101001");
    for(int i = 0; i < ans.size(); ++i)
        cout << ans[i] << "\n";
    return 0;
}
