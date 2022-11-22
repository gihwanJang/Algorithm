#include <iostream>
#include <vector>

using namespace std;

int counting(vector<int>&table, int n){
    int count = 0;

    for(int i = 1; i * i <= n; ++i)
        if(n % i == 0){
            if(table[i])
                count += table[i];
            if(table[n / i]){
                if(i * i != n)
                    count += table[n / i];
                if(i == 1)
                    count -= 1;
            }
        }

    return count;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> nums(N);
    vector<int> table(1000001);

    for(int i = 0; i < N; ++i){
        cin >> nums[i];
        ++table[nums[i]];
    }

    for(int i = 0; i < N; ++i)
        cout << counting(table, nums[i]) << "\n";
    
    return 0;
}
