#include <iostream>
#include <vector>

 using namespace std;

 int main(int argc, char const *argv[])
 {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e, v;
    cin >> n >> m;

    vector<int> basket(n);
    while(m--)
    {
        cin >> s >> e >> v;
        for(int i = s-1; i < e; ++i)
            basket[i] = v;
    }

    for(int i = 0; i < n; ++i)
        cout << basket[i] << " ";
    cout << "\n";
    return 0;
}
 