package net.engineeringcode.codingtest.programmers.HighScoreKit.Sorting.NumberK;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 정렬 > K번째수
	 * https://programmers.co.kr/learn/courses/30/lessons/42748
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 배열을 조건에 따라 자르고 오름차순 정렬한 후 몇번째 정수 값을 찾는 문제이다.
	 * 배열을 다루고 기본적인 정렬을 할 수 있느냐를 묻는 문제이다.
	 */
	
	public int[] solution(int[] array, int[][] commands) {
    	int[] answer = new int[commands.length];

        for(int n=0; n<commands.length; n++){
        	// 조건(명령)을 이해하기 편하게 가공한다.
            int[] command = commands[n];
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] parsedAnswer = Arrays.copyOfRange(array, i-1, j); // 배열을 조건에 따라 자른다(복사한다).
            Arrays.sort(parsedAnswer); // 오름차순 정렬한다.
    
            answer[n] = parsedAnswer[k-1];
        }

        return answer;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
    	int[][] commands = new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    	int[] answerCorrect = new int[]{5, 6, 3};
		int[] answerReturned = null;		
		
		answerReturned = solution.solution(array, commands);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
	}
}
