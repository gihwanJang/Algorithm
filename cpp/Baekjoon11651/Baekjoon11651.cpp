#include<iostream>
#include<algorithm>
using namespace std;

struct Point{
    int x;
    int y;
    Point(){}
    Point(int X, int Y): x(X), y(Y){}
};


bool compare(Point i, Point j){
    if(i.y < j.y)
        return true;
    else if(i.y > j.y)
        return false;
    else
        return i.x < j.x ? true : false;
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);

    Point points[n];
    for(int i = 0; i < n; ++i){
        int x,y;
        scanf("%d %d", &x, &y);
        points[i] = Point(x, y);
    }

    sort(points, points+n, compare);

    for(int i = 0; i < n; ++i)
        printf("%d %d\n", points[i].x, points[i].y);
    return 0;
}
