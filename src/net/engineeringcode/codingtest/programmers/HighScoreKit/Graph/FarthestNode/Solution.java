package net.engineeringcode.codingtest.programmers.HighScoreKit.Graph.FarthestNode;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 그래프 > 가장 먼 노드
	 * https://programmers.co.kr/learn/courses/30/lessons/49189
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 루트 노드에서 가장 먼 노드의 개수를 구하는 것은 BFS가 적절하다.
	 */
	
	public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
        boolean visited[] = new boolean[n+1];
        // 리스트 초기화
        for(int i=0; i<=n; i++) {
        	edgeList.add(new ArrayList<>());
        }
        // edgeList에 edge 정보를 입력
        for(int i=0; i<edge.length; i++) {
        	edgeList.get(edge[i][0]).add(edge[i][1]);
        	edgeList.get(edge[i][1]).add(edge[i][0]);
        }
        // queue에는 현재 depth의 노드 목록을 담는다.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 탐색을 시작할 노드를 1번 노드로 한다.
        visited[1] = true; // 탐색을 시작할 노드를 방문처리한다.
        
        int queueSize = 0; // 현재 depth의 노드의 개수
        int currentNode; // 탐색 중인 노드
        
        while(!queue.isEmpty()){
        	queueSize= queue.size();
            for(int i=0; i<queueSize; i++){
            	currentNode = queue.poll();
                for(int j=0; j<edgeList.get(currentNode).size(); j++){
                    if(visited[edgeList.get(currentNode).get(j)]==false){
                        visited[edgeList.get(currentNode).get(j)]=true;
                        queue.offer(edgeList.get(currentNode).get(j));
                    }
                }
            }
            answer=queueSize;
        }
        
        return answer;
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int n = 6;
    	int[][] edge = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

    	int answerCorrect = 3;
		int answerReturned = -1;
		
		answerReturned = solution.solution(n, edge);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
    }
}