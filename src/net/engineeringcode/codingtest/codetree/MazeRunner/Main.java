package net.engineeringcode.codingtest.codetree.MazeRunner;
import java.util.*;

/*
 * 코드트리 > 	메이즈 러너
 * 문제주소: https://codetree.ai/training-field/frequent-problems/problems/maze-runner/
 * 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 * 제출용 소스코드
 *  
 */

public class Main{
	static int N, M, K;
	static int[][] map;
	static int minimumDistance = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 플레이어 수는 음수로 표현한다.
		map[sc.nextInt()-1][sc.nextInt()-1]--;
		
		// 내구도가 10이면 출구이다.
		map[sc.nextInt()][sc.nextInt()] = 10;
		
		System.out.println(simulation());
	}
	
	static int simulation() {

		return 0;
	}
	
	static void movePlayers() {
		
	}
	
	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	static void getClosestPlayer() {		
		
	}
	
	static void getSquare(){

	}
	
	static void rotate() {

	}
}