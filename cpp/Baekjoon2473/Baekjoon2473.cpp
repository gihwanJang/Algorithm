#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

vector<long> getMostNeutral(vector<long>&solutions, int n)
{
    int l, r;
    long val;
    long neutral_val = 3000000001;
    vector<long> neutral(3);

    sort(solutions.begin(), solutions.end());

    for(int i = 0; i < n-2; ++i)
    {
        l = i + 1;
        r = n-1;

        while(l < r)
        {
            val = solutions[i] + solutions[l] + solutions[r];

            if(abs(val) < neutral_val)
            {
                neutral_val = abs(val);
                neutral[0] = solutions[i];
                neutral[1] = solutions[l];
                neutral[2] = solutions[r];
            }

            if(val < 0) l++;
            else r--;
        }
    }

    return neutral;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<long> solutions(n);
    for(int i = 0; i < n; ++i)
        cin >> solutions[i];

    for(long v : getMostNeutral(solutions, n))
        cout << v << " ";
    return 0;
}
