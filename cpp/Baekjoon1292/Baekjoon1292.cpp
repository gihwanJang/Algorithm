#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int start, end, ans = 0;
    cin >> start >> end;

    vector<int> arr;
    for(int i = 1; arr.size() <= end; ++i)
        for(int j = 0; j < i; ++j){
            arr.push_back(i);

            if(start <= arr.size() && arr.size() <= end)
            ans += arr.back();
        }

    cout << ans << "\n";
    return 0;
}
