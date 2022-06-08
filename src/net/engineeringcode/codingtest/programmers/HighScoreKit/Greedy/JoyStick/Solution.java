package net.engineeringcode.codingtest.programmers.HighScoreKit.Greedy.JoyStick;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > Ž���(Greedy) > ���̽�ƽ
	 * https://programmers.co.kr/learn/courses/30/lessons/42860
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * 
	 */
	
	public int solution(String name) {
        int alphabetChangeCount = 0;
        int cursorMovementCount = name.length()-1;
        
        for(int i=0;i<name.length();i++) {
        	// ���� ���ĺ����� ���� ���� ���� ���ĺ����� ���� ��� �߿� ���� �� �������� ����Ѵ�.
        	alphabetChangeCount += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1); // 1�� ���� �ڷ� ���� ���� Ŀ�� �̵��� 1�� �ؾ��ϱ� ������ ����
        	
        	int indexOfA = i+1;
        	while(indexOfA<name.length() && name.charAt(indexOfA) == 'A') {
        		indexOfA++;
        	}
        	
        	// �������� ���� ���� ������?
        	cursorMovementCount = Math.min(cursorMovementCount, i*2+(name.length()-indexOfA));
        	// �ٽ� ���������� ���� ���� ������?
        	cursorMovementCount = Math.min(cursorMovementCount, i+(name.length()-indexOfA)*2);
        }
        		
        return alphabetChangeCount+cursorMovementCount;
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	String name = "JEROEN";
    	int answerCorrect = 56;
		int answerReturned = -1;
		
		answerReturned = solution.solution(name);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		name = "JAN";
    	answerCorrect = 23;
		answerReturned = -1;
		
		answerReturned = solution.solution(name);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
    }
}