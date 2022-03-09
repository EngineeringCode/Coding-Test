package net.engineeringcode.codingtest.programmers.HighScoreKit.BruteForce.MockTest;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ����Ž�� > ���ǰ��
	 * https://programmers.co.kr/learn/courses/30/lessons/42840
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ���� ���� ��Ŀ� ���� ���� ���� ����ؼ� �ְ�����ڸ� ã�� ����
	 */
	
    public int[] solution(int[] answers) {
    	int[] answerCount = new int[] {0, 0, 0};    	
    	int[] answerPatternOne = new int[] {1, 2, 3, 4, 5};
    	int[] answerPatternTwo = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
    	int[] aAnswerPatternThree = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	// ���� �´��� Ȯ���ϰ� ���� ������ ����.
    	for(int i=0;i<answers.length;i++) {
    		if(answers[i] == answerPatternOne[i%answerPatternOne.length]) {
    			answerCount[0]++;
    		}
    		if(answers[i] == answerPatternTwo[i%answerPatternTwo.length]) {
    			answerCount[1]++;
    		}
    		if(answers[i] == aAnswerPatternThree[i%aAnswerPatternThree.length]) {
    			answerCount[2]++;
    		}
    	}
    	// ���� ���� ���� ��� ������ ��´�. ���� ���� ������ ���� ����� ������ �� ������ �� ��� �������� �����Ѵ�.
    	ArrayList<Integer> answerList = new ArrayList<>();
    	int maximumAnswerCount = 0;
    	for(int i=0; i<answerCount.length; i++) {
    		if(answerCount[i] > maximumAnswerCount) {
    			answerList.clear();
    			answerList.add(i+1);
    			maximumAnswerCount = answerCount[i];
    		}else if(answerCount[i] == maximumAnswerCount) {
    			answerList.add(i+1);
    		}
    	}
    	// �������� �䱸�ϴ� ���·� ���� ��� ������ �����Ѵ�.
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
        	answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] answers = new int[] {1, 2, 3, 4, 5};
    	int[] answerCorrect = new int[]{1};
		int[] answerReturned = null;		
		
		answerReturned = solution.solution(answers);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
    	answers = new int[] {1, 3, 2, 4, 2};
    	answerCorrect = new int[]{1, 2, 3};
		answerReturned = null;		
		
		answerReturned = solution.solution(answers);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
	}
}
