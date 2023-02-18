#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string bigNum_Divide(string a, long long b) {
    long long res=0;
    string c;
    
	for(long long i = 0; i < a.length(); i++) {
        res = (res*10)+(a[i]-'0');
        c += (res/b)+'0';
        res %= b;
    }
    
    return c;
}

long long bigNum_Mod(string a, long long b) {
    long long res=0;

	for(long long i = 0; i < a.length(); i++) {
        res = (res*10)+(a[i]-'0');
        res %= b;
    }
    
    return res;
}

// 큰 수에서 작은 수를 빼기 위한 swap
bool check(string& a, string& b) {
    // 길이가 길면 무조건 큼
    if(a.length() > b.length())
        return false;
    else if(a.length() < b.length()) {
        swap(a,b);
        return true;
    }
 
    // 길이가 같으면 한자리씩 비교
    for(int i=0; i<a.length(); i++) {
        if(a[i] > b[i])
            return false;
        else if(a[i] < b[i]) {
            swap(a,b);
            return true;
        }
    }
    return false;
}

// a에서 b를 빼기
string bigNum_Sub(string a, string b) {
    bool CR=false, flag=check(a, b);
    long long res=0, al=a.length(), bl=b.length();
    string c;
    
	for(long long i=0; i<al || i<bl; i++) {
        if(i < al) {
            res += a[al-i-1]-'0';
            if(CR) { res--; CR=false; } // 캐리 처리
        }
        if(i < bl)
            res -= b[bl-i-1]-'0';
        
        // 뺀 값이 음수일 시 보수, 캐리 체크
        if(res<0) {
            res = 10-abs(res);
            CR = true;
        }
        c += res+'0';
        res = 0;
    }
    
    // 최종 값이 0이 아닌 경우, 맨 앞이 0이면 제거
    if(c.back()=='0' && c.length()>1) c.pop_back();
    // check()에서 swap된 경우 음수
    if(flag) c += '-';
	// 문자열에 반대로 저장되므로 뒤집기
    reverse(c.begin(), c.end());
    
    return c;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string n;
    long long m;
    cin >> n >> m;

    cout << bigNum_Divide(n, m) << "\n";
    cout << bigNum_Mod(n,m) << "\n";
    return 0;
}
