#include <iostream>
#include <string>
#include <vector>
#include<unordered_map>
#include<sstream>
using namespace std;

vector<string> split(string str, char Delimiter) {
    istringstream iss(str);
    string buffer;
    vector<string> result;
 
    while (getline(iss, buffer, Delimiter))
        result.push_back(buffer);
 
    return result;
}

vector<string> solution(vector<string> record) {
    vector<string> answer;



    return answer;
}

int main(int argc, char const *argv[]){
    string s;
    vector<string> record;
    vector<string> ans;
    int n;

    cin >> n;
    for(; n > 0; --n){
        cin >> s;
        record.push_back(s);
    }

    ans = solution(record);
    for(vector<string>::iterator it = ans.begin(); it != ans.end(); ++it)
        cout << *it << "\n";
    return 0;
}
