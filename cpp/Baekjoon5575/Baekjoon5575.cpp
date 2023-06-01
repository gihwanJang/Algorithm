#include <iostream>

using namespace std;

struct Time{
    int h, m, s;
};

void convertTime(Time&end, Time&start){
    if(end.s < start.s){
        --end.m;
        end.s += 60;
    }
    if(end.m < start.m){
        --end.h;
        end.m += 60;
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Time a_start, a_end, b_start, b_end, c_start, c_end;
    cin >> a_start.h >> a_start.m >> a_start.s;
    cin >> a_end.h >> a_end.m >> a_end.s;
    
    cin >> b_start.h >> b_start.m >> b_start.s;
    cin >> b_end.h >> b_end.m >> b_end.s;
    
    cin >> c_start.h >> c_start.m >> c_start.s;
    cin >> c_end.h >> c_end.m >> c_end.s;

    convertTime(a_end, a_start);
    convertTime(b_end, b_start);
    convertTime(c_end, c_start);

    cout << a_end.h - a_start.h << " ";
    cout << a_end.m - a_start.m << " ";
    cout << a_end.s - a_start.s << "\n";

    cout << b_end.h - b_start.h << " ";
    cout << b_end.m - b_start.m << " ";
    cout << b_end.s - b_start.s << "\n";

    cout << c_end.h - c_start.h << " ";
    cout << c_end.m - c_start.m << " ";
    cout << c_end.s - c_start.s << "\n";
    return 0;
}
