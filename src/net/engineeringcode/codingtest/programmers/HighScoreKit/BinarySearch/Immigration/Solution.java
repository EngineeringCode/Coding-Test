package net.engineeringcode.codingtest.programmers.HighScoreKit.BinarySearch.Immigration;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 이분탐색 > 입국심사
	 * https://programmers.co.kr/learn/courses/30/lessons/43238
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 */
	
	public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = (long) times[0]; // 가장 짧게 걸리는 시간
        long right = (long) times[times.length-1]*n; // 가장 오래 걸리는 시간
        while(left <= right) {
        	long mid = (left + right) / 2;
        	long finishedCount = 0; // 심사한 인원
        	
        	for(int time : times) {
        		finishedCount += (mid / time);
        		if(finishedCount >= n) {
        			break;
        		}
        	}
        	
        	if(finishedCount < n) {
        		left = mid +1;
        	} else {
        		right = mid -1;
        		answer = mid;
        	}
        }
        
        return answer;
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int n = 6;
    	int[] times = new int[] {7, 10};
    	long answerCorrect = 28;
    	long answerReturned = -1;
		
		answerReturned = solution.solution(n, times);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
    }
}