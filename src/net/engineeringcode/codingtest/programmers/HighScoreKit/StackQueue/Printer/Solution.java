package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.Printer;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 스택/큐 > 프린터
	 * https://programmers.co.kr/learn/courses/30/lessons/42587
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 * 우선순위가 있는 프린터 출력 문제를 해결하기 위해 우선순위 큐를 구현하여 해결하였다.
	 * 자바에서 기본적으로 구현되어 있는 우선순위 큐는 문제에서 말하는 우선순위랑 다를 수도 있기에
	 * 큐를 LinkedList 형태로 생성하고 우선순위를 처리하는 기능을 구현하였다.
	 */
	public int solution(int[] priorities, int location) {
		int answer = 0;
		LinkedList<Document> list = new LinkedList<>();
		
		// 출력할 목록을 큐에 넣는다.
        for(int i=0; i<priorities.length; i++) {
        	if(i == location) {
        		list.add(new Document(priorities[i], true));
        	} else {
        		list.add(new Document(priorities[i], false));
        	}
        	//System.out.print(list.get(i).priority+" ");
        }        
    	//System.out.println();
        
        // 출력할 목록을 문제에서 제시한 우선순위에 따른 출력 방법으로 처리한다.
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
	
	// 우선 순위가 더 높은 문서가 목록(프린터 큐)에 있는지 확인한다.
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
