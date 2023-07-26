#include <iostream>

using namespace std;

int getOdds(long x, long y, long z)
{
    if(z >= 99) return -1;

    int left = 0;
    int right = 1000000000;
    int mid;

    while(left <= right)
    {
        mid = (left + right) / 2;

        if(z < (100 * (y + mid) / (x + mid)))
            right = mid - 1;
        else
            left = mid + 1;
    }

    return left;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long x, y, z;
    cin >> x >> y;
    z = 100 * y / x;

    cout << getOdds(x, y, z) << "\n";
    return 0;
}
