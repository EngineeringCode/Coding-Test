package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.CheckMatching;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 스택/큐 > 올바른 괄호
	 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 이 경우 정확성 테스트는 통과하나 효율성 테스트를 통과하지 못 한다. Solution2에 효율성 테스트를 통과한 답이 있다.
	 */
	
	boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        
        String[] array = s.split("");
        for(int i=0; i<array.length; i++){
            switch(array[i]){
                case "(":
                    stack.push(array[i]);
                    break;
                case ")":
                    if(stack.size() == 0){
                        return false;
                    }
                    stack.pop();
            }
        }

        if(stack.size() != 0){
            return false;
        }

        return true;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
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
