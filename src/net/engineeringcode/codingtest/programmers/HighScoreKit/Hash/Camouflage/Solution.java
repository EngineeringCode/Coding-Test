package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Camouflage;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 해시 > 위장
	 * https://programmers.co.kr/learn/courses/30/lessons/42578
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 한 개 이상의 옷을 입어야 하고 같은 분류의 옷은 최대 한 개만 입을 수 있는 경우 입을 수 있는 옷의 경우의 수를 구하는 문제이다.
	 */
	
	public int solution(String[][] clothes) {		
		// 분류별로 옷의 갯수를 저장한다.
		HashMap<String, Integer> clotheList = new HashMap<>();		
		for(String[] clothe:clothes) {
			String categroy = clothe[1];
			
			int clotheCount = clotheList.getOrDefault(categroy, -1);
			if(clotheCount == -1) {
				clotheList.put(categroy, 1);
			}else {
				clotheList.put(categroy, clotheCount+1);
			}
		}
		
		// 옷을 입는 전체 조합의 수를 구한다.
        int answer = 1;        
        for(String category:clotheList.keySet()) {
        	int clotheCount = clotheList.get(category);
        	answer *= combination(clotheCount+1, 1);
        }       
        
        // 아무것도 입지 않는 수가 하나 있으므로 뺀다.
        return answer-1;
    }
	
	int combination(int totalCount, int selectCount) {
		if(totalCount == selectCount || selectCount == 0) {
			return 1;
		}
		
		return combination(totalCount-1, selectCount-1) + combination(totalCount-1, selectCount);
	}
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	String[][] clothes = new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    	int answerCorrect = 5;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(clothes);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		clothes = new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
    	answerCorrect = 3;
		answerReturned = -1;		
		
		answerReturned = solution.solution(clothes);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}	
		
		// 내가 추가한 테스트 케이스
		clothes = new String[][] {{"crow_mask", "face"}, {"yellow_hat", "headgear"}};
    	answerCorrect =  3;
		answerReturned = -1;		
		
		answerReturned = solution.solution(clothes);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
		
		// 내가 추가한 테스트 케이스
		clothes = new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"blue_hat", "headgear"}, {"yellow_hat", "headgear"}};
    	answerCorrect = 8;
		answerReturned = -1;		
		
		answerReturned = solution.solution(clothes);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 4 PASS");
		}else {
			System.out.println("CASE 4 FAIL");
		}
	}
}
