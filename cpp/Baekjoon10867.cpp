#include <iostream>
#include <set>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    set<int> nums;
    for(int n; N > 0; --N){
        cin >> n;
        nums.insert(n);
    }

    for(set<int>::iterator it = nums.begin(); it != nums.end(); ++it)
        cout << *it << " ";
    return 0;
}
