package net.engineeringcode.codingtest.Kakao2022BlindRecruitment.Report;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 2022 카카오 블라인드 채용 > 신고 결과 받기
	 * https://programmers.co.kr/learn/courses/30/lessons/92343
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 */ 
    public int[] solution(String[] id_list, String[] report, int k) {   
        // 사용자명과 사용자가 이메일을 받은 횟수를 담고 있는 해시맵을 생성한다. 전체를 순회하는 것을 막기 위함.
        HashMap<String, Integer> userMap = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            userMap.put(id_list[i], 0);
        }        
        //System.out.println(userMap);
        
        // 인자로 전달 받은 보고서에 중복을 제거한다.
        HashSet<String> reportSet = new HashSet<String>();
        for(String re:report){
            reportSet.add(re);
        }
        //System.out.println(reportSet);
        
        // 보고서를 해시맵으로 가공한다.
        HashMap<String, StringBuilder> reportMap = new HashMap<>();
        //HashMap<String, String> reportMap = new HashMap<>();
        for(String re:reportSet){
            //System.out.println(re);
            String[] parsedReport = re.split(" ");
            String reporter = parsedReport[0];
            String abuser = parsedReport[1];
            /*
            String reporters = reportMap.getOrDefault(abuser, null);
            
            if(reporters == null || reporters == ""){
                reportMap.put(abuser, reporter);
            }else{
                reportMap.put(abuser, reporters+" "+reporter);
            }
            System.out.println("abuser:"+abuser+" reporters:"+reporters);
            */
            
            // StringBuilder가 초기화 되어 있지 않다면 초기화
            if(reportMap.getOrDefault(abuser, null)==null){
                reportMap.put(abuser, new StringBuilder());
                reportMap.get(abuser).setLength(0);
            }
            
            StringBuilder stringBuilder = reportMap.get(abuser);
            
            if(reportMap.get(abuser).length()<=0){
                stringBuilder.insert(0, reporter);
            }else{
                stringBuilder.append(" "+reporter);
            }
            
            //System.out.println("abuser:"+abuser+" stringBuilder:"+stringBuilder);
        }
        
        // 2번 이상 신고된 계정을 찾고 신고한 사용자에게 정지된 것을 알린다. 알리면 횟수를 증가시킨다.
        for(String key:reportMap.keySet()){
            StringBuilder stringBuilder = reportMap.get(key);
            //System.out.println(stringBuilder.toString());
            String[] reporters = stringBuilder.toString().split(" ");
            /*
            //System.out.println(reportMap.get(key));
            String stringValue = reportMap.get(key);
            String[] reporters = stringValue.split(" ");
            */
            if(reporters.length>=k){
                // 신고된 계정을 정지시키고 이메일로 정지 내용을 신고자에게 알린다.
                for(String reporter: reporters){
                    int emailCount = userMap.get(reporter);
                    userMap.put(reporter, emailCount+1);
                }  
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            answer[i] = userMap.get(id_list[i]);
        }
        //System.out.println(Arrays.toString(mailCount));
        return answer;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	    	
    	String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
    	String[] report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    	int k = 2;
    	int[] answerCorrect = new int[]{2, 1, 1, 0};
		int[] answerReturned = null;		
		
		answerReturned = solution.solution(id_list, report, k);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)){
			System.out.println("CASE 1 PASS");
		}else{
			System.out.println("CASE 1 FAIL");
		}
		
		id_list = new String[]{"con", "ryan"};
    	report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
    	k = 3;
    	answerCorrect = new int[]{0, 0};
		answerReturned = null;		
		
		answerReturned = solution.solution(id_list, report, k);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
	}
    
}
