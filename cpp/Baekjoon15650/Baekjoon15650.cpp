#include<iostream>
#include<vector>
using namespace std;

int n, depth;
vector<int> v;

void rec(int index){
    if(v.size() == depth){
        for(vector<int>::iterator it = v.begin(); it != v.end(); ++it)
            printf("%d ", *it);
        printf("\n");
        return;
    }

    if(index <= n){
        v.push_back(index);
        rec(index+1);
        v.pop_back();
        rec(index+1);
    }
}

int main(int argc, char const *argv[]){
    scanf("%d %d", &n, &depth);
    
    rec(1);
    return 0;
}
