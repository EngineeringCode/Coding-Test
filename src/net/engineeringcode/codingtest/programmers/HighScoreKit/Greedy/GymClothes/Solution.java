package net.engineeringcode.codingtest.programmers.HighScoreKit.Greedy.GymClothes;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > Ž���(Greedy) > ü����
	 * https://programmers.co.kr/learn/courses/30/lessons/42862
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ������ �����ϳ� ������ �ټ� ��ٷӰ� ��Ȯ�ϰ� ������ ���� ���� ������ �׽�Ʈ ���̽��� ������� �� �ϴ� ��찡 �ֽ��ϴ�.
	 */
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        // �չ�ȣ�� �л����� ���� �������� ������ ���α׷��ӽ� ä���� ����Ѵ�.
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // ������ ������ ����� ���� ���� ��쿡 ü������ �� �����ֵ��� ����.
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		if(reserve[j]==lost[i]) {
        			answer++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        // ���� ���� ����� ������ ������ ������� ������.
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		if(reserve[j]==lost[i]-1 || reserve[j]==lost[i]+1) {
        			answer++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        
        return answer;
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int n = 5;
    	int[] lost = new int[] {2, 4};
    	int[] reserve = new int[] {1, 3, 5};
    	int answerCorrect = 5;
		int answerReturned = -1;
		
		answerReturned = solution.solution(n, lost, reserve);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		n = 5;
    	lost = new int[] {2, 4};
    	reserve = new int[] {3};
    	answerCorrect = 4;
		answerReturned = -1;
		
		answerReturned = solution.solution(n, lost, reserve);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		n = 3;
    	lost = new int[] {3};
    	reserve = new int[] {1};
    	answerCorrect = 2;
		answerReturned = -1;
		
		answerReturned = solution.solution(n, lost, reserve);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
		
		// ���� �߰��� ���̽�
		n = 7;
    	lost = new int[] {3, 5};
    	reserve = new int[] {3, 6};
    	answerCorrect = 7;
		answerReturned = -1;
		
		answerReturned = solution.solution(n, lost, reserve);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
    }
}
