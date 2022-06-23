package net.engineeringcode.codingtest.programmers.HighScoreKit.Greedy.BiggestNumber;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > Ž���(Greedy) > ū �� �����
	 * https://programmers.co.kr/learn/courses/30/lessons/42883
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ���� ��ġ(�ڸ�)�̵��� �Ұ����ϴ�.
	 */
	
	public String solution(String number, int k) {
		StringBuilder stringBuilder = new StringBuilder();
		int lastIndex = -1;
		
        for(int i=0;i<number.length()-k;i++) { // Ž���ؾ��ϴ� �ִ� �Ÿ��� number.length()-k�̴�.
        	int maximumNumber = 0;
        	for(int j=lastIndex+1; j<=i+k; j++) { // �ڸ� �� �ִ� �ִ� ������ i+k �̴�.
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