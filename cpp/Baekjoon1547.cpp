#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, a, b, tmp;
    cin >> N;

    vector<bool> cups(4, false);
    cups[1] = true;

    while(N--){
        cin >> a >> b;
        tmp = cups[a];
        cups[a] = cups[b];
        cups[b] = tmp;
    }

    for(int i = 1; i < 4; ++i)
        if(cups[i])
            cout << i << "\n";
    return 0;
}
