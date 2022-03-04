package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Marathoner;
import java.util.*;

public class Solution2 {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �ؽ� > �������� ���� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/42576
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �ؽø��� Ȱ���Ͽ� ��Ȯ�� �׽�Ʈ�� ȿ���� �׽�Ʈ�� ����Ͽ���.
	 * �ؽø��� ������ ������ �̸��� Ű�� �ο����� ������ �����Ͽ���.
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
