package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.Scoville;
import java.util.*;

public class Solution2 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 힙 > 더 맵게
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 재귀함수로 음식을 섞어가는 것을 구현하였는데 정확성 테스트는 통과하였으나 효율성 테스트를 통과하지 못 한다.
	 * Solution 대비 불필요한 코드를 많이 제거했는데 정렬하는 것에서 시간이 많이 소요되서 효율성 테스트를 통과하지 못 한다.
	 * 효율성 테스트를 통과한 것은 Solution3에 있다.
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
    	// 오름차순으로 정렬한다.
        Arrays.sort(scoville);    
        //System.out.println(Arrays.toString(scoville));

        if(scoville[mixedCount]>K){ // 첫 번째 음식이 K 스코빌 이상이면 모든 음식이 K 스코빌 이상이다.
        	return;
        }
        
        if(mixedCount == scoville.length-1){ // 모든 음식이 K 스코빌을 넘지 못 하였는가?
        	mixedCount = -1;
        	return;
        }
        
        // 음식을 섞어보자
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
