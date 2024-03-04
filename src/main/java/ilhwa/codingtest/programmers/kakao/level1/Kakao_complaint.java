package ilhwa.codingtest.programmers.kakao.level1;


import java.util.*;
import java.util.stream.Collectors;



public class Kakao_complaint {

    /**
     * id_list = 이용자의 ID가 담긴 문자열 배열
     * id_list = [muzi, frodo, apeach]
     * report = 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열
     * report = ["muzi frodo","apeach frodo","frodo neo","muzi neo"]
     * k = 정지 기준이 되는 신고 횟수 k
     */

    public int[] solution(String[] id_list, String[] report, int k) {
        System.out.println("solution");
        // 동일한 유저에 대한 신고 횟수는 1회로 처리되므로, 중복 신고값을 제거한다.
        List<String> reportList = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> countMap = new HashMap<>();

        // 각 유저별로 신고당한 횟수를 구한다.
        for (String reportTxt : reportList) {
            String target = reportTxt.split(" ")[1]; // 신고당한사람
            countMap.put(target, countMap.getOrDefault(target, 0) + 1);
        }

        int[] answer = Arrays.stream(id_list).map(userId -> {
            final String user = userId;
            // 각 유저별로 신고한 아이디 리스트업
            List<String> userReportList = reportList.stream()
                .filter(reportTxt -> reportTxt.startsWith(user + " "))
                .collect(Collectors.toList());

            // 유저가 신고한 아이디의 신고당한 횟수와, 정지 기준이 되는 신고 횟수 비교
            return userReportList.stream()
                .filter(userReportTxt -> countMap.getOrDefault(userReportTxt.split(" ")[1], 0) >= k)
                .count();

        }).mapToInt(Long::intValue).toArray();

        return answer;

    }


}