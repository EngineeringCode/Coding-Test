package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Marathoner;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �ؽ� > �������� ���� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/42576
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �̷��� Ǯ�� ��Ȯ�� �׽�Ʈ�� ����ϳ� ȿ���� �׽�Ʈ�� ������� �� �Ѵ�.
	 * Solution2���� �ؽø� Ȱ���Ͽ� �ذ��Ͽ���.
	 */
	
    public String solution(String[] participant, String[] completion) {
    	// ������ ���� ��Ͽ� ������ ���� �̸��� ����.
    	for(String comple: completion) {
    		for(int i=0;i<participant.length;i++) {
    			if(participant[i].equals(comple)) {
    				participant[i] = "";
    				break;
    			}
    		}
    	}
    	
    	// ������ ���� ��Ͽ� �̸��� �ִ� ����� �������� ���� �����̴�.
    	for(String partici: participant) {
    		if(partici!="") {
    			return partici;
    		}
    	}
        return "";
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
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
