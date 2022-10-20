#include <iostream>
#include <ctime>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);

    time_t timer = time(NULL);
    struct tm* t = localtime(&timer);

    cout << t->tm_year + 1900 << "\n";
    cout << t->tm_mon + 1 << "\n";
    cout << t->tm_mday << "\n";
    return 0;
}
