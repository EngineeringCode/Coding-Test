package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.Scoville;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �� > �� �ʰ�
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ����Լ��� ������ ����� ���� �����Ͽ��µ� ��Ȯ�� �׽�Ʈ�� ����Ͽ����� ȿ���� �׽�Ʈ�� ������� �� �Ѵ�.
	 * ȿ���� �׽�Ʈ�� ����� ���� Solution3�� �ִ�.
	 */
	
	public int solution(int[] scoville, int K) {
        return cook(scoville, K, 0);
    }
    
    int cook(int[] scoville, int K, int mixedCount){
    	// ������������ �����Ѵ�.
        Arrays.sort(scoville);        
        //System.out.println(Arrays.toString(scoville));

        if(isOkay(scoville, K)){ // ��� ������ K ���ں� �̻��ΰ�?
            return mixedCount;
        }
        
        if(scoville.length == 1){ // ��� ������ K ���ں��� ���� �� �Ͽ��°�?
            return -1;
        }
        
        // ������ �����
        int[] newScoville = new int[scoville.length-1];
        for(int i=1; i<scoville.length; i++){
            if(i==1){
                newScoville[i-1] = scoville[i-1]+scoville[i]*2;
                continue;
            }
            newScoville[i-1] = scoville[i];
        }
        
        return cook(newScoville, K, mixedCount+1);
    }
    
    boolean isOkay(int[] scoville, int K){
        for(int hotScore:scoville){
            if(hotScore<K){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
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
