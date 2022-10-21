#include<iostream>
#include<vector>
#include<cmath>
using namespace std;

int MIN = 10000;
vector<int> players1;
vector<int> players2;

void calculate(int n, int**s){
    int team1 = 0, team2 = 0;
    for(int i = 0; i < n/2; ++i)
        for(int j = 0; j < n/2; ++j)
            if(i != j){
                team1 += s[players1[i]][players1[j]];
                team2 += s[players2[i]][players2[j]];
            }
    if(abs(team1-team2) < MIN)
        MIN = abs(team1-team2);
}

void solution(int n, int**s, bool table[], int index){
    if(players1.size() == n/2){
        for(int i = 0; i <n; ++i)
            if(!table[i])
                players2.push_back(i);
        calculate(n, s);
        players2.clear();
    }

    for(int i = index; i < n; ++i){
        players1.push_back(i);
        table[i] = true;
        solution(n, s, table, i+1);
        players1.pop_back();
        table[i] = false;
    }
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);
    int **s;
    bool table[n];
    fill(table,table+n,false);
    s = new int*[n];
    for(int r = 0; r < n; ++r){
        s[r] = new int[n];
        for(int c = 0; c < n; ++c)
            scanf("%d", &s[r][c]);
    }

    solution(n, s, table, 0);

    printf("%d\n", MIN);
    return 0;
}
