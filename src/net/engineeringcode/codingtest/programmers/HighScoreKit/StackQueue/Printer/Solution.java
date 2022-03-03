package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.Printer;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ����/ť > ������
	 * https://programmers.co.kr/learn/courses/30/lessons/42587
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * 
	 * �켱������ �ִ� ������ ��� ������ �ذ��ϱ� ���� �켱���� ť�� �����Ͽ� �ذ��Ͽ���.
	 * �ڹٿ��� �⺻������ �����Ǿ� �ִ� �켱���� ť�� �������� ���ϴ� �켱������ �ٸ� ���� �ֱ⿡
	 * ť�� LinkedList ���·� �����ϰ� �켱������ ó���ϴ� ����� �����Ͽ���.
	 */
	public int solution(int[] priorities, int location) {
		int answer = 0;
		LinkedList<Document> list = new LinkedList<>();
		
		// ����� ����� ť�� �ִ´�.
        for(int i=0; i<priorities.length; i++) {
        	if(i == location) {
        		list.add(new Document(priorities[i], true));
        	} else {
        		list.add(new Document(priorities[i], false));
        	}
        	//System.out.print(list.get(i).priority+" ");
        }        
    	//System.out.println();
        
        // ����� ����� �������� ������ �켱������ ���� ��� ������� ó���Ѵ�.
        for(;!list.isEmpty();) {
        	//Document document = list.poll();
        	Document document = list.pollFirst();
        	//Document document = list.removeFirst();
        	
        	if(isExistHigherPriority(document, list)) {
    			//list.add(document);
    			list.addLast(document);
        		continue;
        	}
        	
        	answer++;
        	if(document.isMine==true) {
        		break;
        	}
        }
        return answer;
    }
	
	// �켱 ������ �� ���� ������ ���(������ ť)�� �ִ��� Ȯ���Ѵ�.
	boolean isExistHigherPriority(Document document, LinkedList<Document> list) {
    	for(int i=0;i<list.size();i++) {
    		if(document.priority < list.get(i).priority) {
    			return true;
    		}
    	}
		return false;
	}
	
	class Document{
		public int priority;
		public boolean isMine;
		Document(int priority, boolean isMine){
			this.priority = priority;
			this.isMine = isMine;
		}
	}
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] priorities = new int[]{2, 1, 3, 2};
    	int location = 2;
		int answerCorrect = 1;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(priorities, location);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		priorities = new int[]{1, 1, 9, 1, 1, 1};
    	location = 0;
		answerCorrect = 5;
		answerReturned = -1;		
		
		answerReturned = solution.solution(priorities, location);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
	}
    
}
