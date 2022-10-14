package net.engineeringcode.codingtest.Kakao2022BlindRecruitment.Building;

public class Solution {
	/*
	 * 프로그래머스 > 2022 카카오 블라인드 채용 > 파괴되지 않은 건물
	 * https://programmers.co.kr/learn/courses/30/lessons/92344
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 정확성 테스트는 통과하지만 효율성 테스트를 통과하지 못 한다. O(N+M+K) 이기 때문
	 */
    
    public int solution(int[][] board, int[][] skill) {
    	
    	// 스킬을 순서대로 실행한다.
    	for(int[] action:skill) {
    		int type = 1; // 방어(치료)
    		if(action[0]==1){ // 공격
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
    	
    	// 안 부서진 건물의 수를 센다.
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
