package net.engineeringcode.codingtest.programmers.HighScoreKit.Greedy.BiggestNumber;
import java.util.*;

public class Solution2 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 탐욕법(Greedy) > 큰 수 만들기
	 * https://programmers.co.kr/learn/courses/30/lessons/42883
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 조합으로 풀어보자
	 */
	
	public String solution(String number, int k) {
		StringBuilder stringBuilder = new StringBuilder();

		// To-Do
		
        return stringBuilder.toString();
    }
           
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
    	String number = "1924";
    	int k = 2;
    	String answerCorrect = "94";
    	String answerReturned = "";
		
		answerReturned = solution.solution(number, k);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect.equals(answerReturned)){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		number = "1231234";
    	k = 3;
    	answerCorrect = "3234";
    	answerReturned = "";
		
		answerReturned = solution.solution(number, k);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect.equals(answerReturned)){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		number = "4177252841";
    	k = 4;
    	answerCorrect = "775841";
    	answerReturned = "";
		
		answerReturned = solution.solution(number, k);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect.equals(answerReturned)){
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
    }
}