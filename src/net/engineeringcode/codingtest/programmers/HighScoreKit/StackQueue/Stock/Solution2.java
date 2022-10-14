package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.Stock;
import java.util.*;

public class Solution2 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 스택/큐 > 주식가격
	 * https://programmers.co.kr/learn/courses/30/lessons/42584
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 */

	 public int[] solution(int[] prices) {
		 int[] answer = new int[prices.length];

		 int noChangedTime = -1;
         for(int i=0;i<prices.length;i++) {
        	 noChangedTime = 0;
        	 for(int j=i+1;j<prices.length;j++) {
        		 noChangedTime++;
        		 if(prices[i] > prices[j]) {
        			 break;
        		 }
        	 }
        	 answer[i] = noChangedTime;
         }
		 
         return answer;
    }
    
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
    	int[] prices = new int[]{1, 2, 3, 2, 3};
		int[] answerCorrect = new int[]{4, 3, 1, 1, 0};
		int[] answerReturned = null;		
		
		answerReturned = solution.solution(prices);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
	}
    
}
