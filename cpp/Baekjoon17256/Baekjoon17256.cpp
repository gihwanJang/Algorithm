#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int ax, ay, az, in;

    cin >> ax >> ay >> az >> in;
    cout << in - az << " ";

    cin >> in;
    cout << in / ay << " ";

    cin >> in;
    cout << in - ax << "\n";
    return 0;
}
