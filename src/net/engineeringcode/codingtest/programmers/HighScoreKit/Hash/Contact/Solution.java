package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Contact;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 해시 > 전화번호
	 * https://programmers.co.kr/learn/courses/30/lessons/42577
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 문제의 지문을 이해하는 것에 시간이 오래 걸렸다. 번호들 중에 하나라도 다른 사람의 번호에서 시작하는 같은 경우가 있으면 false라는 말이다.
	 * 단순하게 배열을 하나씩 순회하면서 모든 경우를 계산하면 정확성 테스트는 통과하지만 효율성 테스트를 통과하지 못 한다.
	 * 효율성테스트를 해시를 사용해서 통과한 것은 Solution2에 있다.
	 */
	
    public boolean solution(String[] phone_book) {
    	for(int i=0; i<phone_book.length; i++) {
    		for(int j=0;j<phone_book.length; j++) {
    			if(j==i) {
    				continue;
    			}
    			//if(phone_book[j].indexOf(phone_book[i])==0) {
    			if(phone_book[j].startsWith(phone_book[i])==true) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
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
