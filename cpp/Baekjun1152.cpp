#include<iostream>
#include<vector>
#include<sstream>
using namespace std;

vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;
 
    while (getline(ss, temp, delimiter))
        if(temp!="")
            answer.push_back(temp);
 
    return answer;
}

int main(int argc, char const *argv[]){
    string s;
    getline(cin,s);

    vector<string> result = split(s, ' ');
    cout<<result.size();

    return 0;
}

/*
int main(int argc, char const *argv[]){
    string s="null";
    int count=0;
    while(s!=""){
        ++count;
        cin>>s;
    }
    cout<<count<<endl;
    return 0;
}
*/