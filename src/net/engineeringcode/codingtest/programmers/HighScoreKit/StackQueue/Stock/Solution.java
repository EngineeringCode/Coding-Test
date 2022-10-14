package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.Stock;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 스택/큐 > 주식가격
	 * https://programmers.co.kr/learn/courses/30/lessons/42584
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 이렇게 하면 정확성 테스트는 통과하나 효율성 테스를 통과하지 못 한다. 
	 * Solution2는 효율성 테스트도 통과하였다.
	 */

	 public int[] solution(int[] prices) {
		 LinkedList<Integer> priceList = new LinkedList<>();
		 int[] answer = new int[prices.length];
		 
		 for(int price:prices) {
			 priceList.add(price);
		 }
		 
		 for(int i=0;!priceList.isEmpty();i++) {
			 int noChangedTime = 0;
			 int targetPrice = priceList.removeFirst();;
			 
			 LinkedList<Integer> priceListClone = new LinkedList<>();
			 priceListClone.addAll(priceList);
			 for(int price:priceListClone) {
				 noChangedTime++;
				 if(targetPrice > price) {
					 break;
				 }
			 }
			 answer[i] = noChangedTime;
		 }
        
         return answer;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
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
