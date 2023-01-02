package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.NoRepeatedDigits;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 스택/큐 > 같은 숫자는 싫어
	 * https://school.programmers.co.kr/learn/courses/30/lessons/12906#
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 */
	
	public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int previousValue = -1;
        for(int i=0; i<arr.length; i++){
            if(previousValue == arr[i]){
                continue;
            }
            list.add(arr[i]);
            previousValue = arr[i];
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] arr = new int[]{1, 1, 3, 3, 0, 1, 1};
		int[] answerCorrect = new int[]{1, 3, 0, 1};
		int[] answerReturned = null;
		
		answerReturned = solution.solution(arr);
		
		System.out.println("Returned Value == " + Arrays.toString(answerCorrect));
		System.out.println("Expected Value == " + Arrays.toString(answerReturned));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		arr = new int[]{4, 4, 4, 3, 3};
		answerCorrect = new int[]{4, 3};
		answerReturned = null;
		
		answerReturned = solution.solution(arr);
		
		System.out.println("Returned Value == " + Arrays.toString(answerCorrect));
		System.out.println("Expected Value == " + Arrays.toString(answerReturned));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
	}
    
}
