package net.engineeringcode.codingtest.programmers.HighScoreKit.Sorting.BiggestNumber;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 정렬 > 가장 큰 수
	 * https://programmers.co.kr/learn/courses/30/lessons/42746
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 주어진 숫자로 만들 수 있는 가장 큰 숫자를 찾는 문제이다.
	 * 순열로 찾는 방법으로 풀어보았지만 정확성 테스트에서 시간초과로 실패한다.
	 * Solution2에 해결한 방법이 있다.
	 */
	
    String maximumNumber = "0";
    
    public String solution(int[] numbers) {
        boolean[] visited = new boolean[numbers.length];
        int[] output = new int[numbers.length];
        
        permutation(numbers, output, visited, 0, numbers.length, numbers.length);
        
        return maximumNumber;
    }
    
    void permutation(int[] array, int[] output, boolean[] visited, int depth, int n, int r){
        StringBuilder tmpNumber = new StringBuilder();
        if(depth == r){
            for(int i=0; i<r; i++){
                tmpNumber.append(output[i]);
                String currentNumber = tmpNumber.toString();
                if(currentNumber.compareTo(maximumNumber) > 0){
                    maximumNumber = currentNumber;
                }
            }
            return;
        }
        
        for(int i=0; i<n; i++){
            if(visited[i] != true){
                visited[i] = true;
                output[depth] = array[i];
                permutation(array, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] numbers = new int[] {6, 10, 2};
    	String answerCorrect = "6210";
    	String answerReturned = null;		
		
		answerReturned = solution.solution(numbers);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect.equals(answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		numbers = new int[] {3, 30, 34, 5, 9};
    	answerCorrect = "9534330";
    	answerReturned = null;		
		
		answerReturned = solution.solution(numbers);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect.equals(answerReturned)) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
	}
}
