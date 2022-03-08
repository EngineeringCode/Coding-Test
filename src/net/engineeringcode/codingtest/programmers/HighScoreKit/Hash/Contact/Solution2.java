package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Contact;
import java.util.*;

public class Solution2 {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �ؽ� > ��ȭ��ȣ
	 * https://programmers.co.kr/learn/courses/30/lessons/42577
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ������ ������ �����ϴ� �Ϳ� �ð��� ���� �ɷȴ�. ��ȣ�� �߿� �ϳ��� �ٸ� ����� ��ȣ���� �����ϴ� ���� ��찡 ������ false��� ���̴�.
	 * ��ȭ��ȣ�� ��� ��츦 �ؽøʿ� �־ Ǯ���µ� �̷��� �ؽø��� ��������� ������ �ִ�.
	 * �̸� �ذ��� ����� Solution3�� �ִ�.
	 */
	
    public boolean solution(String[] phone_book) {
    	// ��ȭ��ȣ�� ��� ��츦 �ؽø����� ����
    	HashMap<String, Boolean> stringList = new HashMap<>();
    	for(int i=0; i<phone_book.length; i++) {
    		for(int j=0;j<phone_book[i].length(); j++) {
    			stringList.put(phone_book[i].substring(0, j), false);
    		}
    	}
    	// �ش� ��ȭ��ȣ�� �����ϴ� ��ȭ��ȣ�� �ִ��� Ȯ��
    	for(int i=0; i<phone_book.length; i++) {
    		if(stringList.getOrDefault(phone_book[i], null) != null) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
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
