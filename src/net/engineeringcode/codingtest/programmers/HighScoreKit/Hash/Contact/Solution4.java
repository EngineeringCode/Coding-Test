package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Contact;
import java.util.*;

public class Solution4 {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �ؽ� > ��ȭ��ȣ
	 * https://programmers.co.kr/learn/courses/30/lessons/42577
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ������ ������ �����ϴ� �Ϳ� �ð��� ���� �ɷȴ�. ��ȣ�� �߿� �ϳ��� �ٸ� ����� ��ȣ���� �����ϴ� ���� ��찡 ������ false��� ���̴�.
	 * '��ȣ���� �����ϴ�'�� �̿��ϸ� ���ķ� �ذ��� �� �ִ�. �ؽ÷� �����ϴ� �� ��� �޸𸮸� ������ �� �ִ�.
	 */
	
    public boolean solution(String[] phone_book) {
    	// ������������ ��ȭ��ȣ �迭�� ����
    	Arrays.sort(phone_book);
    	// �ش� �ε����� ���� �ε����� �ش� �ε����� ��(��ȭ��ȣ)���� �����ϴ��� Ȯ��
    	for(int i=0; i<phone_book.length-1; i++) {
    		if(phone_book[i+1].startsWith(phone_book[i])) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) { 
    	Solution4 solution = new Solution4();
    	
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
