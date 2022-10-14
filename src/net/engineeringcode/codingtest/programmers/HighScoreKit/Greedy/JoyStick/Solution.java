package net.engineeringcode.codingtest.programmers.HighScoreKit.Greedy.JoyStick;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 탐욕법(Greedy) > 조이스틱
	 * https://programmers.co.kr/learn/courses/30/lessons/42860
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 */
	
	public int solution(String name) {
        int alphabetChangeCount = 0;
        int cursorMovementCount = name.length()-1;
        
        for(int i=0;i<name.length();i++) {
        	// 다음 알파벳으로 가는 경우와 이전 알파벳으로 가는 경우 중에 뭐가 더 빠른지를 계산한다.
        	alphabetChangeCount += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1); // 1은 제일 뒤로 가기 위한 커서 이동을 1번 해야하기 때문에 존재
        	
        	int indexOfA = i+1;
        	while(indexOfA<name.length() && name.charAt(indexOfA) == 'A') {
        		indexOfA++;
        	}
        	
        	// 왼쪽으로 가는 것이 빠른가?
        	cursorMovementCount = Math.min(cursorMovementCount, i*2+(name.length()-indexOfA));
        	// 다시 오른쪽으로 가는 것이 빠른가?
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