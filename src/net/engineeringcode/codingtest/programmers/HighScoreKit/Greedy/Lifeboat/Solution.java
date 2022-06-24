package net.engineeringcode.codingtest.programmers.HighScoreKit.Greedy.Lifeboat;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > Ž���(Greedy) > ����Ʈ
	 * https://programmers.co.kr/learn/courses/30/lessons/42885
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �ִ� 2�� Ż �� �ִ� ���� ����Ͽ� ���� ���ſ� ����� ���� ������ ����� �Բ� �¿� ������ �������� ������ �ذ��Ѵ�.
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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