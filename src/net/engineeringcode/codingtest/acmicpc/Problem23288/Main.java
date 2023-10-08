package net.engineeringcode.codingtest.acmicpc.Problem23288;
import java.util.*;

/*
 * Baekjoon Online Judge > Problem > 23288 > 주사위 굴리기 2
 * 문제주소: https://www.acmicpc.net/problem/23288
 * 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 * 제출용 소스 코드
 *  
 */

public class Main{	
	final static int EAST = 0;
	final static int SOUTH = 1;
	final static int WEST = 2;
	final static int NORTH = 3;
	static int[][] map;
	static int N, M, K;
	static int direction = EAST;
	static Location position;
	static int[] directionY = {0, 1, 0, -1};
	static int[] directionX = {1, 0, -1, 0};
	
	static int[][] dice = {
		{0, 2, 0},
		{4, 1, 3},
		{0, 5, 0},
		{0, 6, 0}
	};
	
	static class Location{
		public int y;
		public int x;
		
		Location(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		position = new Location(1, 1);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N+2][M+2];
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(simulation());
	}
	
	static int simulation() {
		int sum = 0;
		
		for(int i=0; i < K; i++) {
			int nextY = position.y+directionY[direction];
			int nextX = position.x+directionX[direction];
			Location nextPos = new Location(nextY, nextX);
			
			if(map[nextPos.y][nextPos.x] == 0) {
				direction = (direction + 2) % 4;
				nextPos.y = position.y + directionY[direction];
				nextPos.x = position.x + directionX[direction];
			}
			
			position.y = nextPos.y;
			position.x = nextPos.x;
			
			moveDice(direction);
			sum += getScore(position);
			getNextDirection();
		}
		
		return sum;
	}
	
	static void moveDice(int direction) {
		int tmp;
		switch (direction) {
		case EAST:
			tmp = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = tmp;
			break;
		case SOUTH:
			tmp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = tmp;
			break;
		case WEST:
			tmp = dice[3][1];
			dice[3][1] = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = tmp;
			break;
		case NORTH:
			tmp = dice[3][1];
			dice[3][1] = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = tmp;
			break;
		}
	}
	
	static int getScore(Location loc) {
		int target = map[loc.y][loc.x];
		int count = 0;
		boolean[][] visited = new boolean[map.length][map[0].length];
		LinkedList<Location> queue = new LinkedList<>();
		
		queue.add(new Location(loc.y, loc.x));
		visited[loc.y][loc.x] = true;
		
		while(!queue.isEmpty()) {
			Location currentLoc = queue.poll();
			count++;
			
			for(int i=0; i<directionX.length; i++) {
				int nextY = currentLoc.y + directionY[i];
				int nextX = currentLoc.x + directionX[i];

				if(visited[nextY][nextX] == true) {
					continue;
				}
				
				if(map[nextY][nextX] == target) {
					queue.add(new Location(nextY, nextX));
					visited[nextY][nextX] = true;
				}				
			}
		}

		return target*count;
	}
	
	static void getNextDirection() {
		int A = dice[3][1];
		int B = map[position.y][position.x];
		
		if(A > B) {
			direction = (direction + 1) % 4;
		} else if(A < B){
			direction = (direction - 1) % 4;
			if(direction == -1) {
				direction = 3;
			}
		}
	}
}