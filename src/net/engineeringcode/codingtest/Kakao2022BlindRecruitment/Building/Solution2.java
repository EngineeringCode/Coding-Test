package net.engineeringcode.codingtest.Kakao2022BlindRecruitment.Building;

public class Solution2 {
	/*
	 * ���α׷��ӽ� > 2022 īī�� ����ε� ä�� > �ı����� ���� �ǹ�
	 * https://programmers.co.kr/learn/courses/30/lessons/92344
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ȿ���� �׽�Ʈ�� ����ϱ� ���� �������� �����Ѵ�.
	 */
    
    public int solution(int[][] board, int[][] skill) {
    	//System.out.println("board.length:"+board.length);
    	//System.out.println("board[0].length:"+board[0].length);
    	
    	int[][] prefixSum = new int[board.length+2][board.length+2];
    	
    	// ��ų�� ������� �����տ� �����Ѵ�.
    	for(int i=0;i<skill.length;i++) {
    		int action[] = skill[i];
    		
    		int type = 1; // ���(ġ��)
    		if(action[0]==1){ // ����
    			type = -1;
    		}
    		int r1 = action[1];
    		int c1 = action[2];
    		int r2 = action[3];
    		int c2 = action[4];
    		int degree = action[5];
    		
    		prefixSum[r1][c1] += type*degree;
    		prefixSum[r1][c2+1] -= type*degree;
    		prefixSum[r2+1][c1] -= type*degree;
    		prefixSum[r2+1][c2+1] += type*degree;
    	}
    	
    	// ���η� ������
    	for(int x=1; x<board.length; x++) {
    		for(int y=0; y<board[0].length; y++) {
    			prefixSum[x][y] += prefixSum[x-1][y];
    		}
    	}
    	// ���η� ������
    	for(int x=0; x<board.length; x++) {
    		for(int y=1; y<board[0].length; y++) {
    			prefixSum[x][y] += prefixSum[x][y-1];
    		}
    	}
    	
    	/*
    	// ������ �ǹ� ���
    	System.out.println("======= board =========");
    	for(int[] sum:board) {
    		System.out.println(Arrays.toString(sum));
    	}
    	// ������ ������ ���
    	System.out.println("=======Prefix Sum=========");
    	for(int[] sum:prefixSum) {
    		System.out.println(Arrays.toString(sum));
    	}
    	*/
    	
    	
    	int answer = 0;
    	
    	// �� �μ��� �ǹ��� ���� ����.
		for(int x=0;x<board.length;x++) {
			for(int y=0;y<board[0].length;y++) {
				if( (board[x][y]+prefixSum[x][y]) > 0) {
					answer++;
				}
			}
		}
        
        return answer;
    }
    
    
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
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
