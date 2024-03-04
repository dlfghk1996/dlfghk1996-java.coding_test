package ilhwa.codingtest.programmers.kakao.level1;


import java.util.HashMap;
import java.util.Map;

public class Kakao_gift_2024_1 {
    public int solution(String[] friends, String[] gifts) {
        // friends :  [고죠, 스구루, 스쿠나, 메구미]
        // gifts : [메구미 고죠] [스쿠나 고죠] [스크나 스구루]

        Map<String, Integer> giverGiftCount = new HashMap<>(); // 선물 준 개수 => {고죠:4}
        Map<String, Integer> receiverGiftCount = new HashMap<>(); // 선물 받은 개수 => {고죠:5}
        Map<String, Integer> friendsGiftCounts = new HashMap<>(); // 친구 > 친구 선물 준 개수 => {고죠 스구루 : 3}

        for (String gift : gifts) {
            String giver = gift.split(" ")[0];
            String taker = gift.split(" ")[1];

            //getOrDefault : 찾는 key 가 존재한다면 찾는 key의 value를 반환하고 없거나 null 이라면 default 값을 반환
            giverGiftCount.put(giver, giverGiftCount.getOrDefault(giver, 0) + 1);
            receiverGiftCount.put(taker, receiverGiftCount.getOrDefault(taker, 0) + 1);
            friendsGiftCounts.put(gift, friendsGiftCounts.getOrDefault(gift, 0) + 1);
        }

        // 선물을 가장 많이 받을 친구 선물의 수
        int max = 0;

        for (int i = 0; i < friends.length; i++) {
            // 가장 큰 값을 찾기위해 tmp 변수 사용
            int tmp = 0;
            String friendI = friends[i];

            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                String friendJ = friends[j];

                Integer iToj = friendsGiftCounts.getOrDefault(friendI + " " + friendJ, 0); // i가 j에게 준 선물의 개수
                Integer jToi = friendsGiftCounts.getOrDefault(friendJ + " " + friendI, 0); // j가 i에게 준 선물의 개수

                // 주고 받은 선물의 개수 비교
                if (iToj > jToi) tmp++;
                if (iToj != jToi) continue;

                // i와 j의 선물지수 구하기 (준선물 - 받은선물)
                Integer iGiftCount = giverGiftCount.getOrDefault(friendI, 0) - receiverGiftCount.getOrDefault(friendI, 0);
                Integer jGiftCount = giverGiftCount.getOrDefault(friendJ, 0) - receiverGiftCount.getOrDefault(friendJ, 0);

                // 선물 지수 비교
                if (iGiftCount > jGiftCount) tmp++;
            }

            max = Math.max(tmp, max);
        }

        return max;
    }
}
