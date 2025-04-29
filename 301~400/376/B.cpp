#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

// 時計回りの距離を計算する関数
int get_clockwise_distance(int start, int end, int N) {
    if (start <= end) {
        return end - start;
    } else {
        return N - (start - end);
    }
}

// 反時計回りの距離を計算する関数
int get_counterclockwise_distance(int start, int end, int N) {
    if (start >= end) {
        return start - end;
    } else {
        return N - (end - start);
    }
}

// 時計回りの経路上に相手の手が存在するかチェックする関数
bool is_hand_on_path_clockwise(int start, int end, int hand_pos, int N) {
    if (start <= end) {
        return start < hand_pos && hand_pos <= end;
    } else {
        return start < hand_pos || hand_pos <= end;
    }
}

int main() {
    int N, Q;
    cin >> N >> Q;

    // 左手と右手の初期位置
    int L_pos = 1, R_pos = 2;
    int total_moves = 0;

    for (int i = 0; i < Q; ++i) {
        char hand;
        int target;
        cin >> hand >> target;

        if (hand == 'L') {
            // 時計回りと反時計回りの距離を計算
            int clockwise_distance = get_clockwise_distance(L_pos, target, N);
            int counterclockwise_distance = get_counterclockwise_distance(L_pos, target, N);

            // 右手の位置が時計回りまたは反時計回りの経路上にいるか確認
            bool clockwise_blocked = is_hand_on_path_clockwise(L_pos, target, R_pos, N);
            bool counterclockwise_blocked = is_hand_on_path_clockwise(target, L_pos, R_pos, N);

            if (clockwise_blocked && !counterclockwise_blocked) {
                // 時計回りがブロックされている場合は反時計回り
                total_moves += counterclockwise_distance;
            } else if (!clockwise_blocked && counterclockwise_blocked) {
                // 反時計回りがブロックされている場合は時計回り
                total_moves += clockwise_distance;
            } else {
                // どちらもブロックされていない場合は最短距離を選ぶ
                total_moves += min(clockwise_distance, counterclockwise_distance);
            }

            L_pos = target;  // 左手の位置を更新
        } else if (hand == 'R') {
            // 時計回りと反時計回りの距離を計算
            int clockwise_distance = get_clockwise_distance(R_pos, target, N);
            int counterclockwise_distance = get_counterclockwise_distance(R_pos, target, N);

            // 左手の位置が時計回りまたは反時計回りの経路上にいるか確認
            bool clockwise_blocked = is_hand_on_path_clockwise(R_pos, target, L_pos, N);
            bool counterclockwise_blocked = is_hand_on_path_clockwise(target, R_pos, L_pos, N);

            if (clockwise_blocked && !counterclockwise_blocked) {
                // 時計回りがブロックされている場合は反時計回り
                total_moves += counterclockwise_distance;
            } else if (!clockwise_blocked && counterclockwise_blocked) {
                // 反時計回りがブロックされている場合は時計回り
                total_moves += clockwise_distance;
            } else {
                // どちらもブロックされていない場合は最短距離を選ぶ
                total_moves += min(clockwise_distance, counterclockwise_distance);
            }

            R_pos = target;  // 右手の位置を更新
        }
    }

    cout << total_moves << endl;

    return 0;
}
