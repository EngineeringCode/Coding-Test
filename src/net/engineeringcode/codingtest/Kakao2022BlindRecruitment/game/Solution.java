package net.engineeringcode.codingtest.Kakao2022BlindRecruitment.game;

public class Solution {
	/* ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > 2022 KAKAO BLIND RECRUITMENT > ������� ����
	 * Ǯ������: https://programmers.co.kr/learn/courses/30/lessons/92345
	 * �ش����: https://github.com/encrypted-def/kakao-blind-recruitment/blob/master/2022-blind/Q7.java
	 * ��ŷ������ �����Ͻ� �ش��� �����ϱ� ���� ������� �Լ����� �����ϰ� ������ �� �ְ� main�� �߰��Ͽ����ϴ�.
	 */
	
	int[] directionX = {0,0,-1,1};
	int[] directionY = {-1,1,0,0};
	
	int boardLengthX;
	int boardLengthY;
	
	// �÷����� �� ���� �����ڸ��� �����ߴ��� Ȯ���ϴ� �Լ� 
	boolean IsOutOfBounds(int x, int y) {
		return x<0 || x>=boardLengthX || y<0 || y>=boardLengthY;
	}
	
	// �̵� ��θ� Ž���� �� �迭 ������ �Ѿ�� ��� ������ �߻��ϹǷ� ���� �ذ��ϱ� ���ؼ� �迭�� 2ĭ�� �ø�
	boolean[][] visited = new boolean[5][5];
	int[][] boardExpanded = new int[5][5];

	public int solution(int[][] board, int[] aloc, int[] bloc) {
		boardLengthX = board.length;
		boardLengthY = board[0].length;
		
		// �����ڸ� ó���� ���� �÷����ϴ� ������ �糡�� 1���� �ø��� �۾�
        for(int i = 0; i < boardLengthX; i++) {
        	for(int j = 0; j < boardLengthY; j++) {
        		boardExpanded[i][j] = board[i][j];
        	}
        }
		
        return solve(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
	
	 int solve(int currentX, int currentY, int opponentX, int opponentY){
		// �̹� �湮�ߴ� ���̶� ������ ���ٸ�
        if(visited[currentX][currentY]) {
        	return 0;    
        }
        int expectedTurn = 0;
        // �÷��̾ ��,��,��,��� �̵���Ų��.
        for(int direction = 0; direction < 4; direction++){
            int futureX = currentX + directionX[direction];
            int futureY = currentY + directionY[direction];
            if(IsOutOfBounds(futureX,futureY) // �����ڸ��̸� �湮���� �ʰ�
        		|| visited[futureX][futureY] // �湮�ߴ� ���̸� �湮���� �ʰ�
				|| boardExpanded[futureX][futureY] == 0) { // ������ ������ �湮���� �ʴ´�.
            	continue;
            }
            
            // �÷��̾ �ִ� ���� �湮ǥ�ø� �������μ� ������ ���� ������ ó���Ѵ�.
            visited[currentX][currentY] = true; 

            // �÷��̾ direction �������� �̵������� �� ���� ��
            // ���� �Լ��� ȣ���� ���� �̵��ϴ� �÷��̾�� ��� �÷��̾ �ٲ�Ƿ�
            // ���ڰ� �ٸ��� �����ؾ��Ѵ�.
            int currentTurn = solve(opponentX, opponentY, futureX, futureY)+1;      

            // �湮 ǥ�� ����
            visited[currentX][currentY] = false; 
            
            // ������ Ư¡�� ���� 2�� �������� �� �¸��ϴ� ���� �������� 1�� ���̴�.
            // ��� 1 - ���� ����� ���� �й��ε� ���� ���� ���� �¸��� ���
            if(expectedTurn % 2 == 0 && currentTurn % 2 == 1) {
            	expectedTurn = currentTurn; // �¸��ϴ� ������ ���� ����
            }
            // ��� 2 - ���� ����� �ϰ� ���� ���� ���� ��� �й��� ���
            else if(expectedTurn % 2 == 0 && currentTurn % 2 == 0) {
            	expectedTurn = Math.max(expectedTurn, currentTurn); // �ִ��� �ʰ� ���°� ����
            }
            // ��� 3 - ���� ����� �ϰ� ���� ���� ���� ��� �¸��� ���
            else if(expectedTurn % 2 == 1 && currentTurn % 2 == 1) {
            	expectedTurn = Math.min(expectedTurn, currentTurn); // �ִ��� ���� �̱�°� ����
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
