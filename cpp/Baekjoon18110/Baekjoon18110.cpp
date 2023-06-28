#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int getDifficulty(vector<int>&difficulty, int n)
{
    if(n == 0)
        return 0;

    int banded = round(double(n * 0.15));
    float ans = 0.0f;

    sort(difficulty.begin(), difficulty.end());
    for(int i = banded; i < n - banded; ++i)
        ans += difficulty[i];

    return round(ans / (n - banded * 2));
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> difficulty(n);
    for(int i = 0; i < n; ++i)
        cin >> difficulty[i];

    cout << getDifficulty(difficulty, n) << "\n";
    return 0;
}
