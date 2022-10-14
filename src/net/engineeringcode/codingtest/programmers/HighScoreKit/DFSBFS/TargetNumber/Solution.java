package net.engineeringcode.codingtest.programmers.HighScoreKit.DFSBFS.TargetNumber;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버
	 * https://programmers.co.kr/learn/courses/30/lessons/43165
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 처음 숫자부터 마지막 숫자까지 더하거나 빼는 모든 경우의 수를 계산해야하는 문제이므로 DFS(Depth-first search)로 푸는 것이 유리하지만 BFS(Breadth-First Search)로 풀어봤다.
	 * 
	 */
	
    public int solution(int[] numbers, int target) {
    	int answer = 0;
    	
    	// To-Do
        
        return answer;
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] numbers = new int[]{1, 1, 1, 1, 1};
    	int target = 3;
    	
    	int answerCorrect = 5;
    	int answerReturned = -1;
    	
		answerReturned = solution.solution(numbers, target);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		numbers = new int[]{4, 1, 2, 1};
    	target = 4;
    	
    	answerCorrect = 2;
    	answerReturned = -1;
    	
		answerReturned = solution.solution(numbers, target);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
    }
}