package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Contact;
import java.util.*;

public class Solution3 {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �ؽ� > ��ȭ��ȣ
	 * https://programmers.co.kr/learn/courses/30/lessons/42577
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ������ ������ �����ϴ� �Ϳ� �ð��� ���� �ɷȴ�. ��ȣ�� �߿� �ϳ��� �ٸ� ����� ��ȣ���� �����ϴ� ���� ��찡 ������ false��� ���̴�.
	 * Solution2���� �߻��ϴ� �ؽø� ���ȭ�� �ذ��ϱ� ���� ����̴�.
	 * ��ȭ��ȣ ����� �ؽø����� �����ϰ� �ش� ��ȭ��ȣ�� Ȯ���� �� �ִ� ��� ��� �� �ϳ��� �ؽøʿ� �ִ��� Ȯ���ϵ��� �����Ͽ���. 
	 */
	
    public boolean solution(String[] phone_book) {
    	// ��ȭ��ȣ�� �ؽø����� ����
    	HashMap<String, Boolean> stringList = new HashMap<>();
    	for(int i=0; i<phone_book.length; i++) {
    		stringList.put(phone_book[i], false);
    	}
    	// �ش� ��ȭ��ȣ�� Ȯ���� �� �ִ� ��� ��� �� �ϳ��� �ؽøʿ� �ִ��� Ȯ��
    	for(int i=0; i<phone_book.length; i++) {
    		for(int j=0; j<phone_book[i].length(); j++) {
    			if(stringList.getOrDefault(phone_book[i].substring(0, j), null) != null) {
        			return false;
        		}
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) { 
    	Solution3 solution = new Solution3();
    	
    	String[] phone_book = new String[] {"119", "97674223", "1195524421"};
    	boolean answerCorrect = false;
		boolean answerReturned = true;		
		
		answerReturned = solution.solution(phone_book);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		phone_book = new String[] {"123", "456", "789"};
		answerCorrect = true;
		answerReturned = true;		
		
		answerReturned = solution.solution(phone_book);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
		
		phone_book = new String[] {"12", "123", "1235", "567", "88"};
		answerCorrect = false;
		answerReturned = true;		
		
		answerReturned = solution.solution(phone_book);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}	
	}
    
}
