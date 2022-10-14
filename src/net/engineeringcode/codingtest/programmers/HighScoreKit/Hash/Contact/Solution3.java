package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Contact;
import java.util.*;

public class Solution3 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 해시 > 전화번호
	 * https://programmers.co.kr/learn/courses/30/lessons/42577
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 문제의 지문을 이해하는 것에 시간이 오래 걸렸다. 번호들 중에 하나라도 다른 사람의 번호에서 시작하는 같은 경우가 있으면 false라는 말이다.
	 * Solution2에서 발생하는 해시맵 비대화를 해결하기 위한 방법이다.
	 * 전화번호 목록을 해시맵으로 가공하고 해당 전화번호로 확인할 수 있는 모든 경우 중 하나라도 해시맵에 있는지 확인하도록 구현하였다. 
	 */
	
    public boolean solution(String[] phone_book) {
    	// 전화번호를 해시맵으로 가공
    	HashMap<String, Boolean> stringList = new HashMap<>();
    	for(int i=0; i<phone_book.length; i++) {
    		stringList.put(phone_book[i], false);
    	}
    	// 해당 전화번호로 확인할 수 있는 모든 경우 중 하나라도 해시맵에 있는지 확인
    	for(int i=0; i<phone_book.length; i++) {
    		for(int j=0; j<phone_book[i].length(); j++) {
    			if(stringList.getOrDefault(phone_book[i].substring(0, j), null) != null) {
        			return false;
        		}
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) { 
    	Solution3 solution = new Solution3();
    	
    	String[] phone_book = new String[] {"119", "97674223", "1195524421"};
    	boolean answerCorrect = false;
		boolean answerReturned = true;		
		
		answerReturned = solution.solution(phone_book);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		phone_book = new String[] {"123", "456", "789"};
		answerCorrect = true;
		answerReturned = true;		
		
		answerReturned = solution.solution(phone_book);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
		
		phone_book = new String[] {"12", "123", "1235", "567", "88"};
		answerCorrect = false;
		answerReturned = true;		
		
		answerReturned = solution.solution(phone_book);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}	
	}
    
}
