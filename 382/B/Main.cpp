#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
    int N, D;
    string S;

    // 入力の読み込み
    cin >> N >> D >> S;

    // クッキーが入っている箱のインデックスを格納
    vector<int> cookies;
    for (int i = 0; i < N; i++) {
        if (S[i] == '@') {
            cookies.push_back(i);
        }
    }

    // D日間経過後の状態を反映する
    for (int day = 0; day < D; day++) {
        if (cookies.empty()) break; // 全てのクッキーが食べられた場合
        int index = cookies.back(); // 最も右にあるクッキーを食べる
        S[index] = '.';             // クッキーを食べる
        cookies.pop_back();         // 食べたクッキーを削除
    }

    // 結果を出力
    cout << S << endl;

    return 0;
}
