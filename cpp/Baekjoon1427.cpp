#include<iostream>
#include<algorithm>
using namespace std;

bool compare(int i, int j){return i > j;}

int main(int argc, char const *argv[]){
    string s;
    cin>>s;
    int nums[s.size()];

    for(int i = 0; i < s.size(); ++i)
        nums[i] = s[i]-'0';
    
    sort(nums, nums+s.size(), compare);

    for(int i = 0; i < s.size(); ++i)
        printf("%d", nums[i]);
    printf("\n");
    return 0;
}
