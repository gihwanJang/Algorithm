#include <iostream>

using namespace std;

struct Time{
    int h, m, s;
};


int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Time t;
    cin >> t.h >> t.m >> t.s;

    int d;
    cin >> d;

    for(; d > 0; --d){
        ++t.s;
        if(t.s > 59){
            t.s = 0;
            ++t.m;
            if(t.m > 59){
                t.m = 0;
                ++t.h;
                if(t.h > 23){
                    t.h = 0;
                }
            }
        }
    }

    cout << t.h << " " << t.m << " " << t.s << "\n";
    return 0;
}
