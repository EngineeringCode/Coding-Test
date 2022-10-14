package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.Scoville;
import java.util.*;

public class Solution4 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 힙 > 더 맵게
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * Solution3처럼 우선순위큐를 사용했지만 재귀함수로 풀었다.
	 * 재귀함수 깊이 제약이 있으므로 효율성 테스트를 통과하지 못 한다.
	 */	
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();
		for(int scovil:scoville) {
			scovilleQueue.offer(scovil);
		}
        return cook(scovilleQueue, K, 0);
    }
    
    int cook(PriorityQueue<Integer> scovilleQueue, int K, int mixedCount){    	
        if(scovilleQueue.peek() >= K){ // 첫 번째 음식이 K 스코빌 이상이면 모든 음식이 K 스코빌 이상이다.
        	return mixedCount;
        }
        
    	if(scovilleQueue.size() == 1){ // 모든 음식이 K 스코빌을 넘지 못 하였는가?
        	return -1;
        }
        
        // 음식을 섞어보자
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
