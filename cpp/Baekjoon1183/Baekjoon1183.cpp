#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int getOptimalNumberOfValues(vector<int>&times, int n)
{
    if(n % 2 == 1) return 1;

    sort(times.begin(), times.end());
    return times[n / 2] - times[n / 2 - 1] + 1;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, a, b;
    cin >> n;

    vector<int> times(n);
    for(int i = 0; i < n; ++i)
    {
        cin >> a >> b;
        times[i] = a - b;
    }

    cout << getOptimalNumberOfValues(times, n) << "\n";    
    return 0;
}

