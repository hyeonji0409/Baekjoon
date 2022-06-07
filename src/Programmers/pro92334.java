package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class pro92334 {
    public static int[] Pro92334(String[] id_list, String[] report, int k){

        int[] answer = {};
        answer = new int[id_list.length];

    /*
        key는 userID
        value는 신고한 userID의 set을 가진 map
        동일한 userID에 대한 신고 횟수 -> 1회로 처리
        => 중복 허용을 하지 않는 set을 value로 사용
     */

        Map<String, HashSet<String>> reportedMap = new HashMap<>(); // [신고된 ID, 신고한 ID]
        Map<String, Integer> answerMap = new HashMap<>(); // [신고된 ID, 메일 수]

        /* 1. Map 초기화 */
        for(int i = 0; i < id_list.length; i++){
            HashSet<String> reportingId = new HashSet<>(); // 신고한 ID
            reportedMap.put(id_list[i], reportingId); // 유저ID, 신고한 ID 초기 세팅을 위함
            answerMap.put(id_list[i], 0); // 메일 수는 모두 0으로 초기화
        }

        System.out.println("1. reportedMap : " + reportedMap);
        System.out.println("1. answerMap : " + answerMap);

        /* 2. 신고 세팅 report => 신고한 ID, 신고된 ID로 구성 */
        for(String s : report){
            String[] reportStr = s.split(" ");
            String reportingID = reportStr[0]; // 신고한 ID
            String reportedID = reportStr[1]; // 신고된 ID
            reportedMap.get(reportedID).add(reportingID); // 신고된 ID를 key값으로 신고한 ID 배열을 value로 세팅
        }
        System.out.println("2. reportedMap에 신고 기록 세팅 : " + reportedMap);

        /* 3. User가 받은 이용 정지 결과 메일 세팅 */
        for(String reportedUser : reportedMap.keySet()){
            // reportedUser => 신고된 User
            HashSet<String> userForSend = reportedMap.get(reportedUser); // 신고한 유저
            if(userForSend.size() >= k){
                for(String userId : userForSend){
                    answerMap.put(userId, answerMap.get(userId) + 1); // answerMap에 신고된 ID별 메일 수 넣기
                }
            }
        }

        System.out.println("3. answerMap에 메일 수 세팅 : " + answerMap);

        /* userID별 받은 메일 수를 answer에 세팅 */
        for(int i = 0; i < id_list.length; i++){
            answer[i] = answerMap.get(id_list[i]);
            System.out.println("4. answer : " + answer[i]);
        }


        return answer;
    }
}
