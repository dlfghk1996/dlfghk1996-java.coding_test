//package ilhwa.codingtest.programmers.kakao.level1;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Kakao_privacy_expiryDate {
//    public int[] solution1(String today, String[] terms, String[] privacies) {
//        // "2022.05.19"
//        // term ["A 6", "B 12", "C 3"]
//        // privacies ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
//        List<Integer> answer = new ArrayList<>();
//        Map<String, Integer> termMap = new HashMap<>();
//        int date = getDate(today);
//
//        // termsMap 생성
//        for (String s : terms) {
//            String[] term = s.split(" ");
//            termMap.put(term[0], Integer.parseInt(term[1]));
//        }
//        for (int i = 0; i < privacies.length; i++) {
//            String[] privacy = privacies[i].split(" ");
//
//            if (getDate(privacy[0]) +(termMap.get(privacy[1]) * 28) <= date) {
//                answer.add(i + 1);
//            }
//        }
//        return answer.stream().mapToInt(integer -> integer).toArray();
//    }
//
//    private int getDate(String privacyCollectionDate) {
//        String[] date = privacyCollectionDate.split("\\.");
//        int year = Integer.parseInt(date[0]);
//        int month = Integer.parseInt(date[1]);
//        int day = Integer.parseInt(date[2]);
//        // 연도, 월, 일 하나하나 계산하기 귀찮으니까 전부 일수로 치환해서 손쉽게 계산
//        return (year * 12 * 28) + (month * 28) + day;
//    }
//
//    // LocalDate  이용 (한달 28일에는 안걸리는가?)
//    public int[] solution2(String today, String[] terms, String[] privacies) {
//        List<Integer> answer = new ArrayList();
//
//        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy.MM.dd");
//        LocalDate date = LocalDate.parse(today, formatter);
//
//        // 찾기 쉽도록 termsMap 구성
//        Map<String, Integer> termsMap = new HashMap<>();
//
//        for(int i=0; i<terms.length; i++) {
//            String[] term = terms[i].split(" ");
//            termsMap.put(term[0], Integer.valueOf(term[1]));
//        }
//
//        for(int i=0; i<privacies.length; i++) {
//            String[] privacy = privacies[i].split(" ");
//            LocalDate privacyRegisterYmdt = LocalDate.parse(privacy[0], formatter).plusMonths(termsMap.get(privacy[1])).minusDays(1);
//
//
//            if (privacyRegisterYmdt.isBefore(date)) {
//                answer.add(i+1);
//            }
//        }
//
//        return answer.stream().mapToInt(Integer::intValue).toArray();
//    }
//}
