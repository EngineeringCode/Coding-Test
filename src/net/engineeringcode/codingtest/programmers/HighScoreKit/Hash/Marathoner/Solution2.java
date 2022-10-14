package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Marathoner;
import java.util.*;

public class Solution2 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 해시 > 완주하지 못한 선수
	 * https://programmers.co.kr/learn/courses/30/lessons/42576
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 해시맵을 활용하여 정확성 테스트와 효율성 테스트를 통과하였다.
	 * 해시맵은 마라톤 선수의 이름을 키로 하였고 인원수를 값으로 저장하였다.
	 */
	
    public String solution(String[] participant, String[] completion) {
    	HashMap<String, Integer> participantMap = new HashMap<>();
    	for(String partici: participant) {
    		if(participantMap.containsKey(partici)) {
    			participantMap.put(partici, participantMap.get(partici)+1);
    		}else {
    			participantMap.put(partici, 1);
    		}
    	}
    	
    	for(String comple: completion) {
    		if(participantMap.getOrDefault(comple, null) != null) {
    			participantMap.put(comple, participantMap.get(comple)-1);
    		}
    	}
    	
    	for(String partici: participantMap.keySet()) {
    		int value = participantMap.get(partici);
    		if(value != 0) {
    			return partici;
    		}
    	}
    	
        return "";
    }
    
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
    	String[] participant = new String[] {"leo", "kiki", "eden"};
    	String[] completion = new String[] {"eden", "kiki"};
    	String answerCorrect = "leo";
		String answerReturned = null;		
		
		answerReturned = solution.solution(participant, completion);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect.equals(answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
    	participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
    	completion = new String[] {"josipa", "filipa", "marina", "nikola"};
    	answerCorrect = "vinko";
		answerReturned = null;		
		
		answerReturned = solution.solution(participant, completion);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect.equals(answerReturned)) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
		
    	participant = new String[] {"mislav", "stanko", "mislav", "ana"};
    	completion = new String[] {"stanko", "ana", "mislav"};
    	answerCorrect = "mislav";
		answerReturned = null;		
		
		answerReturned = solution.solution(participant, completion);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect.equals(answerReturned)) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}	
	}
    
}
