package net.engineeringcode.codingtest.programmers.HighScoreKit.Sorting.NumberK;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ���� > K��°��
	 * https://programmers.co.kr/learn/courses/30/lessons/42748
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �迭�� ���ǿ� ���� �ڸ��� �������� ������ �� ���° ���� ���� ã�� �����̴�.
	 * �迭�� �ٷ�� �⺻���� ������ �� �� �ִ��ĸ� ���� �����̴�.
	 */
	
	public int[] solution(int[] array, int[][] commands) {
    	int[] answer = new int[commands.length];

        for(int n=0; n<commands.length; n++){
        	// ����(���)�� �����ϱ� ���ϰ� �����Ѵ�.
            int[] command = commands[n];
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] parsedAnswer = Arrays.copyOfRange(array, i-1, j); // �迭�� ���ǿ� ���� �ڸ���(�����Ѵ�).
            Arrays.sort(parsedAnswer); // �������� �����Ѵ�.
    
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
