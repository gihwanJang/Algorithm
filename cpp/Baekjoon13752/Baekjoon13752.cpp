#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, v;
    cin >> n;

    while(n--){
        cin >> v;

        while(v--)
            cout << "=";
            
        cout << "\n";
    }
    return 0;
}
