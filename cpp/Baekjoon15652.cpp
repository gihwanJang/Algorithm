#include<iostream>
#include<vector>
using namespace std;

int n, m;
vector<int> ans;

void rec(int k){
    if(ans.size() == m){
        for(vector<int>::iterator it = ans.begin(); it != ans.end(); ++it)
            printf("%d ", *it);
        printf("\n");
        return;
    }

    for(int i = k; i <= n; ++i){
        ans.push_back(i);
        rec(i);
        ans.pop_back();
    }
}

int main(int argc, char const *argv[]){
    scanf("%d %d", &n, &m);
    
    rec(1);
    return 0;
}