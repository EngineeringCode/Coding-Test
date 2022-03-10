package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.Scoville;
import java.util.*;

public class Solution4 {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �� > �� �ʰ�
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * Solution3ó�� �켱����ť�� ��������� ����Լ��� Ǯ����.
	 * ����Լ� ���� ������ �����Ƿ� ȿ���� �׽�Ʈ�� ������� �� �Ѵ�.
	 */	
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();
		for(int scovil:scoville) {
			scovilleQueue.offer(scovil);
		}
        return cook(scovilleQueue, K, 0);
    }
    
    int cook(PriorityQueue<Integer> scovilleQueue, int K, int mixedCount){    	
        if(scovilleQueue.peek() >= K){ // ù ��° ������ K ���ں� �̻��̸� ��� ������ K ���ں� �̻��̴�.
        	return mixedCount;
        }
        
    	if(scovilleQueue.size() == 1){ // ��� ������ K ���ں��� ���� �� �Ͽ��°�?
        	return -1;
        }
        
        // ������ �����
        int scovilleOne = scovilleQueue.poll();
        int scovilleTwo = scovilleQueue.poll();        
        scovilleQueue.offer(scovilleOne+scovilleTwo*2);
        
        return cook(scovilleQueue, K, mixedCount+1);
    }
    
    public static void main(String[] args) { 
    	Solution4 solution = new Solution4();
    	
    	int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
    	int K = 7;
    	int answerCorrect = 2;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(scoville, K);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
	}
}
