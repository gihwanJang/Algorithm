#include <iostream>
#include <queue>

using namespace std;

int getBuyerCount(priority_queue<int>&others, int want)
{
    if(others.empty()) return 0;

    int res = 0;
    
    while(want + res <= others.top())
    {
        int t = others.top();

        others.pop();
        others.push(t-1);

        ++res;
    }

    return res;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    int want, other;
    cin >> want;

    priority_queue<int> others;
    for(int i = 1; i < n; ++i)
    {
        cin >> other;
        others.push(other);
    }

    cout << getBuyerCount(others, want) << "\n";
    return 0;
}
