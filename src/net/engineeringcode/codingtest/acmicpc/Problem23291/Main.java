package net.engineeringcode.codingtest.acmicpc.Problem23291;
import java.util.*;

/*
 * Baekjoon Online Judge > Problem > 20057 > 마법사 상어와 토네이도
 * 문제주소: https://www.acmicpc.net/problem/20057
 * 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 * 런타임 에러 (ArrayIndexOutOfBounds) 발생
 */
public class Main{	
	static int N;
	static int K;
	static int numberOfTimes;
	static LinkedList<int[]> map;
	
	static final int[] dy = { 0, 1, 0, -1 };
	static final int[] dx = { 1, 0, -1, 0 };
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		numberOfTimes = 0;
		map = new LinkedList<>();
		
		for(int x=0; x<N; x++) {
			map.add(new int[N]);
			map.get(x)[0] = sc.nextInt();
		}
		
		System.out.println(simulation());
	}
	
	static int simulation() {
		for(numberOfTimes=0; !isFinsihed(); numberOfTimes++) {
			addOneFishMinimumBowl();
			moveFirst();
			moveFish();
			lineUp();
			moveSecond();
			lineUp();
			moveFish();
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
		
		for(;;) {
			if(isFinalMoveFist()) {
				break;
			}
			
			int searchWidth = getSearchWidth(map);
			int searchHeight = getSearchHeight(map, 0);
			
			int offsetY = searchWidth+1;
			
			for(int x=0; x<=searchWidth; x++) {
				for(int y=0; y<=searchHeight; y++) {
					int targetX = searchWidth+1+y;
					int targetY = offsetY;
					map.get(targetX)[targetY] = map.get(x)[y]; 
				}
				offsetY--;
			}
			for(int x=0; x<=searchWidth; x++) {
				map.poll();
			}
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
							|| map.get(nx)[ny] >= map.get(x)[y]
							|| map.get(nx)[ny] == 0 
						)
						continue;
					int diff = (map.get(x)[y] - map.get(nx)[ny]) / 5;
					if (diff > 0) {
						tempMap.get(nx)[ny] += diff;
						tempMap.get(x)[y] -= diff;
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
}