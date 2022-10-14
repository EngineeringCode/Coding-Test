package net.engineeringcode.codingtest.programmers.HighScoreKit.DFSBFS.TargetNumber;
import java.util.*;

public class Solution2 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버
	 * https://programmers.co.kr/learn/courses/30/lessons/43165
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 처음 숫자부터 마지막 숫자까지 더하거나 빼는 모든 경우의 수를 계산해야하는 문제이므로 DFS(Depth-first search)로 푸는 것이 적절합니다.
	 * DFS의 시간복잡도는 BFS(Breadth-First Search)랑 같지만 공간복잡도 측면에서 BFS보다 훨씬 작다.
	 */

	int answer;
	
    public int solution(int[] numbers, int target) {
    	answer = 0;
    	
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int targetNumber, int currentNumber){
        if (depth == numbers.length){
            if (targetNumber == currentNumber){
                this.answer++;
            }
            return;
        }
        
        int addition = currentNumber + numbers[depth];        
        dfs(numbers, depth+1, targetNumber, addition);
        
        int subtraction = currentNumber - numbers[depth];
        dfs(numbers, depth+1, targetNumber, subtraction);
        
    }
           
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
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