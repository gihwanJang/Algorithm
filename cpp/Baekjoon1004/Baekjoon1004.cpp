#include<iostream>
#include<utility>
using namespace std;

struct Circle{
    int x, y, r;
    bool checkIn(pair<int,int> p1, pair<int,int> p2){
        int count = 0;
        if((p1.first-x)*(p1.first-x) + (p1.second-y)*(p1.second-y) <= r*r)
            ++count;
        if((p2.first-x)*(p2.first-x) + (p2.second-y)*(p2.second-y) <= r*r)
            ++count;
        
        return (count==1);
    }
};

int main(int argc, char const *argv[]){
    int T;
    pair<int,int> start, end;
    scanf("%d", &T);

    for(int x, y, r, n; T > 0; --T){
        int count=0;
        scanf("%d %d %d %d %d", &start.first, &start.second, &end.first, &end.second, &n);
        Circle c[n];
        for(int i = 0; i < n; ++i)
            scanf("%d %d %d", &c[i].x, &c[i].y, &c[i].r);

        for(int i = 0; i < n; ++i)
            if(c[i].checkIn(start, end))
                ++count;

        printf("%d\n", count);
    }
    return 0;
}
