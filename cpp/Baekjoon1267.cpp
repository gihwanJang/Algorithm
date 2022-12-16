#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, time, m = 0, y = 0;
    cin >> N;

    while(N--){
        cin >> time;
        y += (1 + time / 30) * 10;
        m += (1 + time / 60) * 15;
    }

    if(m < y)
        cout << "M " << m << "\n";
    else if(m > y)
        cout << "Y " << y << "\n";
    else
        cout << "Y M " << m << "\n";
    return 0;
}
