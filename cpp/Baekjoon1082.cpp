#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

string cmp(string num1, string num2){
    if(num1.size() != num2.size())
        return num1.size() > num2.size() ? num1 : num2;
    else
        return max(num1, num2);
}

string makeNum(string num1, string num2){
    if(num1 == "0")
        return num2;
    return num1 + num2;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> nums(N);
    for(int i = 0; i < N; ++i)
        cin >> nums[i];

    int M;
    cin >> M;
    vector<string> table(M + 1, "0");

    for(int i = 0; i <= M; ++i){
        for(int j = 0; j < N; ++j)
            if(i + nums[j] <= M)
                table[i + nums[j]] = cmp(table[i + nums[j]], makeNum(table[i], to_string(j)));
    }

    cout << table[M] << "\n";
    return 0;
}
