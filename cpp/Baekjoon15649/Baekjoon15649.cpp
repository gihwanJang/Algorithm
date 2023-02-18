#include<iostream>
#include<vector>
#include<unordered_set>
using namespace std;

int n, m;
vector<int> ans;
unordered_set<int> set(10000);

void rec(){
    if(ans.size() == m){
        for(vector<int>::iterator it = ans.begin(); it != ans.end(); ++it)
            printf("%d ", *it);
        printf("\n");
        return;
    }

    for(int i = 1; i <= n; ++i){
        if(!set.count(i)){
            ans.push_back(i);
            set.insert(i);
            rec();
            ans.pop_back();
            set.erase(i);
        }
    }
}

int main(int argc, char const *argv[]){
    scanf("%d %d", &n, &m);
    rec();
    return 0;
}
