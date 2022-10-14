package net.engineeringcode.codingtest.Kakao2022BlindRecruitment.game;

public class Solution {
	/* 프로그래머스 > 코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT > 사라지는 발판
	 * 풀러가기: https://programmers.co.kr/learn/courses/30/lessons/92345
	 * 해답원본: https://github.com/encrypted-def/kakao-blind-recruitment/blob/master/2022-blind/Q7.java
	 * 바킹독님이 제시하신 해답을 이해하기 쉽게 변수명과 함수명을 변경하고 실행할 수 있게 main을 추가하였습니다.
	 */
	
	int[] directionX = {0,0,-1,1};
	int[] directionY = {-1,1,0,0};
	
	int boardLengthX;
	int boardLengthY;
	
	// 플레이할 수 없는 가장자리에 도달했는지 확인하는 함수 
	boolean IsOutOfBounds(int x, int y) {
		return x<0 || x>=boardLengthX || y<0 || y>=boardLengthY;
	}
	
	// 이동 경로를 탐색할 때 배열 범위를 넘어가는 경우 오류가 발생하므로 쉽게 해결하기 위해서 배열을 2칸씩 늘림
	boolean[][] visited = new boolean[5][5];
	int[][] boardExpanded = new int[5][5];

	public int solution(int[][] board, int[] aloc, int[] bloc) {
		boardLengthX = board.length;
		boardLengthY = board[0].length;
		
		// 가장자리 처리를 위해 플레이하는 공간을 양끝에 1개씩 늘리는 작업
        for(int i = 0; i < boardLengthX; i++) {
        	for(int j = 0; j < boardLengthY; j++) {
        		boardExpanded[i][j] = board[i][j];
        	}
        }
		
        return solve(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
	
	 int solve(int currentX, int currentY, int opponentX, int opponentY){
		// 이미 방문했던 곳이라 발판이 없다면
        if(visited[currentX][currentY]) {
        	return 0;    
        }
        int expectedTurn = 0;
        // 플레이어를 상,하,좌,우로 이동시킨다.
        for(int direction = 0; direction < 4; direction++){
            int futureX = currentX + directionX[direction];
            int futureY = currentY + directionY[direction];
            if(IsOutOfBounds(futureX,futureY) // 가장자리이면 방문하지 않고
        		|| visited[futureX][futureY] // 방문했던 곳이면 방문하지 않고
				|| boardExpanded[futureX][futureY] == 0) { // 발판이 없으면 방문하지 않는다.
            	continue;
            }
            
            // 플레이어가 있는 곳에 방문표시를 남김으로서 발판이 없는 것으로 처리한다.
            visited[currentX][currentY] = true; 

            // 플레이어를 direction 방향으로 이동시켰을 때 턴의 수
            // 다음 함수를 호출할 때는 이동하는 플레이어와 상대 플레이어가 바뀌므로
            // 인자가 다르게 지정해야한다.
            int currentTurn = solve(opponentX, opponentY, futureX, futureY)+1;      

            // 방문 표시 해제
            visited[currentX][currentY] = false; 
            
            // 게임의 특징상 턴을 2로 나누었을 때 승리하는 턴은 나머지가 1일 때이다.
            // 경우 1 - 현재 저장된 턴은 패배인데 새로 계산된 턴은 승리인 경우
            if(expectedTurn % 2 == 0 && currentTurn % 2 == 1) {
            	expectedTurn = currentTurn; // 승리하는 턴으로 정보 갱신
            }
            // 경우 2 - 현재 저장된 턴과 새로 계산된 턴이 모두 패배인 경우
            else if(expectedTurn % 2 == 0 && currentTurn % 2 == 0) {
            	expectedTurn = Math.max(expectedTurn, currentTurn); // 최대한 늦게 지는걸 선택
            }
            // 경우 3 - 현재 저장된 턴과 새로 계산된 턴이 모두 승리인 경우
            else if(expectedTurn % 2 == 1 && currentTurn % 2 == 1) {
            	expectedTurn = Math.min(expectedTurn, currentTurn); // 최대한 빨리 이기는걸 선택
            }
        }
        return expectedTurn;
	}

    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
		int[][] board = new int[][]{{1, 1, 1}, 
									{1, 1, 1}, 
									{1, 1, 1}};
		int[] aloc = new int[]{1, 0};
		int[] bloc = new int[]{1, 2};
		int answerCorrect = 5;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(board, aloc, bloc);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		board = new int[][]{{1, 1, 1}, 
							{1, 0, 1}, 
							{1, 1, 1}};
		aloc = new int[]{1, 0};
		bloc = new int[]{1, 2};
		answerCorrect = 4;
		answerReturned = -1;
		
		answerReturned = solution.solution(board, aloc, bloc);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		board = new int[][]{{1, 1, 1, 1, 1}};
		aloc = new int[]{0, 0};
		bloc = new int[]{0, 4};
		answerCorrect = 4;
		answerReturned = -1;
		
		answerReturned = solution.solution(board, aloc, bloc);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
		
		board = new int[][]{{1}};
		aloc = new int[]{0, 0};
		bloc = new int[]{0, 2};
		answerCorrect = 0;
		answerReturned = -1;
		
		answerReturned = solution.solution(board, aloc, bloc);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 4 PASS");
		}else {
			System.out.println("CASE 4 FAIL");
		}
	}
    
}
