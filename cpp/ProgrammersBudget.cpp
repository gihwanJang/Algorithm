#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> d, int budget) {
    int answer = 0;
    sort(d.begin(), d.end());
    for(; budget > 0 && answer < d.size(); ++answer)
        budget -= d[answer];
    return budget >= 0 ? answer : answer - 1;
}

int main(int argc, char const *argv[]){
    vector<int> d = {1,3,2,5,4};
    cout << solution(d, 9) << "\n";
    return 0;
}
