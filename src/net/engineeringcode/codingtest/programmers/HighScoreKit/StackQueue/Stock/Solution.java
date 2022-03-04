package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.Stock;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ����/ť > �ֽİ���
	 * https://programmers.co.kr/learn/courses/30/lessons/42584
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �̷��� �ϸ� ��Ȯ�� �׽�Ʈ�� ����ϳ� ȿ���� �׽��� ������� �� �Ѵ�. 
	 * Solution2�� ȿ���� �׽�Ʈ�� ����Ͽ���.
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
