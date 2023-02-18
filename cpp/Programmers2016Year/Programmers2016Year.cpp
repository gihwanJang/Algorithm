#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    string week[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int day[12] = {5, 1, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    return week[(day[a - 1] + (b - 1) % 7) % 7];
}

int main(int argc, char const *argv[]){
    cout << solution(1, 2) << "\n";
    return 0;
}
