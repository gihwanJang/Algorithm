#include <iostream>

using namespace std;

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int count = 0;
        int n, m;
        cin >> n >> m;

        for (int a = 1; a < n; ++a) {
            for (int b = a + 1; b < n; ++b) {
                if (!((a * a + b * b + m) % (a * b))) {
                    ++count;
                }
            }
        }
        cout << count << "\n";
    }
}
