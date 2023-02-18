#include <iostream>

using namespace std;

string getLine(int n, int i){
    string s = "";
    for(int j = 0; j < i; ++j)
        s += ' ';
    for(int j = 1; j < 2*(n-i); ++j)
        s += '*';
    return s;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    for(int i = 0; i < N; ++i)
        cout << getLine(N, i) << "\n";
    for(int i = N - 2; i >=0; --i)
        cout << getLine(N, i) << "\n";

    return 0;
}
