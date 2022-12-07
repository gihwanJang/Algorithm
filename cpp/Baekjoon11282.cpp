#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    N += 3071;

    string s;
    s.push_back(N / 4096 + 234);
    s.push_back(N / 64 % 64 + 128);
    s.push_back(N % 64 + 128);

    cout << s << "\n";
    return 0;
}
