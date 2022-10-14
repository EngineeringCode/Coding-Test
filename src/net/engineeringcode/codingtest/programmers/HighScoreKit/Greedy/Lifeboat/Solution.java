package net.engineeringcode.codingtest.programmers.HighScoreKit.Greedy.Lifeboat;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 탐욕법(Greedy) > 구명보트
	 * https://programmers.co.kr/learn/courses/30/lessons/42885
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 최대 2명씩 탈 수 있는 점을 고려하여 가장 무거운 사람과 가장 가벼운 사람을 함께 태워 보내는 전략으로 문제를 해결한다.
	 */
	
    public int solution(int[] people, int limit) {
    	int answer = 0;        
        
        Arrays.sort(people);
        for(int i=0, j=people.length-1; i<=j; j--){
            if(people[i]+people[j]<=limit) {
            	i++;
            	answer++;
            } else {
            	answer++;
            }
        }
        
        return answer;
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] people = new int[]{50, 70, 80, 50};
    	int limit = 100;
    	int answerCorrect = 3;
		int answerReturned = -1;
		
		answerReturned = solution.solution(people, limit);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		people = new int[]{70, 80, 50};
    	limit = 100;
    	answerCorrect = 3;
		answerReturned = -1;
		
		answerReturned = solution.solution(people, limit);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		// 내가 추가한 테스트 케이스
		people = new int[]{70, 80, 50, 40, 240};
    	limit = 240;
    	answerCorrect = 3;
		answerReturned = -1;
		
		answerReturned = solution.solution(people, limit);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
    }
}