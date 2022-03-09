package net.engineeringcode.codingtest.programmers.HighScoreKit.BruteForce.PrimeNumber;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ����Ž�� > �Ҽ� ã��
	 * https://programmers.co.kr/learn/courses/30/lessons/42839
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �־��� ��ȣ��� ������ ���� �� �Ҽ��� ������ ���ϴ� �����̴�.
	 */
	
	int answer = -1;
	String[] numberStringArray = null;
	HashMap<Integer, Boolean> combinationHashMap = null;
	
	public int solution(String numbers) {
		answer = 0;
		combinationHashMap = new HashMap<>();
		
		// �־��� ���ڸ� �迭�� ����
		numberStringArray = numbers.split("");
		String[] output = new String[numberStringArray.length];
		
		// �־��� ���ڷ� ���� ����
		boolean[] visited = new boolean[numberStringArray.length];
		for(int r = 1; r <= numberStringArray.length; r++) {
			permutation(numberStringArray, output, visited, 0, numberStringArray.length, r);
		}
		
		//System.out.println("combinationHashMap.size():"+combinationHashMap.size());
		
		for(Integer key: combinationHashMap.keySet()) {
			//System.out.println("key:"+key);
			if(isPrimeNumber(key)) {
				//System.out.println("key:"+key);
				answer++;
			}
		}
		
        return answer;
    }
	
	void permutation(String[] arr, String[] output, boolean[] visited, int depth, int n, int r) {
		if(depth == r) {
			//print(output, r);
			addNumber(output, r);
			return;
		}

		for(int i = 0; i < n; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation(arr, output, visited, depth + 1, n, r);    
				visited[i] = false;
			}
		}
	}
	
	boolean isPrimeNumber(int number) {
		if(number < 2) {
			return false;
		}	
		
		if(number == 2) {
			return true;
		}
		
		for(int i=2; i < number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	void print(String[] arr, int r) {
		for(int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	void addNumber(String[] arr, int r) {
		String tmpNumber = "";
		for(int i = 0; i < r; i++)
			tmpNumber += arr[i];
		combinationHashMap.put(Integer.parseInt(tmpNumber), false);
	}
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	String numbers = "17";
    	int answerCorrect = 3;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(numbers);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		numbers = "011";
    	answerCorrect = 2;
		answerReturned = -1;		
		
		answerReturned = solution.solution(numbers);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
	}
}
