#include <iostream>
#include <string>
using namespace std;

int main() {
    int N, D;
    string S;

    // 入力の読み込み
    cin >> N >> D >> S;

    // '@'の数を数える
    int count_at = 0;
    for (char c : S) {
        if (c == '@') {
            count_at++;
        }
    }

    // Dを引いた結果を計算
    int result = count_at - D;
    int res = N - result;

    // 結果を出力
    cout << res << endl;

    return 0;
}
