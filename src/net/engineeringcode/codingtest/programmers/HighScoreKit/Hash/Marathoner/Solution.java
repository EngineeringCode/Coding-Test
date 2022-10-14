package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Marathoner;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 해시 > 완주하지 못한 선수
	 * https://programmers.co.kr/learn/courses/30/lessons/42576
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 이렇게 풀면 정확성 테스트는 통과하나 효율성 테스트를 통과하지 못 한다.
	 * Solution2에서 해시를 활용하여 해결하였다.
	 */
	
    public String solution(String[] participant, String[] completion) {
    	// 참여한 선수 목록에 완주한 선수 이름을 뺀다.
    	for(String comple: completion) {
    		for(int i=0;i<participant.length;i++) {
    			if(participant[i].equals(comple)) {
    				participant[i] = "";
    				break;
    			}
    		}
    	}
    	
    	// 참여한 선수 목록에 이름이 있는 사람이 완주하지 못한 선수이다.
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
