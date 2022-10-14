package net.engineeringcode.codingtest.programmers.HighScoreKit.Sorting.HIndex;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 정렬 > H-Index
	 * https://programmers.co.kr/learn/courses/30/lessons/42748
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 논문의 수와 인용횟수를 토대로 H-Index를 계산하는 문제이다. 
	 * H-Index를 알고 있다면 금방 풀 수 있는 문제이다. 아니라면 H-Index에 대해서 이해하는 시간이 필요할 것이다.
	 * 나의 경우 대학원 생활 때 접했기 때문에 알고 있다.
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
