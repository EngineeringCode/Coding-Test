package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Pokemon;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 해시 > 포켓몬
	 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 */
	
	public int solution(int[] nums) {
		// N/2마리를 선택할 수 있다.
		int maximumAnswer = nums.length/2;
		// 포켓몬 종류와 개체 수를 담을 해시맵 생성
        HashMap<Integer, Integer> pokemonMap = new HashMap<>();
        // 포켓몬 종류와 개체 수를 센다
        for(int i=0; i<nums.length; i++){
            pokemonMap.put(nums[i], ((int)pokemonMap.getOrDefault(nums[i], 0))+1);
        }       
        // 포켓몬의 종류의 개수가 N/2가 넘으면 N/2만 선택할 수 있으므로 가질 수 있는 최대 포켓몬의 종류는 N/2이다.
        if(pokemonMap.size() > maximumAnswer){
            return maximumAnswer;
        }
        // 포켓몬 종류 개수를 반환한다.              
        return pokemonMap.size();
    }
	
	int combination(int totalCount, int selectCount) {
		if(totalCount == selectCount || selectCount == 0) {
			return 1;
		}
		
		return combination(totalCount-1, selectCount-1) + combination(totalCount-1, selectCount);
	}
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] nums = new int[] {3, 1, 2, 3};
    	int answerCorrect = 2;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(nums);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		nums = new int[] {3, 3, 3, 2, 2, 4};
    	answerCorrect = 3;
		answerReturned = -1;		
		
		answerReturned = solution.solution(nums);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}	
		
		nums = new int[] {3, 3, 3, 2, 2, 2};
    	answerCorrect =  2;
		answerReturned = -1;		
		
		answerReturned = solution.solution(nums);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
	}
}
