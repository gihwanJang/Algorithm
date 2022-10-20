#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <cmath>

using namespace std;

void putR(string&answer, int&r, int k){
    answer += "R";
    r = k;
}

void putL(string&answer, int&l, int k){
    answer += "L";
    l = k;
}

int distence(int a, int b){
    if(a == 0) a = 11;
    if(b == 0) b = 11;
    --a;
    --b;
    pair<int, int> x(a / 3, a - 3 * (a / 3)), y(b / 3, b - 3 * (b / 3));

    return abs(x.first - y.first) + abs(x.second - y.second);
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int r = 10, l = 12;

    for(int i = 0; i < numbers.size(); ++i){
        if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7)
            putL(answer, l, numbers[i]);
        else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9)
            putR(answer, r, numbers[i]);
        else{
            if(distence(r, numbers[i]) > distence(l, numbers[i]))
                putL(answer, l, numbers[i]);
            else if(distence(r, numbers[i]) < distence(l, numbers[i]))
                putR(answer, r, numbers[i]);
            else{
                if(hand.compare("right") == 0)
                    putR(answer, r, numbers[i]);
                else
                    putL(answer, l, numbers[i]);
            }
        }
    }

    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    cout << solution(numbers, "right") << "\n";
    return 0;
}
