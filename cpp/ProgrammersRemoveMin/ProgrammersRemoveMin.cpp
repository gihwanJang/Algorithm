#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int>::iterator remove = arr.begin();
    for(vector<int>::iterator iter = arr.begin(); iter != arr.end(); ++iter)
        if(*remove > *iter)
            remove = iter;
    arr.erase(remove);
    if(arr.size() == 0)
        arr.push_back(-1);
    return arr;
}

int main(int argc, char const *argv[]){
    vector<int> arr = {1,2,3,4};
    vector<int> answer = solution(arr);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << ", ";
    return 0;
}
