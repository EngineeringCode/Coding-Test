package net.engineeringcode.codingtest.codetree.DestroyTheTurret;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 코드트리 > 	포탑 부수기
 * 문제주소: https://www.codetree.ai/training-field/frequent-problems/problems/destroy-the-turret
 * 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 *  
 */

public class Solution1{
	static int N, M, K;
	static int currentTurn = 1;
	static int[][] map;
	static int[][] mapAttackTurn;
	static boolean[][] participant;
	static int advantagePower;
	static Location attacker, deffender;
	// 레이저: 우/하/좌/상의 우선순위대로 먼저 움직인 경로가 선택
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
		//Scanner sc = new Scanner(System.in);
		
		Scanner sc = new Scanner("10 10 20\r\n"
				+ "995 3976 1850 0 0 0 0 0 2823 0\r\n"
				+ "0 2197 4554 0 3991 0 0 0 0 0\r\n"
				+ "2243 918 206 2051 0 0 0 0 0 2354\r\n"
				+ "0 0 2211 394 3896 2763 0 0 3580 3094\r\n"
				+ "0 0 4364 0 0 0 0 0 0 4990\r\n"
				+ "0 0 0 0 0 0 736 0 1159 0\r\n"
				+ "1374 0 2610 3165 3653 0 2651 0 0 0\r\n"
				+ "4493 0 1423 0 2416 0 0 0 3580 0\r\n"
				+ "0 4112 3779 0 3654 1247 0 0 132 712\r\n"
				+ "92 2643 1459 4675 4838 0 2539 850 2040 2153");
		
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
			//System.out.println("attacker: " + attacker.x + "," + attacker.y);
			getDefender();
			if(!attackWithLaser()) {
				attackWithCannon();
			}
			nextTurn();
			//printArray(map);
		}
		return getHightestPower();
	}
	
	/*
	 * 부서지지 않은 포탑 중 가장 약한 포탑이 공격자로 선정됩니다. 공격자로 선정되면 가장 약한 포탑이므로, 핸디캡이 적용되어 N+M만큼의 공격력이 증가됩니다.
	 */
	static void getAttacker() {
		// 1. 공격력이 가장 낮은 포탑이 가장 약한 포탑입니다.
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
		
		// 2. 가장 최근에 공격한 포탑이 가장 약한 포탑입니다.
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
		
		// 3. 각 포탑 위치의 행과 열의 합이 가장 큰 포탑이 가장 약한 포탑입니다.
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
		
		// 4. 각 포탑 위치의 열 값이 가장 큰 포탑이 가장 약한 포탑입니다.
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
	
	/*
	 * 위에서 선정된 공격자는 자신을 제외한 가장 강한 포탑을 공격합니다. 가장 강한 포탑은 위에서 정한 가장 약한 포탑 선정 기준의 반대이며, 다음과 같습니다.
	 */
	
	static void getDefender() {
		// 1. 공격력이 가장 높은 포탑이 가장 강한 포탑입니다.
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
		
		// 2. 공격한지 가장 오래된 포탑이 가장 강한 포탑입니다.
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
		
		// 3. 각 포탑 위치의 행과 열의 합이 가장 작은 포탑이 가장 강한 포탑입니다.
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
				
		// 4. 각 포탑 위치의 열 값이 가장 작은 포탑이 가장 강한 포탑입니다.
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
				//System.out.println(nextLoc.x+","+nextLoc.y);
				if(visited[nextLoc.x][nextLoc.y]) {
					continue;
				}
				
				if(map[nextLoc.x][nextLoc.y] <= 0) {
					continue;
				}
				
				// 경로를 완성한 경우(수비자에게 도달한 경우)
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
	
	/*
	 * 격 대상은 공격자 공격력 만큼의 피해를 받습니다. 
	 * 추가적으로 주위 8개의 방향에 있는 포탑도 피해를 입는데, 공격자 공격력의 절반 만큼의 피해를 받습니다. 
	 * (절반이라 함은 공격력을 2로 나눈 몫을 의미합니다.) 
	 * 공격자는 해당 공격에 영향을 받지 않습니다. 
	 * 만약 가장자리에 포탄이 떨어졌다면, 위에서의 레이저 이동처럼 포탄의 추가 피해가 반대편 격자에 미치게 됩니다.
	 */
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