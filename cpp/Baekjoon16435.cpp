#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, L;
    cin >> N >> L;

    vector<int> feeds(N);
    for(int i = 0; i < N; ++i)
        cin >> feeds[i];
    
    sort(feeds.begin(), feeds.end());

    for(int i = 0; i < N; ++i)
        if(feeds[i] <= L)
            ++L;

    cout << L << "\n";
    return 0;
}
