#include <iostream>

using namespace std;

double calculate(string grade){
    double score = 69 - double(grade[0]);
    if(grade[1] == '+') score += 0.3;
    else if(grade[1] == '-') score -= 0.3;
    return score;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string grade;
    cin >> grade;
    cout << fixed;
    cout.precision(1);
    cout << (grade[0] == 'F' ? 0.0 : calculate(grade)) << "\n";
    return 0;
}
