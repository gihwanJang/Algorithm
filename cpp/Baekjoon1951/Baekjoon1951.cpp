#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long long n, ans = 0;
    cin >> n;
    
    if(n < 10){
        ans = n;
    }else if(n < 100){
        ans += 9;
        ans += (n - 9) * 2;
    }else if(n < 1000){
        ans += 189;
        ans += (n - 99) * 3;
    }else if(n < 10000){
        ans += 2889;
        ans = (ans%1234567 + ((n-999)*4)%1234567) % 1234567;
    }else if(n < 100000){
        ans += 38889;
        ans = (ans%1234567 + ((n-9999)*5)%1234567) % 1234567;
    }else if(n < 1000000){
        ans += 488889;
        ans = (ans%1234567 + ((n-99999)*6)%1234567) % 1234567;
    }else if(n < 1000000){
        ans += 488889;
        ans = (ans%1234567 + ((n-999999)*7)%1234567) % 1234567;
    }else if(n < 10000000){
        ans += 5888889;
        ans = (ans%1234567 + ((n-9999999)*8)%1234567) % 1234567;
    }else if(n < 100000000){
        ans += 68888889;
        ans = (ans%1234567 + ((n-99999999)*9)%1234567) % 1234567;
    }else{
        ans += 788888889;
        ans = (ans%1234567 + ((n-999999999)*10)%1234567) % 1234567;
    }

    cout << ans << '\n';
    return 0;
}
