#include<iostream>

struct Point{
    int x, y;
};

int solution(Point my, Point end){
    int d = my.x > my.y ? my.y : my.x;

    if(end.x - my.x < d)
        d = end.x - my.x;
    if(end.y - my.y < d)
        d = end.y - my.y;
    
    return d;
}

int main(int argc, char const *argv[]){
    Point myPoint, endPoint;
    scanf("%d %d %d %d", &myPoint.x, &myPoint.y, &endPoint.x, &endPoint.y);

    printf("%d\n", solution(myPoint, endPoint));
    return 0;
}
