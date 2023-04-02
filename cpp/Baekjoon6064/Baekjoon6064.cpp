#include <iostream>

using namespace std;

int gcd(int a, int b){
    if(!b) return a;
    return gcd(b, a % b);
}
int lcm(int a, int b){
    return (a * b) / gcd(a, b);
}

int calendar(int m, int n, int x, int y){
    int end = lcm(m, n), ny;
    
    for (int i = x; i <= end; i+=m){
        if(!(ny = i % n))
            ny = n;
            
        if(ny == y)
            return i;
    }

    return -1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, m, n, x, y;
    cin >> T;

    while(T--){
        cin >> m >> n >> x >> y;

        cout << calendar(m,n,x,y) << "\n";
    }
    return 0;
}