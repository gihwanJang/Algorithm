#include <string>
#include <vector>
#include <iostream>
using namespace std;

string remove_dot_front(string answer){
    int front_i = 0;
        while (front_i < answer.length() &&answer.at(front_i) == '.')
            ++front_i;
    return answer = answer.substr(front_i, answer.length() - front_i);
}

string remove_dot_back(string answer, int l){
    int back_i = l;
        while (back_i > 0 && answer.at(back_i - 1) == '.')
            --back_i;
    return answer = answer.substr(0, back_i);
}

string solution(string new_id) {
    string answer = "";
    for(int i = 0; i < new_id.length(); ++i){
        // 1. lowwer
        if(new_id.at(i) > 64 && new_id.at(i) < 91)
            new_id.at(i) += 32;
        // 2. remove_char
        if((new_id.at(i) > 47 && new_id.at(i) < 58) || (new_id.at(i) > 96 && new_id.at(i) < 123) || new_id.at(i) == 45 || new_id.at(i) == 95)
            answer += new_id.at(i);
        // 3. period_replacement
        if(new_id.at(i) == 46 && answer.back() != 46)
            answer += new_id.at(i);
    }
    // 4-1. remove_dot_front
    if(answer.front() == '.')
        answer = remove_dot_front(answer);
    // 4-2. remove_dot_back
    if(answer.back() == '.')
        answer = remove_dot_back(answer, answer.length());
    // 5. not_null
    if(answer.length() == 0)
        answer += 'a';
    // 6. reduce_char
    if(answer.length() > 15)
        answer = remove_dot_back(answer, 15);
    // 7. filling
    while(answer.length() < 3)
        answer += answer.back();
    return answer;
}

int main(int argc, char const *argv[]){
    string s;
    cin >> s;
    cout << solution(s) << "\n";
    return 0;
}
