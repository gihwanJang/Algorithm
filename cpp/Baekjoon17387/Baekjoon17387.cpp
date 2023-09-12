#include <algorithm>
#include <iostream>
#include <cmath>

using namespace std;

struct Point{long x, y;};
struct Line{Point p1, p2;};

int CCW(Line&l, Point p)
{
    long direct = (l.p1.x * l.p2.y + l.p2.x * p.y + p.x * l.p1.y) - (l.p2.x * l.p1.y + p.x * l.p2.y + l.p1.x * p.y);

    if(direct > 0) return 1;
    else if(direct < 0) return -1;
    else return 0;
}

bool cmpPoint(Point a, Point b)
{
    if(a.x == b.x)
        return a.y <= b.y;
    return a.x <= b.x;
}

bool canCrossLine(Line&l1, Line&l2)
{
    int loc_state1 = CCW(l1, l2.p1) * CCW(l1, l2.p2);
    int loc_state2 = CCW(l2, l1.p1) * CCW(l2, l1.p2);

    if(loc_state1 <= 0 && loc_state2 <=0 )
    {
        if(loc_state1 == 0 && loc_state2 == 0)
        {
            if(cmpPoint(l1.p2, l1.p1)) swap(l1.p1, l1.p2);
            if(cmpPoint(l2.p2, l2.p1)) swap(l2.p1, l2.p2);
            
            return cmpPoint(l1.p1, l2.p2) && cmpPoint(l2.p1, l1.p2);
        }
        return true;
    }

    return false;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Line l1, l2;
    cin >> l1.p1.x >> l1.p1.y >> l1.p2.x >> l1.p2.y;
    cin >> l2.p1.x >> l2.p1.y >> l2.p2.x >> l2.p2.y;

    cout << canCrossLine(l1, l2) << "\n";
    return 0;
}
