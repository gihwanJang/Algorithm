# (1366) 기타 코드

## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1366)

## 문제
음악에서 음표는 다음과 같이 12개의 이름이 있다. 오름차순으로 A, A#, B, C, C#, D, D#, E, F, F#, G, G# 이다.

이 음은 이것보다 더 높아질 때, 낮아질 때, 모두 이 순서대로 다시 반복되기 때문에, G#보다 한음 높은 음은 A이고, B보다 다섯 음 낮은 음은 F#이다. 따라서, 어떤 음에서 12음 떨어진 음은 항상 자기 자신이 된다. 이 문제에서 같은 이름을 가지고 있으면, 옥타브와 상관없이 같은 음으로 생각한다.

기타는 여러 개의 줄을 가지고 있는 악기이고, 각 줄은 12개의 음 중 하나로 튜닝되어 있다. 각 줄에서 나는 소리를 열린 음이라고 한다. 줄의 아래에는 프렛이 있는데, 프렛은 1번 프렛부터 차례때로 번호가 있다. 프렛을 누르게 되면 줄의 음이 변하게 된다. 어떤 줄의 i번을 누르게 되면, 그 줄의 열린 음보다 i만큼 높은 음이 울린다.

예를 들어, 어떤 줄의 열린 음이 C#일 때, 3번 프렛을 누르고 그 줄을 친다면 E가 소리난다.

코드는 동시에 치는 음의 집합이다. 기타에서 코드를 치기 위해서, 각 줄은 코드에 있는 음 중 하나의 음을 반드시 소리 내야 한다. 그리고 코드에 있는 음 모든 음이 소리 나야 한다.

각 코드를 치는 방법은 여러 가지가 있다. 민식이는 코드를 치는 난이도를 손을 얼마나 뻗느냐로 매기려고 한다. 프렛을 누른 줄 중 가장 높은 프렛의 번호에서 가장 낮은 프렛의 번호를 뺀 후에 1을 더하면 그것이 그 코드의 난이도이다. 이때, 반드시 프렛을 누른 줄만 계산에 포함시켜야 한다. 따라서, 프렛을 누르지 않은 열린 줄의 경우에는 코드의 난이도에 영향을 미치지 않는다. 만약 어떤 코드가 프렛을 누르지 않고 칠 수 있다면, 그 코드의 난이도는 0이 된다.

기타의 줄의 개수 N, 각 줄이 무슨 음으로 튜닝되어 있는지가 주어진다. 그 때, 코드를 구성하는 음이 주어질 때, 그 코드의 가능한 난이도 중 최솟값을 구하는 프로그램을 작성하시오.

## 입력
첫째 줄에 N과 M이 주어진다. N은 기타의 줄의 개수이고, M은 코드를 구성하는 음의 개수이다. 둘째 줄에는 각 줄이 무슨 음으로 튜닝되어 있는지를 나타내는 N개의 음이 주어지고, 셋째 줄에는 각 코드를 구성하는 M개의 음이 주어진다. 코드를 구성하는 음은 중복되지 않으며, 음은 모두 문제의 초반에 나온 12개의 음만 주어진다.

## 출력
첫째 줄에 가능한 난이도 중 최솟값을 출력한다.

## 풀이
우선 문제를 풀기위해 각 코드를 숫제로 매치 시키는 작업을 해줍니다.

```cpp
unordered_map<string,int> makeMap(){
    unordered_map<string,int> map;
    map.insert({"A",1});
    map.insert({"A#",2});
    map.insert({"B",3});
    map.insert({"C",4});
    map.insert({"C#",5});
    map.insert({"D",6});
    map.insert({"D#",7});
    map.insert({"E",8});
    map.insert({"F",9});
    map.insert({"F#",10});
    map.insert({"G",11});
    map.insert({"G#",12});
    return map;
}
```

위의 함수를 이용해 map을 만들고 각 코드들을 입력 받습니다.  
(map을 만들지 않고 string을 입력 받아 int를 출력하는 함수를 만드셔도 됩니다.)  

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    int n, m;
    cin >> n >> m;

    unordered_map<string,int> map = makeMap();
    vector<int> scales(n);
    vector<int> code(m);
    for(int i = 0; i < n; ++i){
        cin >> s;
        scales[i] = map.at(s);
    }
    for(int i = 0; i < m; ++i){
        cin >> s;
        code[i] = map.at(s);
    }

    vector<pair<int,int>> difficulty(n);
    play(scales, code, difficulty, 0);

    cout << ans << "\n";
    return 0;
}
```

여기서 scales는 음계이고 code는 코드를 입력 받습니다.  

difficulty는 음계가 연주한 음과 해당 음에 대한 난이도를 담고 있습니다.  
이제 음계를 코드에 있는 모든 음을 쳐보고 난이도를 확인해 봅니다.  

```cpp
void play(vector<int>&scales, vector<int>&code, vector<pair<int,int>>&difficulty, int depth){
    if(depth == scales.size()){
        int l = 987654321, r = 0;
        for(int i = 0; i < scales.size(); ++i){
            set.insert(difficulty[i].first);

            if(difficulty[i].second != 0){
                r = max(r, difficulty[i].second);
                l = min(l, difficulty[i].second);
            }
        }

        if(set.size() == code.size()){
            if(l == 987654321)
                ans = 0;
            else if(r - l + 1 < ans)
                ans = r - l + 1;
        }

        set.clear();
        return;
    }
    
    for(int i = 0; i < code.size(); ++i){
        difficulty[depth].first = code[i];
        difficulty[depth].second = code[i] - scales[depth] + (code[i] >= scales[depth] ? 0 : 12);
        play(scales, code, difficulty, depth + 1);
        difficulty[depth].second += 12;
        play(scales, code, difficulty, depth + 1);
    }    
}
```

위는 전수조사를 하는 함수로 첫 번째 if문은 종료 조건과 값 확인 입니다.  
저장된 difficulty의 음계를 확인합니다.  
이때 확인은 set을 이용하여 음을 담고 코드의 갯수와 set의 갯수가 같으면 모든 음을 친 것 입니다.  
또한 한번 선형적으로 음계를 확인 할때 0이 아닌 가장 높은 난이도와 가장 낮은 난이도를 확인합니다.  
코드를 모두 쳤으면 가장 높은 난도와 낮은 난이도를 계산해 가장 낮은 전체 난이도를 찾습니다.  
아니면는 그냥 함수를 끝냅니다.  

if문 뒤의 for문은 실질적인 전수조사로 difficulty의 첫번째는 코드와 두번째는 난이도를 넣고 전수 조사를 실행 합니다.  