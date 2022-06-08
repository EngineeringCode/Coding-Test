package net.engineeringcode.codingtest.Kakao2022BlindRecruitment.SheepAndWolves;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > 2022 īī�� ����ε� ä�� > ��� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/92343
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * 
	 */
	int totalNodeCount;
	int maximumSheepCount;
    ArrayList<Integer>[] childList;
    int[] nodeType;
    
    public int solution(int[] info, int[][] edges) {
        totalNodeCount = info.length;
        maximumSheepCount = -1;
        childList = new ArrayList[info.length];
        nodeType = info;
        
        //���� ������ ����Ʈ�� �θ� ����� �����Ѵ�.
        for(int[] edge: edges) {
        	int parent = edge[0];
        	int child = edge[1];     
        	if(childList[parent]==null) { // �޸𸮿� �Ҵ�� ���� ������ �����Ѵ�.
        		childList[parent] = new ArrayList<>();
        	}
        	childList[parent].add(child);
        	// ���ϵ� ��尡 ���� ����� ���� ������ ���� ��ĥ �ʿ䰡 �����Ƿ� �׷������� �����ϸ� ����� ���� ���� �� �ִ�.
        }
        
        ArrayList<Integer> available = new ArrayList<>();
        available.add(0);
        
        dfs(0, 0, 0, available);
        
        return maximumSheepCount;
    }
    
    void dfs(int currentNode, int sheepCount, int wolfCount, ArrayList<Integer> availableChildList){
    	// ���� ��尡 ������ �������� Ȯ���ϰ� ������ ������Ŵ
    	sheepCount += nodeType[currentNode] ^ 1;
    	wolfCount += nodeType[currentNode];
    	
    	// ���� ���� ���� ���� ū ����̸� ����
    	maximumSheepCount = Math.max(sheepCount, maximumSheepCount);
    	
    	if(sheepCount<=wolfCount) { // ������ ���� ���� �� �̻��̸�
    		return;
    	}
    	
    	/*
    	 *  ���� ��忡 �ڽ� ��尡 ������ �湮�� �ڽ� ��� ��Ͽ� �ڽ� ��� ������ �ְ�
    	 *  ���� ���� �湮������ �ڽ� ��� ��Ͽ��� ����.
    	 *  �湮�� ��尡 ������ ��� ȣ��ǰ� ������ �Լ��� ����ȴ�.
    	 *  �湮�� ��� ����� ���� ����� �߰� �����ؼ� �����ؾ� �Ѵ�. �� �׷��� ���� Ž�� ��쿡�� ���� ���� �湮�� ��� ����� �����ϱ� ������ ������ �ʴ� ������ �߻��Ѵ�.
    	 */
    	
    	// �ڵ� 1
    	/*
    	ArrayList<Integer> currentAvailableChildList = new ArrayList<>();
    	currentAvailableChildList.addAll(availableChildList);

        if(childList[currentNode]!=null) {
        	currentAvailableChildList.addAll(childList[currentNode]);
        }
        currentAvailableChildList.remove(Integer.valueOf(currentNode));

    	for(int child: currentAvailableChildList) {
    		dfs(child, sheepCount, wolfCount, currentAvailableChildList);
    	}
    	*/
    	
    	//�ڵ�2    	
        if(childList[currentNode]!=null) {
        	availableChildList.addAll(childList[currentNode]);
        }
        availableChildList.remove(Integer.valueOf(currentNode));
    	
        
    	for(int child: availableChildList) {
    		dfs(child, sheepCount, wolfCount, (ArrayList<Integer>) availableChildList.clone());
    	}
    
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
		int[] info = new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
		int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
		int answerCorrect = 5;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(info, edges);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		info = new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
		edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}};
		answerCorrect = 5;
		answerReturned = -1;
		
		answerReturned = solution.solution(info, edges);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
	}
    
}
