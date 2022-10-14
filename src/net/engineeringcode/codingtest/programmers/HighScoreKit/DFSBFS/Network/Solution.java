package net.engineeringcode.codingtest.programmers.HighScoreKit.DFSBFS.Network;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 네트워크
	 * https://programmers.co.kr/learn/courses/30/lessons/43162
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 시작하는 위치를 바꿔가며 연결된 간선을 따라 컴퓨터를 방문하고 시작하는 위치의 컴퓨터가 몇대나 방문하지 않았던 컴퓨터인지를 세면 컴퓨터 네트워크의 수가 세어진다.
	 * computers[][] 배열을 보면 딱 BFS(Breadth-First Search) 하기 좋게 생겼다.
	 */
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited[] = new boolean[n];
        
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				bfs(i, computers, visited);
				answer++;
			}
		}
        
        return answer;
    }
    
    boolean[] bfs(int i, int[][] computers, boolean visited[]) {
        visited[i] = true;

		for (int j=0; j<computers.length; j++) {
			if (i != j && computers[i][j] == 1 && visited[j] == false) {
				visited = bfs(j, computers, visited);
			}
		}
		return visited;
	}
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int n = 3;
    	int[][] computers = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    	
    	int answerCorrect = 2;
    	int answerReturned = -1;
    	
		answerReturned = solution.solution(n, computers);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
    	n = 3;
    	computers = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
    	
    	answerCorrect = 1;
    	answerReturned = -1;
    	
		answerReturned = solution.solution(n, computers);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
    }
}