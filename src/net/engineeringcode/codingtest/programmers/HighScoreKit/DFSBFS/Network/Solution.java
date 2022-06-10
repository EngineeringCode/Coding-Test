package net.engineeringcode.codingtest.programmers.HighScoreKit.DFSBFS.Network;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ����/�ʺ� �켱 Ž��(DFS/BFS) > ��Ʈ��ũ
	 * https://programmers.co.kr/learn/courses/30/lessons/43162
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �����ϴ� ��ġ�� �ٲ㰡�� ����� ������ ���� ��ǻ�͸� �湮�ϰ� �����ϴ� ��ġ�� ��ǻ�Ͱ� ��볪 �湮���� �ʾҴ� ��ǻ�������� ���� ��ǻ�� ��Ʈ��ũ�� ���� ��������.
	 * computers[][] �迭�� ���� �� BFS(Breadth-First Search) �ϱ� ���� �����.
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