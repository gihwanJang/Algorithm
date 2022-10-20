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
    if(i.x < j.x)
        return true;
    else if(i.x > j.x)
        return false;
    else
        return i.y < j.y ? true : false;
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
