#include <iostream>
#include <vector>

using namespace std;

string kindOfTriangle(vector<int>&triangle){
    int sum = 0;

    for(int i = 0; i < 3; ++i)
        sum += triangle[i];

    if(sum != 180)
        return "Error";

    if(triangle[0] == 60 && triangle[1] == 60)
        return "Equilateral";

    if(triangle[0] == triangle[1] || triangle[1] == triangle[2] || triangle[0] == triangle[2])
        return "Isosceles";

    return "Scalene";
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> triangle(3);
    for(int i = 0; i < 3; ++i)
        cin >> triangle[i];

    cout << kindOfTriangle(triangle) << "\n";
    return 0;
}
