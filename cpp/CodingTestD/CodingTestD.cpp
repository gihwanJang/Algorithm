#include<iostream>
#include<vector>
#include<utility>
using namespace std;

vector< pair<int,int> > functions;

char solution(int x){
    int sum=1;
    
    for (vector< pair<int,int> >::iterator iter = functions.begin(); iter != functions.end(); ++iter)
        sum *= (*iter).first * x + (*iter).second;

    if(sum>0) return '+';
    else if(sum<0) return '-';
    else return '0';
}

int main(int argc, char const *argv[]){
    int Q;
    scanf("%d", &Q);
    for(; Q > 0; --Q){
        int f, a, b;
        scanf("%d", &f);
        if(f == 1){
            scanf("%d %d", &a, &b);
            functions.push_back(make_pair(a, b));
        }
        else{
            scanf("%d",&a);
            printf("%c\n",solution(a));
        }
    }
    return 0;
}
