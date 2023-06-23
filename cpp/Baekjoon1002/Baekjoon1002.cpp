#include <iostream>

using namespace std;

struct Turret
{
    int x, y, r;
};

int getEnemyPosition(Turret&t1, Turret&t2)
{
    int d = (t2.x - t1.x) * (t2.x - t1.x) + (t2.y - t1.y) * (t2.y - t1.y);
    int sum = (t1.r + t2.r) * (t1.r + t2.r);
    int sub = (t1.r - t2.r) * (t1.r - t2.r);

    if(d == 0 && t1.r != 0 && t2.r != 0 && t1.r == t2.r)
        return -1;
    else if(sub < d && d < sum)
        return 2;
    else if(d == sum || d == sub)
        return 1;
    else
        return 0;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while(T--)
    {
        Turret t1, t2;

        cin >> t1.x >> t1.y >> t1.r;
        cin >> t2.x >> t2.y >> t2.r;

        cout << getEnemyPosition(t1, t2) << "\n";
    }
    return 0;
}
