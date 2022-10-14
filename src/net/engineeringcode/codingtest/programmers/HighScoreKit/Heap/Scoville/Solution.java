package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.Scoville;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 힙 > 더 맵게
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 재귀함수로 음식을 섞어가는 것을 구현하였는데 정확성 테스트는 통과하였으나 효율성 테스트를 통과하지 못 한다.
	 * 효율성 테스트를 통과한 것은 Solution3에 있다.
	 */
	
	public int solution(int[] scoville, int K) {
        return cook(scoville, K, 0);
    }
    
    int cook(int[] scoville, int K, int mixedCount){
    	// 오름차순으로 정렬한다.
        Arrays.sort(scoville);        
        //System.out.println(Arrays.toString(scoville));

        if(isOkay(scoville, K)){ // 모든 음식이 K 스코빌 이상인가?
            return mixedCount;
        }
        
        if(scoville.length == 1){ // 모든 음식이 K 스코빌을 넘지 못 하였는가?
            return -1;
        }
        
        // 음식을 섞어보자
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
