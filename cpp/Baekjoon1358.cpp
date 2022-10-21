#include<iostream>
#include<utility>
using namespace std;

int w, h, x, y, p;

bool check(int px, int py){
    if(px < (x-h/2) || px > (x+w+h/2)) return false;
    if(py < y || py > (y+h)) return false;
    
    if(px<x){
        if(((px-x)*(px-x))+((py-h/2-y)*(py-h/2-y))<=(h*h/4))
            return true;
        return false;
    }
    if(px>x+w){
        if(((px-w-x)*(px-w-x))+((py-h/2-y)*(py-h/2-y))<=(h*h/4))
            return true;
        return false;
    }
    return true;
}

int main(int argc, char const *argv[]){
    int count=0;
    scanf("%d %d %d %d %d", &w, &h, &x, &y, &p);
    pair<int, int> points[p];
    for(int i = 0; i < p; ++i)
        scanf("%d %d", &points[i].first, &points[i].second);

    for(int i = 0; i < p; ++i)
        if(check(points[i].first, points[i].second))
            ++count;
    
    printf("%d\n", count);
    return 0;
}
