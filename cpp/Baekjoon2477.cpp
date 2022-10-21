#include<iostream>
#include<list>
#include<utility>
using namespace std;

list< pair<int,int> > shape;

bool cmp(int i, int j){
    int a,b;
    list< pair<int,int> >::iterator it = shape.begin();
    advance(it,i);
    a = it->first;
    advance(it,j-i);
    b = it->first;
    return a!=b;
}

int main(int argc, char const *argv[]){
    int k, f, s, tmp=1, w =1;
    scanf("%d", &k);

    for(int i = 0; i < 6; ++i){
        scanf("%d %d", &f, &s);
        shape.push_back(make_pair(f, s));
    }
    
    while(cmp(2,4) || cmp(3,5)){
        pair<int,int> back = make_pair(shape.back().first, shape.back().second);
        shape.pop_back();
        shape.push_front(back);
    }

    list< pair<int,int> >::iterator it = shape.begin();
    w *= it->second;
    advance(it, 1);
    w *= it->second;
    advance(it, 2);
    tmp *= it->second;
    advance(it, 1);
    tmp *= it->second;
    printf("%d\n", k*(w-tmp));
    return 0;
}
