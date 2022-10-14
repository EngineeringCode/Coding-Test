package net.engineeringcode.codingtest.programmers.HighScoreKit.DynamicProgramming.N;
import java.util.*;

public class Solution2 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 동적계획법(Dynamic Programming) > N으로 표현
	 * https://programmers.co.kr/learn/courses/30/lessons/42895
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 해설: https://gurumee92.tistory.com/164
	 * '구르미'님이 작성하신 해설을 참고했습니다.
	 */
	
    public int solution(int N, int number) {    	
        int answer = -1;
        
        ArrayList<Set<Integer>> sets = new ArrayList<>();
        for(int i=0; i<9; i++) {
        	sets.add(new HashSet<>());
        }
        
        int index = 1;        
        for (Set<Integer> s: sets) {
            s.add(getBasicNumber(N, index));
            index += 1;
        }

        for(int i=0; i<8; i++) {        	
        	for(int j=0; j<i; j++) {        		
        		for(int op1: sets.get(j)) {
        			for(int op2: sets.get(i-j-1)) {
        				sets.get(i).add(op1 + op2);
        				sets.get(i).add(op1 - op2);
        				sets.get(i).add(op1 * op2);
        				
        				if(op2 != 0) {
        					sets.get(i).add(op1/op2);
        				}
        			}
        		}
        	}
        	if(sets.get(i).contains(number)) {
    			answer = i+1;
        		break;
        	}
        }
        
        return answer;
    }
          
    int getBasicNumber(int N, int count) {
        int result = 0;
        
        while (count > 0) {
        	count -= 1;
            result += N * Math.pow(10, count);
        }
        
        return result;
    }
    
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
    	int N = 5;
    	int number = 12;
    	int answerCorrect = 4;
    	int answerReturned = -9999;
		
		answerReturned = solution.solution(N, number);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
    	N = 5;
    	number = 31168;
    	answerCorrect = -1;
    	answerReturned = -9999;
		
		answerReturned = solution.solution(N, number);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
    }
}