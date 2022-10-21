#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

struct Point{
    double x, y;
};

bool checkOnLine(const Point&p1, const Point&p2, const Point&p3){
    if(p1.x == p2.x && p2.x == p3.x) return true;
    if(p1.y == p2.y && p2.y == p3.y) return true;
    if((p1.y - p3.y) / (p1.x - p3.x) == (p2.y - p3.y) / (p2.x - p3.x))
        return true;
    return false;
}

double solution(const vector<Point>&points, int p1, int p2){
    double l1, l2;
    int p3 = 3 - p1 - p2;

    if(checkOnLine(points[p1], points[p2], points[p3]))
        return 0;

    l1 = sqrt(pow(points[p1].x - points[p3].x, 2) + pow(points[p1].y - points[p3].y, 2));
    l2 = sqrt(pow(points[p2].x - points[p3].x, 2) + pow(points[p2].y - points[p3].y, 2));

    return (l1 + l2) * 2;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    double sMin = 100000000, sMax = 0;
    vector<Point> points(3);
    for(int i = 0; i < 3; ++i)
        cin >> points[i].x >> points[i].y;

    for(int i = 0; i < 3; ++i)
        for(int j = i + 1; j < 3; ++j){
            double s = solution(points, i, j);
            if(s){
                sMin = min(sMin, s);
                sMax = max(sMax, s);
            }
        }
        
    cout.precision(10);
    cout << (sMax - sMin < 0 ? -1 : sMax - sMin) << "\n";
    return 0;
}