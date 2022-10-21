#include <iostream>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int E, S, M, year = 1;
    cin >> E >> S >> M;

    for(;;++year)
        if(!((year - E) % 15) && !((year - S) % 28) && !((year - M) % 19)){
            cout << year << "\n";
            break;
        }
}
