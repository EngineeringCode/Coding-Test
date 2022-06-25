package net.engineeringcode.codingtest.programmers.HighScoreKit.Graph.FarthestNode;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �׷��� > ���� �� ���
	 * https://programmers.co.kr/learn/courses/30/lessons/49189
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ��Ʈ ��忡�� ���� �� ����� ������ ���ϴ� ���� BFS�� �����ϴ�.
	 */
	
	public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
        boolean visited[] = new boolean[n+1];
        // ����Ʈ �ʱ�ȭ
        for(int i=0; i<=n; i++) {
        	edgeList.add(new ArrayList<>());
        }
        // edgeList�� edge ������ �Է�
        for(int i=0; i<edge.length; i++) {
        	edgeList.get(edge[i][0]).add(edge[i][1]);
        	edgeList.get(edge[i][1]).add(edge[i][0]);
        }
        // queue���� ���� depth�� ��� ����� ��´�.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // Ž���� ������ ��带 1�� ���� �Ѵ�.
        visited[1] = true; // Ž���� ������ ��带 �湮ó���Ѵ�.
        
        int queueSize = 0; // ���� depth�� ����� ����
        int currentNode; // Ž�� ���� ���
        
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