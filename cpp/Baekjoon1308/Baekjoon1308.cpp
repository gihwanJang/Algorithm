#include <iostream>

using namespace std;

int days[12] = {31,28,31,30,31,30,31,31,30,31,30,31};

struct Time{
    int year, month, day;
};

bool isLeap(int year) {
	if(year % 400 == 0)
        return true;
    if(year % 100 == 0)
        return false;
    return year % 4 == 0; 
}

int day(int y, int m, int d) {
	int r = 0;
    
	for (int i = 0; i < y; ++i)
		r += 365 + isLeap(i);

	for (int i = 0; i + 1 < m; ++i) 
		r += i == 1 && isLeap(y) ? 29 : days[i];
	
	return r + d;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Time start, end;
    cin >> start.year >> start.month >> start.day;
    cin >> end.year >> end.month >> end.day;

    if (end.year - start.year > 1000 || (end.year - start.year >= 1000 && day(0, start.month, start.day) <= day(0, end.month, end.day))){
        cout << "gg" << "\n";
        return 0;
    }

    cout << "D-" << day(end.year, end.month, end.day) - day(start.year, start.month, start.day) << "\n";

    return 0;
}
