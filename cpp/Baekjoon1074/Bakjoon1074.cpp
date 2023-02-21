#include <iostream>

using namespace std;

void zSearch(int n, int r, int c, int&count, int limit_r, int limit_c){
    if(limit_r == r && limit_c == c){
        cout << count << "\n";
        return;
    }

    if (limit_r < r + n && limit_r >= r && limit_c < c + n && limit_c >= c){
        zSearch(n/2, r, c, count, limit_r, limit_c);
        zSearch(n/2, r, c + n/2, count, limit_r, limit_c);
        zSearch(n/2, r + n/2, c, count, limit_r, limit_c);
        zSearch(n/2, r + n/2, c + n/2, count, limit_r, limit_c);
    }
    else{
        count += n * n;
    }
    
    return;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, c, r, count = 0;
    cin >> n >> r >> c;

    zSearch(1<<n, 0, 0, count, r, c);        
    return 0;
}
