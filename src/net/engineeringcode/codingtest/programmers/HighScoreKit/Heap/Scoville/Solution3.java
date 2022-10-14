package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.Scoville;
import java.util.*;

public class Solution3 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 힙 > 더 맵게
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 우선순위큐를 사용해서 정렬에 필요한 시간을 줄였다.
	 */	
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();
		for(int scovil:scoville) {
			scovilleQueue.offer(scovil);
		}
		
		int mixedCount = 0;
    	while (scovilleQueue.peek() <= K) { // 첫 번째 음식이 K 스코빌 이상이면 모든 음식이 K 스코빌 이상이다.
            if (scovilleQueue.size() == 1) { // 모든 음식이 K 스코빌을 넘지 못 하였다.
                return -1;
            }
            // 음식을 섞자
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
