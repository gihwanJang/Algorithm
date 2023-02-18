#include <iostream>
#include <list>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    list<int> nums;
    for(int i = N; i > 0; --i){
        nums.push_front(i);
        for(int j = 0; j < i; ++j){
            int c = nums.back();
            nums.pop_back();
            nums.push_front(c);
        }
    }

    for(int num : nums)
        cout << num << " ";
    cout << "\n";
    return 0;
}
