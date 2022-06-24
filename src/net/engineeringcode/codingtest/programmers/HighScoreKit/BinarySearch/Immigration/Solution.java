package net.engineeringcode.codingtest.programmers.HighScoreKit.BinarySearch.Immigration;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �̺�Ž�� > �Ա��ɻ�
	 * https://programmers.co.kr/learn/courses/30/lessons/43238
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * 
	 */
	
	public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = (long) times[0]; // ���� ª�� �ɸ��� �ð�
        long right = (long) times[times.length-1]*n; // ���� ���� �ɸ��� �ð�
        while(left <= right) {
        	long mid = (left + right) / 2;
        	long finishedCount = 0; // �ɻ��� �ο�
        	
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