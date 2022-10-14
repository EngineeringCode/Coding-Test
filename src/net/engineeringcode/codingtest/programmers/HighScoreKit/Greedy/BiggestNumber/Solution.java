package net.engineeringcode.codingtest.programmers.HighScoreKit.Greedy.BiggestNumber;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 탐욕법(Greedy) > 큰 수 만들기
	 * https://programmers.co.kr/learn/courses/30/lessons/42883
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 수의 위치(자리)이동은 불가능하다.
	 */
	
	public String solution(String number, int k) {
		StringBuilder stringBuilder = new StringBuilder();
		int lastIndex = -1;
		
        for(int i=0;i<number.length()-k;i++) { // 탐색해야하는 최대 거리는 number.length()-k이다.
        	int maximumNumber = 0;
        	for(int j=lastIndex+1; j<=i+k; j++) { // 자를 수 있는 최대 범위는 i+k 이다.
        		if(maximumNumber < number.charAt(j)-'0') {
        			maximumNumber = number.charAt(j)-'0';
        			lastIndex = j;
        		}
        	}
        	stringBuilder.append(maximumNumber);
        }
        return stringBuilder.toString();
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
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