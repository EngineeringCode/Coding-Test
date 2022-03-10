package net.engineeringcode.codingtest.programmers.HighScoreKit.Sorting.HIndex;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ���� > H-Index
	 * https://programmers.co.kr/learn/courses/30/lessons/42748
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ���� ���� �ο�Ƚ���� ���� H-Index�� ����ϴ� �����̴�. 
	 * H-Index�� �˰� �ִٸ� �ݹ� Ǯ �� �ִ� �����̴�. �ƴ϶�� H-Index�� ���ؼ� �����ϴ� �ð��� �ʿ��� ���̴�.
	 * ���� ��� ���п� ��Ȱ �� ���߱� ������ �˰� �ִ�.
	 */
	
    public int solution(int[] citations) {
        int hIndex = 0;
        
        Arrays.sort(citations);
        
        for(int i=citations.length-1; i>=0; i--){
            if(citations[i] > hIndex){
                hIndex++;
            }
        }
        
        return hIndex;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] citations = new int[] {3, 0, 6, 1, 5};
    	int answerCorrect = 3;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(citations);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
	}
}
