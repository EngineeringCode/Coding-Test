package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.Scoville;
import java.util.*;

public class Solution3 {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �� > �� �ʰ�
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �켱����ť�� ����ؼ� ���Ŀ� �ʿ��� �ð��� �ٿ���.
	 */	
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();
		for(int scovil:scoville) {
			scovilleQueue.offer(scovil);
		}
		
		int mixedCount = 0;
    	while (scovilleQueue.peek() <= K) { // ù ��° ������ K ���ں� �̻��̸� ��� ������ K ���ں� �̻��̴�.
            if (scovilleQueue.size() == 1) { // ��� ������ K ���ں��� ���� �� �Ͽ���.
                return -1;
            }
            // ������ ����
            int scovilleOne = scovilleQueue.poll();
            int scovilleTwo = scovilleQueue.poll();            
            scovilleQueue.offer(scovilleOne+(scovilleTwo*2));
            mixedCount++;
        }
		
        return mixedCount;
    }

    public static void main(String[] args) { 
    	Solution3 solution = new Solution3();
    	
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
