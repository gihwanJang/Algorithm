#include <stdio.h>
#include <ctime>

using namespace std;

int main(int argc, char const *argv[]){
    time_t timer;
    tm *t;

    timer = time(NULL);
    t = localtime(&timer);

    printf("%d-", t->tm_year+1900);
    printf("%02d-", t->tm_mon+1);
    printf("%02d\n", t->tm_mday);
    return 0;
}
