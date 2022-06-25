package net.engineeringcode.codingtest.programmers.HighScoreKit.Graph.Rank;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 그래프 > 가장 먼 노드
	 * https://programmers.co.kr/learn/courses/30/lessons/49191
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 해설 : https://easybrother0103.tistory.com/131
	 * '쉬운형'님의 해설을 참고하였습니다. 플루이드-워셜 알고리즘을 적용하였습니다.
	 */
	
	public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] map = new int[n+1][n+1];
        
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map.length; j++) {
            	map[i][j] = 10000;
            }
        }
        
		for (int i=0; i<results.length; i++) {
			map[results[i][0]][results[i][1]] = 1;
		}
        

        for (int k=1; k<map.length; k++) {
            for (int i=1; i<map.length; i++) {
                for (int j=1; j<map.length; j++) {
                	if (map[i][j] > map[i][k] + map[k][j]) {
                		map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        
        for (int i=1; i<map.length; i++) {
            int count = 0;            
            for (int j=1; j<map.length; j++) {
                if (map[i][j] < 10000 || map[j][i] < 10000) {
                    count++;
                }
            }
            if (count==n-1) {
            	answer++;
            }
        }
        
        return answer;
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int n = 5;
    	int[][] results = new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

    	int answerCorrect = 2;
		int answerReturned = -1;
		
		answerReturned = solution.solution(n, results);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
    }
}