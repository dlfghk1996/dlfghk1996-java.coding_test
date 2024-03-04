package ilhwa.codingtest.programmers.kakao.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

public class Lotto_hight_low_rank {

    // win_nums : 31, 10, 45, 1, 6, 19
    // lottos : 44, 1, 0, 0, 31 25
    public int[] solution1(int[] lottos, int[] win_nums) {
        // contain
        Map<Integer, Boolean> map = new HashMap<>();
        int zeroCount = 0;

        // 알아볼수 없는 번호 개수
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            // 유효한 번호를 map에 담는다.
            map.put(lotto, true);
        }

        int sameCount = 0;

        // 당첨번호와 일치하는 개수 구하기
        for (int winNum : win_nums) {
            if (map.containsKey(winNum))
                sameCount++;
        }

        // 알아볼 수 없는 번호가 당첨번호와 같을 경우 등수구하기
        int maxRank = 7 - (sameCount + zeroCount);

        // 당첨번호와 일치하는 개수로 등수 구하기
        int minRank = 7 - sameCount;

        // Math.min() 함수는 주어진 숫자들 중 가장 작은 값을 반환
        int[] answer = {Math.min(maxRank, 6), Math.min(minRank, 6)};

        return answer;
    }



    // 이진탐색이용
    public int[] solution2(int[] lottos, int[] win_nums) {

        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int answer = 0;
        int hidden = 0;

        Arrays.sort(win_nums);
        for (int i = 0; i < lottos.length; i++)
            if (Arrays.binarySearch(win_nums, lottos[i]) > -1)
                answer++;
            else if (lottos[i] == 0)
                hidden++;

        return new int[] {rank[answer + hidden], rank[answer]};
    }


    public int[] solution3(int[] lottos, int[] win_nums) {
        int zero = 0;
        int matched = 0;
        for (int l : lottos) {
            if (l == 0) {
                zero++;
            } else {
                for (int w : win_nums) {
                    if (l == w) {
                        matched++;
                        break;
                    }
                }
            }
        }
        int min = matched;
        int max = matched + zero;
        int[] answer = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
        return answer;
    }
}

