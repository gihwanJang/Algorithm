#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string L, R;
    cin >> L >> R;
	
    if (L.length() != R.length()) {
		cout << 0 << "\n";
		return 0;
	}

	int ans = 0;
	
	for (int i = 0; i < L.length(); ++i) {
		if (L[i] == R[i] && L[i] == '8')
			++ans;
		else if (L[i] != R[i])
			break;
	}

	cout << ans << "\n";
    return 0;
}
