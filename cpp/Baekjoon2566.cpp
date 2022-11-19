#include <iostream>

using namespace std;

struct MaxValue{
    int maxv = 0;
    int r = 1;
    int c = 1;
};


int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num;
    MaxValue answer;

    for(int i = 1; i < 10; ++i)
        for(int j = 1; j < 10; ++j){
            cin >> num;
            if(answer.maxv < num){
                answer.maxv = num;
                answer.r = i;
                answer.c = j;
            }
        }

    cout << answer.maxv << "\n";
    cout << answer.r << " " << answer.c << "\n";
    return 0;
}
