package net.engineeringcode.codingtest.codetree.MazeRunner;
import java.util.*;

/*
 * 코드트리 > 	메이즈 러너
 * 문제주소: https://codetree.ai/training-field/frequent-problems/problems/maze-runner/
 * 작성자: 공학코드(engineeringcode93@gmail.com)
 * 참고문서: https://colorscripter.com/s/OOPBE7p
 * 
 * 회전하는 부분이 모든 것에 영향을 주기 때문에 배열에 모든 것을 표현하는 방법을 잘 구성하는 것이 중요하다.
 *  
 */

public class Solution1{
	static int N, M, K;
	static int[][] map;
	static int minimumDistance = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception
	{
		//Scanner sc = new Scanner(System.in);
		
		Scanner sc = new Scanner("5 3 8\r\n"
				+ "0 0 0 0 1\r\n"
				+ "9 2 2 0 0\r\n"
				+ "0 1 0 1 0\r\n"
				+ "0 0 0 1 0\r\n"
				+ "0 0 0 0 0\r\n"
				+ "1 3\r\n"
				+ "3 1\r\n"
				+ "3 5\r\n"
				+ "3 3");
		
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
	
	static void printArray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}