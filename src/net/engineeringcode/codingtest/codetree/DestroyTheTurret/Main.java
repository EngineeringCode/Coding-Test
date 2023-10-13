package net.engineeringcode.codingtest.codetree.DestroyTheTurret;
import java.util.*;

import net.engineeringcode.codingtest.codetree.DestroyTheTurret.Solution1.Location;

/*
 * 코드트리 > 	포탑 부수기
 * 문제주소: https://www.codetree.ai/training-field/frequent-problems/problems/destroy-the-turret
 * 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 * 제출용 소스코드
 *  
 */

public class Main{
	static int N, M, K;
	static int currentTurn = 1;
	static int[][] map;
	static int[][] mapAttackTurn;
	static boolean[][] participant;
	static int advantagePower;
	static Location attacker, deffender;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Location {
		public int x, y;
		public LinkedList<Location> route;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Location(int x, int y, LinkedList<Location> route) {
			this.x = x;
			this.y = y;
			this.route = route;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		advantagePower = N + M;
		
		map = new int[N][M];
		mapAttackTurn = new int[N][M];
		participant = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(simulation());
	}
	
	static int simulation() {
		while(!isFinished()) {
			getAttacker();
			getDefender();
			if(!attackWithLaser()) {
				attackWithCannon();
			}
			nextTurn();
		}
		return getHightestPower();
	}
	
	static void getAttacker() {
		int power = Integer.MAX_VALUE;
		LinkedList<Location> listForFirst = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] <= 0) {
					continue;
				}
				
				if(map[i][j] < power) {
					power = map[i][j];
					listForFirst.clear();
					listForFirst.add(new Location(i, j));
					continue;
				}
				
				if(map[i][j] == power) {
					listForFirst.add(new Location(i, j));
				}
			}
		}

		if(listForFirst.size() == 1) {
			attacker = listForFirst.getFirst();
			return;
		}
		
		LinkedList<Location> listForSecond = new LinkedList<>();
		int turn = Integer.MIN_VALUE;
		for(Location loc : listForFirst) {			
			if(turn < mapAttackTurn[loc.x][loc.y]) {
				turn = mapAttackTurn[loc.x][loc.y];
				listForSecond.clear();
				listForSecond.add(new Location(loc.x, loc.y));
				continue;
			}
			
			if(turn == mapAttackTurn[loc.x][loc.y]) {
				listForSecond.add(new Location(loc.x, loc.y));
			}
		}
		
		if(listForSecond.size() == 1) {
			attacker = listForSecond.getFirst();
			return;
		}
		
		LinkedList<Location> listForThird = new LinkedList<>();		
		int value = Integer.MIN_VALUE;
		for(Location loc : listForSecond) {
			int sum = loc.x + loc.y;
			
			if(sum > value) {
				value = sum;
				listForThird.clear();
				attacker = new Location(loc.x, loc.y);
				listForThird.add(new Location(loc.x, loc.y));
				continue;
			}
			
			if(sum == value) {
				listForThird.add(new Location(loc.x, loc.y));
			}
		}
		
		if(listForThird.size() == 1) {
			attacker = listForThird.getFirst();
			return;
		}
		
		LinkedList<Location> listForFourth = new LinkedList<>();		
		value = Integer.MIN_VALUE;
		for(Location loc : listForThird) {
			int sum = loc.y;
			
			if(sum > value) {
				value = sum;
				listForFourth.clear();
				attacker = new Location(loc.x, loc.y);
				listForFourth.add(new Location(loc.x, loc.y));
				continue;
			}
			
			if(sum == value) {
				listForFourth.add(new Location(loc.x, loc.y));
			}
		}

		attacker = listForFourth.getFirst();
		return;
	}
		
	static void getDefender() {
		int power = Integer.MIN_VALUE;
		LinkedList<Location> listForFirst = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] <= 0) {
					continue;
				}
				
				if(attacker.x == i && attacker.y == j) {
					continue;
				}
				
				if(map[i][j] > power) {
					power = map[i][j];
					listForFirst.clear();
					listForFirst.add(new Location(i, j));
					continue;
				}
				
				if(map[i][j] == power) {
					listForFirst.add(new Location(i, j));
				}
			}
		}
		
		if(listForFirst.size() == 1) {
			deffender = listForFirst.getFirst();
			return;
		}
		
		LinkedList<Location> listForSecond = new LinkedList<>();
		int turn = Integer.MAX_VALUE;
		for(Location loc : listForFirst) {
			if(attacker.x == loc.x && attacker.y == loc.y) {
				continue;
			}
			
			if(turn > mapAttackTurn[loc.x][loc.y]) {
				turn = mapAttackTurn[loc.x][loc.y];
				listForSecond.clear();
				listForSecond.add(new Location(loc.x, loc.y));
				continue;
			}
			
			if(turn == mapAttackTurn[loc.x][loc.y]) {
				listForSecond.add(new Location(loc.x, loc.y));
			}
		}
		
		if(listForSecond.size() == 1) {
			deffender = listForSecond.getFirst();
			return;
		}
		
		LinkedList<Location> listForThird = new LinkedList<>();		
		int value = Integer.MAX_VALUE;
		for(Location loc : listForSecond) {
			if(attacker.x == loc.x && attacker.y == loc.y) {
				continue;
			}
			
			int sum = loc.x + loc.y;
			if(sum < value) {
				value = sum;
				listForThird.clear();
				deffender = new Location(loc.x, loc.y);
				listForThird.add(new Location(loc.x, loc.y));
				continue;
			}
			
			if(sum == value) {
				listForThird.add(new Location(loc.x, loc.y));
			}
		}
		
		if(listForThird.size() == 1) {
			deffender = listForThird.getFirst();
			return;
		}
		
		LinkedList<Location> listForFourth = new LinkedList<>();		
		value = Integer.MAX_VALUE;
		for(Location loc : listForThird) {
			if(attacker.x == loc.x && attacker.y == loc.y) {
				continue;
			}
			
			int sum = loc.y;
			
			if(sum < value) {
				value = sum;
				listForFourth.clear();
				deffender = new Location(loc.x, loc.y);
				listForFourth.add(new Location(loc.x, loc.y));
				continue;
			}
			
			if(sum == value) {
				listForFourth.add(new Location(loc.x, loc.y));
			}
		}

		deffender = listForFourth.getFirst();
		return;
	}
	
	static boolean attackWithLaser() {
		boolean[][] visited = new boolean[N][M];
		LinkedList<Location> queue = new LinkedList<>();
		LinkedList<Location> route = new LinkedList<>();
		
		queue.add(new Location(attacker.x, attacker.y, route));
		
		while(!queue.isEmpty()) {
			Location loc = queue.poll();
			Location nextLoc;
			
			for(int i=0; i<4; i++) {
				nextLoc = new Location( (N + loc.x + dx[i]) % N, (M + loc.y + dy[i]) % M);
				if(visited[nextLoc.x][nextLoc.y]) {
					continue;
				}
				
				if(map[nextLoc.x][nextLoc.y] <= 0) {
					continue;
				}
				
				if(nextLoc.x == deffender.x && nextLoc.y == deffender.y) {
					int attackPower = map[attacker.x][attacker.y] + advantagePower;
					int halfAttackPower = attackPower / 2;
					map[nextLoc.x][nextLoc.y] -= attackPower;
					participant[nextLoc.x][nextLoc.y] = true;
					
					for(Location prevLoc : loc.route) {
						map[prevLoc.x][prevLoc.y] -= halfAttackPower;
						participant[prevLoc.x][prevLoc.y] = true;
					}
					
					participant[attacker.x][attacker.y] = true;
					mapAttackTurn[attacker.x][attacker.y] = currentTurn;
					return true;
				}
				
				LinkedList<Location> nextRoute = (LinkedList) loc.route.clone();
				nextRoute.add(nextLoc);
				nextLoc.route = nextRoute;
				visited[nextLoc.x][nextLoc.y] = true;
				queue.add(nextLoc);
			}
		}
		
		return false;
	}
	
	static void attackWithCannon() {
		int attackPower = map[attacker.x][attacker.y] + advantagePower;
		int halfAttackPower = attackPower / 2;
		
		map[deffender.x][deffender.y] -= attackPower;
		participant[deffender.x][deffender.y] = true;
		
		int[] cdx = {0, 1, 0, -1, 1, 1, -1, -1};
		int[] cdy = {1, 0, -1, 0, 1, -1, -1, 1};
		
		for(int i=0; i<8; i++) {
			Location nextLoc = new Location((N + deffender.x + cdx[i]) % N, (M + deffender.y + cdy[i]) % M);
			if(nextLoc.x == attacker.x && nextLoc.y == attacker.y) {
				continue;
			}
			map[nextLoc.x][nextLoc.y] -= halfAttackPower;
			participant[nextLoc.x][nextLoc.y] = true;
		}
		
		participant[attacker.x][attacker.y] = true;
		mapAttackTurn[attacker.x][attacker.y] = currentTurn;
	}
	
	static void nextTurn() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(participant[i][j] == false && map[i][j] > 0) {
					map[i][j]++;
				}
			}
		}
		map[attacker.x][attacker.y] += advantagePower;
		currentTurn++;
		setArray(participant, false);
		attacker = null;
		deffender = null;
	}
	
	static boolean isFinished() {
		if(currentTurn > K) {
			return true;
		}
		
		int remainPlayerCount = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] > 0) {
					remainPlayerCount++;
				}
				
				if(remainPlayerCount > 1) {
					return false;
				}
			}
		}		
		return true;
	}
	
	static int getHightestPower() {
		int maximumPower = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				maximumPower = Math.max(maximumPower, map[i][j]);
			}
		}
		return maximumPower;
	}
	
	static void setArray(boolean[][] arr, boolean value) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] = value;
			}
		}
	}
}