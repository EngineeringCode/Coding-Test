package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Camouflage;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �ؽ� > ����
	 * https://programmers.co.kr/learn/courses/30/lessons/42578
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �� �� �̻��� ���� �Ծ�� �ϰ� ���� �з��� ���� �ִ� �� ���� ���� �� �ִ� ��� ���� �� �ִ� ���� ����� ���� ���ϴ� �����̴�.
	 */
	
	public int solution(String[][] clothes) {		
		// �з����� ���� ������ �����Ѵ�.
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
		
		// ���� �Դ� ��ü ������ ���� ���Ѵ�.
        int answer = 1;        
        for(String category:clotheList.keySet()) {
        	int clotheCount = clotheList.get(category);
        	answer *= combination(clotheCount+1, 1);
        }       
        
        // �ƹ��͵� ���� �ʴ� ���� �ϳ� �����Ƿ� ����.
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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
