#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N, C;
    cin >> N >> C;
    
    vector<int> T(N);
    for (int i = 0; i < N; ++i) {
        cin >> T[i];
    }
    
    int candies = 1;  // 最初の飴は必ずもらえる
    int lastCandyTime = T[0];  // 最後に飴をもらった時刻を記録
    
    for (int i = 1; i < N; ++i) {
        // 前回飴をもらった時刻との差がC以上であれば飴をもらえる
        if (T[i] - lastCandyTime >= C) {
            candies++;
            lastCandyTime = T[i];  // 飴をもらった時刻を更新
        }
    }
    
    cout << candies << endl;
    return 0;
}
