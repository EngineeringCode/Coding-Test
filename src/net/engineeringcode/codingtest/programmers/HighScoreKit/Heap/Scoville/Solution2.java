package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.Scoville;
import java.util.*;

public class Solution2 {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �� > �� �ʰ�
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ����Լ��� ������ ����� ���� �����Ͽ��µ� ��Ȯ�� �׽�Ʈ�� ����Ͽ����� ȿ���� �׽�Ʈ�� ������� �� �Ѵ�.
	 * Solution ��� ���ʿ��� �ڵ带 ���� �����ߴµ� �����ϴ� �Ϳ��� �ð��� ���� �ҿ�Ǽ� ȿ���� �׽�Ʈ�� ������� �� �Ѵ�.
	 * ȿ���� �׽�Ʈ�� ����� ���� Solution3�� �ִ�.
	 */
	
	int[] scoville = null;
	int K = -1;
	int mixedCount = 0;
	
	public int solution(int[] scoville, int K) {
		this.scoville = scoville;
		this.K = K;
		cook();
        return mixedCount;
    }
    
    void cook(){    	
    	// ������������ �����Ѵ�.
        Arrays.sort(scoville);    
        //System.out.println(Arrays.toString(scoville));

        if(scoville[mixedCount]>K){ // ù ��° ������ K ���ں� �̻��̸� ��� ������ K ���ں� �̻��̴�.
        	return;
        }
        
        if(mixedCount == scoville.length-1){ // ��� ������ K ���ں��� ���� �� �Ͽ��°�?
        	mixedCount = -1;
        	return;
        }
        
        // ������ �����
    	scoville[mixedCount+1] = scoville[mixedCount]+scoville[mixedCount+1]*2;
    	scoville[mixedCount] = -1;
        
    	mixedCount++;
        cook();
    }
    
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
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
