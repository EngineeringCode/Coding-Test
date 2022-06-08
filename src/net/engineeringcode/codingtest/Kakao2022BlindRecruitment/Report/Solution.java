package net.engineeringcode.codingtest.Kakao2022BlindRecruitment.Report;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > 2022 īī�� ����ε� ä�� > ��� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/92343
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * 
	 */ 
    public int[] solution(String[] id_list, String[] report, int k) {   
        // ����ڸ�� ����ڰ� �̸����� ���� Ƚ���� ��� �ִ� �ؽø��� �����Ѵ�. ��ü�� ��ȸ�ϴ� ���� ���� ����.
        HashMap<String, Integer> userMap = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            userMap.put(id_list[i], 0);
        }        
        //System.out.println(userMap);
        
        // ���ڷ� ���� ���� ������ �ߺ��� �����Ѵ�.
        HashSet<String> reportSet = new HashSet<String>();
        for(String re:report){
            reportSet.add(re);
        }
        //System.out.println(reportSet);
        
        // ������ �ؽø����� �����Ѵ�.
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
            
            // StringBuilder�� �ʱ�ȭ �Ǿ� ���� �ʴٸ� �ʱ�ȭ
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
        
        // 2�� �̻� �Ű�� ������ ã�� �Ű��� ����ڿ��� ������ ���� �˸���. �˸��� Ƚ���� ������Ų��.
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
                // �Ű�� ������ ������Ű�� �̸��Ϸ� ���� ������ �Ű��ڿ��� �˸���.
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
