#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

void set_map(unordered_map<string, int>&map){
    string nums[10] = {"zero", "one", "two", "three", "four",
     "five", "six", "seven", "eight", "nine"};
    for(int i = 0; i < 10; ++i)
        map.insert(make_pair(nums[i], i));
}

int solution(string s) {
    int answer = 0;
    unordered_map<string, int> map(13);
    string num = "";

    set_map(map);
    for(int i = 0; i < s.length(); ++i){
        if(47 < s[i] && s[i] < 58)
            answer = answer * 10 + s[i] - 48;
        else
            num.push_back(s[i]);
        if(map.count(num)){
            answer = answer * 10 + map.find(num) -> second;
            num.clear();
        }
    }

    return answer;
}

int main(int argc, char const *argv[]){
    string s = "one4seveneight";
    cout << solution(s) << "\n";
    return 0;
}
