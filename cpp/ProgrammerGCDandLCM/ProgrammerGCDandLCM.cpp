#include <iostream>
#include <string>
#include <vector>

using namespace std;

int GCD(int n, int m){
    if(m == 0) return n;
    else return GCD(m, n % m);
}

vector<int> solution(int n, int m) {
    vector<int> answer;
    answer.push_back(GCD(n, m));
    answer.push_back(n * m / answer[0]);
    return answer;
}

int main(int argc, char const *argv[]){
    int n = 6, m = 12;
    cout << solution(n, m)[0] << ", " << solution(n, m)[1] << "\n";
    return 0;
}
