package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.DualPriorityQueue;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �� > ���߿켱����ť
	 * https://programmers.co.kr/learn/courses/30/lessons/42628
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �־��� ��ɿ� ���� ���� ���� �� �����ϰų� �ִ밪�� �ּҰ��� �����ϴ� ������ �����ϸ� �ȴ�.
	 * �ڹٿ����� LinkedList ����ü�� Ȱ���ϸ� ���� ������ Ǯ �� �ִ�.
	 */
	
    public int[] solution(String[] operations) {
        LinkedList<Integer> queue = new LinkedList();
        for(String operation:operations) {
        	String[] operationCodes = operation.split(" ");
        	//System.out.println("operationCodes[0]:"+operationCodes[0]);
        	//System.out.println("operationCodes[1]:"+operationCodes[1]);
        	switch(operationCodes[0]) {
        	case "I":
        		queue.add(Integer.parseInt(operationCodes[1]));
        		break;
        	case "D":
        		if(operationCodes[1].equals("1")) {
        			queue.pollLast();
        		}else if(operationCodes[1].equals("-1")) {
        			queue.pollFirst();
        		}
        		break;
        	}
        	queue.sort(Comparator.naturalOrder());
        }
        if(queue.size()==0) {
        	return new int[] {0,0};
        }else if(queue.size()==1){
        	return new int[] {queue.peek(),queue.peek()};
        }
    	return new int[] {queue.getLast(),queue.getFirst()};
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	String[] operations = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    	int[] answerCorrect = new int[]{0, 0};
		int[] answerReturned = null;
		
		answerReturned = solution.solution(operations);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		answerCorrect = new int[]{333, -45};
		answerReturned = null;
		
		answerReturned = solution.solution(operations);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
    }
}
