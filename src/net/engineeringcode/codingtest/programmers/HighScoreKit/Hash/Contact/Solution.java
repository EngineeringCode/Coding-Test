package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.Contact;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �ؽ� > ��ȭ��ȣ
	 * https://programmers.co.kr/learn/courses/30/lessons/42577
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ������ ������ �����ϴ� �Ϳ� �ð��� ���� �ɷȴ�. ��ȣ�� �߿� �ϳ��� �ٸ� ����� ��ȣ���� �����ϴ� ���� ��찡 ������ false��� ���̴�.
	 * �ܼ��ϰ� �迭�� �ϳ��� ��ȸ�ϸ鼭 ��� ��츦 ����ϸ� ��Ȯ�� �׽�Ʈ�� ��������� ȿ���� �׽�Ʈ�� ������� �� �Ѵ�.
	 * ȿ�����׽�Ʈ�� �ؽø� ����ؼ� ����� ���� Solution2�� �ִ�.
	 */
	
    public boolean solution(String[] phone_book) {
    	for(int i=0; i<phone_book.length; i++) {
    		for(int j=0;j<phone_book.length; j++) {
    			if(j==i) {
    				continue;
    			}
    			//if(phone_book[j].indexOf(phone_book[i])==0) {
    			if(phone_book[j].startsWith(phone_book[i])==true) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
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
