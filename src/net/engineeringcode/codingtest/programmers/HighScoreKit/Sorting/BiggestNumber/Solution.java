package net.engineeringcode.codingtest.programmers.HighScoreKit.Sorting.BiggestNumber;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ���� > ���� ū ��
	 * https://programmers.co.kr/learn/courses/30/lessons/42746
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �־��� ���ڷ� ���� �� �ִ� ���� ū ���ڸ� ã�� �����̴�.
	 * ������ ã�� ������� Ǯ������� ��Ȯ�� �׽�Ʈ���� �ð��ʰ��� �����Ѵ�.
	 * Solution2�� �ذ��� ����� �ִ�.
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
