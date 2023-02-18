#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string my, doctor;
    cin >> my >> doctor;

    cout << (my.length() >= doctor.length() ? "go" : "no") << "\n";
    return 0;
}
