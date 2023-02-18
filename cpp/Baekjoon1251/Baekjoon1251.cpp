#include <iostream>
#include <algorithm>

using namespace std;

void makeNewString(string&s, string&ans, int first, int second){
    string newstr = "";

    for(int i = first; i >= 0; --i)
		newstr += s[i];
	for(int i = second; i > first; --i)
		newstr += s[i];
	for(int i = s.size() - 1; i > second; --i)
		newstr += s[i];

    if(ans > newstr) ans = newstr;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s, ans = "{";
    cin >> s;

    for(int fir = 0; fir < s.length()-2; ++fir)
        for(int sec = fir + 1; sec < s.length()-1; ++sec)
            makeNewString(s, ans, fir, sec);

    cout << ans << "\n";
    return 0;
}
