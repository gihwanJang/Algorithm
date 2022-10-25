#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long long N, num, answer = 0;
    cin >> N;
    
    for(int i = 0; i < N * N; ++i){
        cin >> num;
        answer += num;
    }
    
    cout << answer << "\n";
    return 0;
}
