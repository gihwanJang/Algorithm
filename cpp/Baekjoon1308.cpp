#include <iostream>

using namespace std;

struct Date{
    int year, month, day;
    int days[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
};

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Date start, end;
    cin >> start.year >> start.month >> start.day;
    cin >> end.year >> end.month >> end.day;

    return 0;
}
