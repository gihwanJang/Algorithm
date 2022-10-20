#include <iostream>
#include <string>
#include <vector>
#include <numeric>

using namespace std;

double solution(vector<int> arr) {
    return accumulate(arr.begin(), arr.end(), double(0)) / arr.size();
}

int main(int argc, char const *argv[]){
    vector<int> arr = {1,2,3,4,5,6};
    cout << solution(arr) << "\n";
    return 0;
}
