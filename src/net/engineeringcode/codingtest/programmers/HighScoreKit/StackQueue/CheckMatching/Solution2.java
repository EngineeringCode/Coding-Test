package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.CheckMatching;
import java.util.*;

public class Solution2 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 스택/큐 > 올바른 괄호
	 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 효율성 테스트를 통과하기 위해 사용하는 공간과 자료형을 간소화 하였다.
	 */
	
	boolean solution(String s) {
        int cnt = 0;
        
        for(int i=0; i<s.length(); i++){
            String tmp = s.substring(i, i+1);
            switch(tmp){
                case "(":
                    cnt++;
                    break;
                case ")":
                    cnt--;
                    break;
            }
            if(cnt<0){
                break;
            }
        }

        if(cnt == 0){
            return true;
        }

        return false;
    }
    
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
    	String s = "()()";
		boolean answerCorrect = true;
		boolean answerReturned = false;
		
		answerReturned = solution.solution(s);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		s = "(())()";
		answerCorrect = true;
		answerReturned = false;
		
		answerReturned = solution.solution(s);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		s = ")()(";
		answerCorrect = false;
		answerReturned = false;
		
		answerReturned = solution.solution(s);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
		
		s = ")()(";
		answerCorrect = false;
		answerReturned = false;
		
		answerReturned = solution.solution(s);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 4 PASS");
		}else {
			System.out.println("CASE 4 FAIL");
		}
	}
    
}
