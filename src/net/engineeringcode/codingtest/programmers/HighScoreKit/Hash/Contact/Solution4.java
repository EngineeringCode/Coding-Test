package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Contact;
import java.util.*;

public class Solution4 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 해시 > 전화번호
	 * https://programmers.co.kr/learn/courses/30/lessons/42577
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 문제의 지문을 이해하는 것에 시간이 오래 걸렸다. 번호들 중에 하나라도 다른 사람의 번호에서 시작하는 같은 경우가 있으면 false라는 말이다.
	 * '번호에서 시작하는'을 이용하면 정렬로 해결할 수 있다. 해시로 가공하는 것 대비 메모리를 절약할 수 있다.
	 */
	
    public boolean solution(String[] phone_book) {
    	// 오름차순으로 전화번호 배열을 정렬
    	Arrays.sort(phone_book);
    	// 해당 인덱스의 다음 인덱스에 해당 인덱스의 값(전화번호)으로 시작하는지 확인
    	for(int i=0; i<phone_book.length-1; i++) {
    		if(phone_book[i+1].startsWith(phone_book[i])) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) { 
    	Solution4 solution = new Solution4();
    	
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
