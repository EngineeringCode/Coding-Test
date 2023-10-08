package net.engineeringcode.codingtest.acmicpc.Problem23291;
import java.util.*;

public class Solution1{
	/*
	 * Baekjoon Online Judge > Problem > 23291 > 어항 정리
	 * 문제주소: https://www.acmicpc.net/problem/23291
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 런타임 에러(ArrayIndexOutOfBounds)가 발생한 실패한 해답이다.
	 */
	
	static int N;
	static int K;
	static int numberOfTimes;
	static LinkedList<int[]> map;
	
	static final int[] dy = { 0, 1, 0, -1 };
	static final int[] dx = { 1, 0, -1, 0 };
	
	public static void main(String args[]) throws Exception
	{
		//Scanner sc = new Scanner(System.in);
		
		/* 
		 * 참고 테스트 케이스 목록
		 * 
		 * https://www.acmicpc.net/board/view/101778
		 */
		Scanner sc = new Scanner("7 0\r\n" + 
				"5111 1100 5 7 10000 9 9999");
		
		N = sc.nextInt();
		K = sc.nextInt();
		numberOfTimes = 0;
		map = new LinkedList<>();
		
		for(int x=0;x<N;x++) {
			map.add(new int[N]);
			map.get(x)[0] = sc.nextInt();
		}

		System.out.println(simulation());
	}
	
	static int simulation() {
		//printArray();
		
		/* 8. 물고기가 가장 많이 들어있는 어항과 가장 적게 들어있는 어항의 물고기 수 차이가 K개 이하이면 종료하고 아니면 1~8번 반복 */
		for(numberOfTimes=0; !isFinsihed(); numberOfTimes++) {
			/* 1. 물고기가 가장 적게 들어있는 어항에 물고기 한 마리 추가하기  */
			//System.out.println("Step1:");
			addOneFishMinimumBowl();
			//printArray();
			/* 2. 어항 90도씩 돌리면서 쌓기 */
			//System.out.println("Step2:");
			moveFirst();
			//printArray();
			/* 3. 물고기 수 조절하기 */
			//System.out.println("Step3:");
			moveFish();
			//printArray();
			/* 4. 바닥에 일렬로 놓기 */
			//System.out.println("Step4:");
			lineUp();
			//printArray();
			/* 5. N/2 씩 180도씩 돌리면서 쌓기 */
			//System.out.println("Step5:");
			moveSecond();
			//printArray();
			/* 6. 바닥에 일렬로 놓기 */
			//System.out.println("Step6:");
			lineUp();
			//printArray();
			/* 7. 물고기 수 조절하기 */
			//System.out.println("Step7:");
			moveFish();
			//printArray();
			
			/*
			Scanner sc = new Scanner(System.in);
			System.out.print("Type something to continue:");
			sc.next();
			*/
		}
		
		return numberOfTimes;
	}
	
	static void addOneFishMinimumBowl() {
		int minimumFishCount = 10000;
		
		minimumFishCount = seachMinimumFishCount();
		
		for(int i=0; i<map.size(); i++) {
			if(map.get(i)[0] == minimumFishCount) {
				map.get(i)[0]++;
			}
		}
	}
	
	static void moveFirst() {
		map.get(1)[1] = map.get(0)[0]; 
		map.remove(0);
		//printArray();
		
		for(;;) {
			if(isFinalMoveFist()) {
				break;
			}
			
			int searchWidth = getSearchWidth(map);
			int searchHeight = getSearchHeight(map, 0);
			//System.out.printf("(%d,%d)\r\n", searchWidth, searchHeight);
			
			int offsetY = searchWidth+1;
			
			for(int x=0; x<=searchWidth; x++) {
				for(int y=0; y<=searchHeight; y++) {
					int targetX = searchWidth+1+y;
					int targetY = offsetY;
					map.get(targetX)[targetY] = map.get(x)[y]; 
					//System.out.printf("(%d,%d)->(%d,%d) \r\n", x, y, targetX, targetY);
				}
				offsetY--;
			}
			
			for(int x=0; x<=searchWidth; x++) {
				map.poll();
			}
			//printArray();
		}
	}
	static int getSearchWidth(LinkedList<int[]> map) {
		int width = -1;
		for(int x=0; x<map.size(); x++) {
			if(getSearchHeight(map, x) == 0) {
				break;
			}
			width++;
		}
		return width;
	}
	static int getSearchHeight(LinkedList<int[]> map, int index) {
		int height = -1;
		int[] targetList = map.get(index);
		for(int target:targetList) {
			if(target == 0) {
				break;
			}
			height++;
		}
		return height;
	}
	static boolean isFinalMoveFist() {
		if(getSearchHeight(map, 0)+1 >= map.size()-getSearchWidth(map)) {
			return true;
		}
		return false;
	}
	static void moveSecond() {
		for(int count=0; count<2; count++) {
			int searchWidth = map.size()/2;
			int searchHeight = getSearchHeight(map, 0);
			
			//System.out.printf("(%d,%d)\r\n", searchWidth, searchHeight);
			for(int x=0; x<searchWidth; x++) {
				int offsetY = searchHeight+1;
				for(int y=0; y<=searchHeight; y++) {
					map.get(map.size()-1-x)[offsetY] = map.get(x)[y];
					offsetY++;
				}
			}
			
			for(int x=0; x<searchWidth; x++) {
				map.poll();
			}
			//printArray();
			//System.out.println();
		}
	}
	static void lineUp() {
		LinkedList<int[]> tempMap = new LinkedList<>();
		for(int x=0; x<map.size(); x++) {
			for(int y=0; y<map.get(x).length; y++) {
				if(map.get(x)[y] == 0) {
					break;
				}
				tempMap.add(new int[] {map.get(x)[y],0,0,0,0,0,0,0});
			}
		}
		map = (LinkedList<int[]>) tempMap.clone();
	}
	/*
	 *	물고기 수를 조절하는 메서드인데 설명만으로 구현하기가 모호하다. 
	 *	현재 특정 케이스에서 실패한다.
	 *  
	 *  참고문서
	 *  https://kau-algorithm.tistory.com/585
	 *  https://jangcenter.tistory.com/94
	 */
	static void moveFish() {
		LinkedList<int[]> tempMap = (LinkedList<int[]>) map.clone();	

		for (int x = 0; x < map.size(); x++) {
			for (int y = 0; y < map.get(0).length; y++) {
				if (map.get(x)[y] == 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (
							(nx < 0 || ny < 0 || nx >= map.size() || ny >= map.get(0).length) 
							|| map.get(nx)[ny] == 0 
						)
						continue;
					int diff = (map.get(x)[y] - map.get(nx)[ny]) / 5;
					if (diff > 0) {
						tempMap.get(x)[y] -= diff;
						tempMap.get(nx)[ny] += diff;
					}
				}
			}
		}
		
		map = (LinkedList<int[]>) tempMap.clone();
	}
	static boolean isFinsihed() {		
		int max = seachMaximumFishCount();
		int min = seachMinimumFishCount();
		if( (max - min) <= K) {
			//System.out.println("max:"+max+" min:"+min);
			return true;
		}
		return false;
	}
	static int seachMinimumFishCount(){
		int minimumFishCount = 10000;
		for(int i=0; i<map.size(); i++) {
			minimumFishCount = Math.min(map.get(i)[0], minimumFishCount);
		}
		return minimumFishCount;
	}
	static int seachMaximumFishCount(){
		int maximumFishCount = -1;
		for(int i=0; i<map.size(); i++) {
			maximumFishCount = Math.max(map.get(i)[0], maximumFishCount);
		}
		return maximumFishCount;
	}
	static void printArray() {
		for(int x=0;x<map.size();x++) {
			for(int y=0;y<map.get(x).length;y++) {
				System.out.printf("%5d ", map.get(x)[y]);
			}
			System.out.println();
		}
	}
}