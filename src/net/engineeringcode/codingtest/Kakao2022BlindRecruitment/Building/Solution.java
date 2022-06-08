package net.engineeringcode.codingtest.Kakao2022BlindRecruitment.Building;

public class Solution {
	/*
	 * ���α׷��ӽ� > 2022 īī�� ����ε� ä�� > �ı����� ���� �ǹ�
	 * https://programmers.co.kr/learn/courses/30/lessons/92344
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ��Ȯ�� �׽�Ʈ�� ��������� ȿ���� �׽�Ʈ�� ������� �� �Ѵ�. O(N+M+K) �̱� ����
	 */
    
    public int solution(int[][] board, int[][] skill) {
    	
    	// ��ų�� ������� �����Ѵ�.
    	for(int[] action:skill) {
    		int type = 1; // ���(ġ��)
    		if(action[0]==1){ // ����
    			type = -1;
    		}
    		int r1 = action[1];
    		int c1 = action[2];
    		int r2 = action[3];
    		int c2 = action[4];
    		int degree = action[5];
    		
    		for(int i=r1;i<=r2;i++) {
    			for(int j=c1;j<=c2;j++) {
    				board[i][j] += type*degree;
    			}
    		}
    	}
    	
    	int answer = 0;
    	
    	// �� �μ��� �ǹ��� ���� ����.
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j] > 0) {
					answer++;
				}
			}
		}
        
        return answer;
    }
    
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
		int[][] board = new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
		int[][] skill = new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
		int answerCorrect = 10;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(board, skill);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		board = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		skill = new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};
		answerCorrect = 6;
		answerReturned = -1;
		
		answerReturned = solution.solution(board, skill);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
	}
    
}
