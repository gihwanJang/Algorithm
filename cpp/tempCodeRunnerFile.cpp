#include <iostream>
#include <vector>

using namespace std;

int binary_search(vector<int>&table, int end, int target){
    int low = 0, high = end, mid;
    while(low <= high) {
        mid = (low + high) / 2;

        if (table[mid] == target)
            return mid;
        else if (table[mid] > target)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return high;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, num, ans = 0;
    cin >> N >> num;

    vector<int> table(N);
    table[0] = num;
    for(int i = 1; i < N; ++i){
        cin >> num;
        if(table[ans] < num){
            table[++ans] = num;
        }
        else{
            int k = binary_search(table, ans, num);
            table[k] = num;
        }
    }     
    
    cout << ans + 1 << "\n";
    return 0;
}