#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int>&basket, int a, int b)
{
    if(a == b) return;

    int tmp = basket[a];
    basket[a] = basket[b];
    basket[b] = tmp;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, a, b;
    cin >> n >> m;

    vector<int> basket(n+1);
    for(int i = 1; i <= n; ++i)
        basket[i] = i;

    for(int i = 0; i < m; ++i)
    {
        cin >> a >> b;
        swap(basket, a, b);
    }

    for(int i = 1; i <= n; ++i)
        cout << basket[i] << " ";
    return 0;
}
