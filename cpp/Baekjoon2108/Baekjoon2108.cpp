#include<iostream>
#include<algorithm>
#include<math.h>
#include<vector>
using namespace std;

int main(int argc, char const *argv[]){
    int n, mid, min = 4000, max = -4000, nums[8001] = {0,};
    double sum = 0;
    vector<int> count;
    scanf("%d", &n);
    for(int i = 0, k; i < n; ++i){
        scanf("%d", &k);
        sum += k;
        if(k > max) max = k;
        if(k < min) min = k;
        ++nums[k+4000];
    }

    for(int i = 0, j = 0, mode = 0; i < 8001; ++i)
        if(nums[i] != 0){
            if(j < n/2+1){
                mid = i-4000;
                j+=nums[i];
            }
            if(nums[i] > mode){
                mode = nums[i];
                count.clear();
                count.push_back(i-4000);
            }
            else if(nums[i] == mode)
                count.push_back(i-4000);
        }

    printf("%d\n", int(round(sum/n)));
    printf("%d\n", mid);
    printf("%d\n", count.size() == 1 ? count[0] : count[1]);
    printf("%d\n", max-min);
    return 0;
}