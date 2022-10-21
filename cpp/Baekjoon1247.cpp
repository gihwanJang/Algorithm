#include <iostream>

using namespace std;

string string_sum(string A, string B){
    string s="", num;
    

    return s;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T = 3;
    while(T--){
        int N;
        string S = "0";

        cin >> N;
        for(string n; N > 0; --N){
            cin >> n;
            S = string_sum(S, n);
        }

    }
    return 0;
}
