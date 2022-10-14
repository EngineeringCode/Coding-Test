package net.engineeringcode.codingtest.programmers.HighScoreKit.BruteForce.MockTest;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 완전탐색 > 모의고사
	 * https://programmers.co.kr/learn/courses/30/lessons/42840
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 답을 고르는 방식에 따라 정답 수를 계산해서 최고득점자를 찾는 문제
	 */
	
    public int[] solution(int[] answers) {
    	int[] answerCount = new int[] {0, 0, 0};    	
    	int[] answerPatternOne = new int[] {1, 2, 3, 4, 5};
    	int[] answerPatternTwo = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
    	int[] aAnswerPatternThree = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	// 답이 맞는지 확인하고 맞춘 갯수를 센다.
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
    	// 가장 많이 맞춘 사람 정보를 담는다. 가장 높은 점수를 받은 사람이 여럿일 수 있으며 이 경우 오름차순 정렬한다.
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
    	// 문제에서 요구하는 형태로 맞춘 사람 정보를 가공한다.
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
