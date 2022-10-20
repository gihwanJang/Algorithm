#include <iostream>
#include <vector>

using namespace std;

int N, K, cnt = 0;

void merge_sort(vector<int> &nums, int p, int r){
    if(p < r){
        int q = (p + r) / 2;
        merge_sort(nums, p, q);
        merge_sort(nums, q + 1, r);
        merge(nums, p, q, r);
    }
}

void merge(vector<int> &nums, int p, int q, int r){
    vector<int> tmp(r + 1);
    int i = p, j = q + 1, t = 0;
    while(i <= q && j <= r){
        if(nums[i] <= nums[j])
            tmp[t++] = nums[i++];
        else
            tmp[t++] = nums[j++];
    }
    while(i <= q)
        tmp[t++] = nums[i++];
    while(j <= r)
        tmp[t++] = nums[j++];
    i = p, t = 1;
    while(i <= r){
        nums[i++] = tmp[t++];
        if(++cnt == K)
            cout << tmp[t];
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K;
    vector<int> nums(N);
    for(int i = 0; i < N; ++i)
        cin >> nums[i];

    merge_sort(nums, 0, N-1);
    if(cnt < K)
        cout << -1;

    return 0;
}
