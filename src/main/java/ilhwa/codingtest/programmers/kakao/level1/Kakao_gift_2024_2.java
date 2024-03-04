package ilhwa.codingtest.programmers.kakao.level1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Kakao_gift_2024_2 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 먼저 친구를 생성한다.
        List<Friend> friendList = new ArrayList<>();
        for(String friend : friends) {
            friendList.add(new Friend(friend));
        }

        // 선물의 주인을 찾아서 선물을 보낸다.
        for(String gift : gifts) {
            String senderName = gift.split(" ")[0];
            String receiverName = gift.split(" ")[1];
            Friend sender = findFriend(friendList, senderName);
            Friend receiver = findFriend(friendList, receiverName);
            sender.update(sender, receiver);
        }

        // 전부 선물을 보냈으면
        // 다음달에 받을 선물 예상 갯수를 업데이트 한다.
        for(Friend friend : friendList) {
            friend.updateExpectedGiftCount(friendList);
        }

        // 정렬 후 가장 예상 갯수가 많은 친구를 찾는다.
        Collections.sort(friendList);

        // 가장 예상 갯수가 많은 친구의 예상 갯수를 반환한다.
        return friendList.get(friendList.size() - 1).expectedGiftCount;
    }

    public Friend findFriend (List<Friend> friendList, String name){
        return friendList.stream()
            .filter(friend -> friend.name.equals(name))
            .findFirst()
            .orElse(null);
    }

    public static class Friend implements Comparable<Friend>{
        private final String name;          // 이름
        private int monthGiftPoint;     // 이번달 선물 지수
        private int expectedGiftCount;  // 다음달 받을 선물 예상 갯수

        public HashMap<Friend,Integer> receiveGiftHistory;  // 선물 받은 기록

        Friend (String name) {
            this.name = name;
            this.monthGiftPoint = 0;
            this.expectedGiftCount = 0;
            this.receiveGiftHistory = new HashMap<>();
        }

        public boolean isMe(Friend friend) {
            return this.name.equals(friend.name);
        }

        @Override
        public int compareTo(Friend o) {
            // 다음달에 받을 선물이 많으면 착한 친구
            return Integer.compare(this.expectedGiftCount, o.expectedGiftCount);
        }

        public void updateSendGiftHistory(Friend receiver) {
            receiver.monthGiftPoint -= 1;
            if(receiver.receiveGiftHistory == null) {
                receiver.receiveGiftHistory = new HashMap<>();
            }
            int originCount = receiver.receiveGiftHistory.getOrDefault(this, 0);
            // 상대의 선물 받은 기록에 추가
            receiver.receiveGiftHistory.put(this, originCount+ 1);
        }

        public void updateReceiveGiftHistory(Friend sender) {
            sender.monthGiftPoint += 1;
            if(this.receiveGiftHistory == null) {
                this.receiveGiftHistory = new HashMap<>();
            }
            int originCount = this.receiveGiftHistory.getOrDefault(sender,0);
            // 나의 선물 받은 기록에 추가
            this.receiveGiftHistory.put(sender, originCount + 1);
        }

        public void updateExpectedGiftCount(List<Friend> friendList) {
            for(Friend friend : friendList) {
                this.updateExpectedGiftCount(friend);
            }
        }

        public void updateExpectedGiftCount(Friend friend) {
            if(this.isMe(friend)) {
                return;
            }

            // 1. 먼저 서로간 선물을 주고 받은 갯수를 확인한다.
            // A. 내가 친구에게 받은 선물 갯수
            int receiveGiftCount  = this.receiveGiftHistory.getOrDefault(friend, 0);
            // B. 내가 친구에게 준 선물 갯수
            int sendGiftCount = friend.receiveGiftHistory.getOrDefault(this, 0);

            // 2. 서로간 선물을 주고 받은 갯수가 같다면 선물 지수를 확인한다.
            if(receiveGiftCount == sendGiftCount) {
                // 3. 선물 지수가 같다면 아무것도 하지 않는다.
                if(this.monthGiftPoint == friend.monthGiftPoint) {
                    return;
                }
                // 4. 선물 지수가 다르다면 높은 사람의 예상 갯수를 늘린다.
                if(friend.monthGiftPoint < this.monthGiftPoint) {
                    this.expectedGiftCount += 1;
                }
            }else{
                // 5. 서로간 선물을 주고 받은 갯수가 다르다면 많이 준 사람의 예상 갯수를 늘린다.
                if(sendGiftCount > receiveGiftCount) {
                    this.expectedGiftCount += 1;
                }
            }
        }

        public void update(Friend sender, Friend receiver) {
            if(this.isMe(sender)) {
                this.monthGiftPoint += 1;
                updateSendGiftHistory(receiver);
            }else if(this.isMe(receiver)) {
                this.monthGiftPoint -= 1;
                updateReceiveGiftHistory(sender);
            }
        }
    }
}
