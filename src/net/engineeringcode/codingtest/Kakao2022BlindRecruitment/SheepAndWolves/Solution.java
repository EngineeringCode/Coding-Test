package net.engineeringcode.codingtest.Kakao2022BlindRecruitment.SheepAndWolves;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 2022 카카오 블라인드 채용 > 양과 늑대
	 * https://programmers.co.kr/learn/courses/30/lessons/92343
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
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
        
        //간선 정보를 리스트에 부모 관계로 가공한다.
        for(int[] edge: edges) {
        	int parent = edge[0];
        	int child = edge[1];     
        	if(childList[parent]==null) { // 메모리에 할당된 적이 없으면 생성한다.
        		childList[parent] = new ArrayList<>();
        	}
        	childList[parent].add(child);
        	// 차일드 노드가 없는 늑대는 양을 가지기 위해 거칠 필요가 없으므로 그래프에서 삭제하면 계산할 양을 줄일 수 있다.
        }
        
        ArrayList<Integer> available = new ArrayList<>();
        available.add(0);
        
        dfs(0, 0, 0, available);
        
        return maximumSheepCount;
    }
    
    void dfs(int currentNode, int sheepCount, int wolfCount, ArrayList<Integer> availableChildList){
    	// 현재 노드가 양인지 늑대인지 확인하고 개수를 증가시킴
    	sheepCount += nodeType[currentNode] ^ 1;
    	wolfCount += nodeType[currentNode];
    	
    	// 현재 양의 수가 가장 큰 경우이면 갱신
    	maximumSheepCount = Math.max(sheepCount, maximumSheepCount);
    	
    	if(sheepCount<=wolfCount) { // 늑대의 수가 양의 수 이상이면
    		return;
    	}
    	
    	/*
    	 *  현재 노드에 자식 노드가 있으면 방문할 자식 노드 목록에 자식 노드 정보를 넣고
    	 *  현재 노드는 방문했으니 자식 노드 목록에서 뺀다.
    	 *  방문할 노드가 있으면 재귀 호출되고 없으면 함수는 종료된다.
    	 *  방문할 노드 목록은 깊은 복사로 추가 생성해서 관리해야 한다. 안 그러면 다음 탐색 경우에서 전에 쓰던 방문할 노드 목록을 참조하기 때문에 원하지 않는 동작이 발생한다.
    	 */
    	
    	// 코딩 1
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
    	
    	//코딩2    	
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
