package net.engineeringcode.codingtest.programmers.HighScoreKit.DFSBFS.TargetNumber;
import java.util.*;

public class Solution2 {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ����/�ʺ� �켱 Ž��(DFS/BFS) > Ÿ�� �ѹ�
	 * https://programmers.co.kr/learn/courses/30/lessons/43165
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ó�� ���ں��� ������ ���ڱ��� ���ϰų� ���� ��� ����� ���� ����ؾ��ϴ� �����̹Ƿ� DFS(Depth-first search)�� Ǫ�� ���� �����մϴ�.
	 * DFS�� �ð����⵵�� BFS(Breadth-First Search)�� ������ �������⵵ ���鿡�� BFS���� �ξ� �۴�.
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