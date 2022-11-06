package net.engineeringcode.codingtest.acmicpc.Problem14502;
import java.util.*;

/*
 * Baekjoon Online Judge > Problem > 14502 > 연구소
 * 문제주소: https://www.acmicpc.net/problem/14502
 * 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 * 코딩을 위해서는 완전 탐색과 그래프 탐색 관련 지식이 필요하다.
 *  
 */
public class Solution1{	
	static final int CODE_EMPTY = 0;
	static final int CODE_WALL 	= 1;
	static final int CODE_VIRUS = 2;
	static int N;
	static int M;
	static int allowedModificationCount;
	static int maximumEmpty = 0;

	static int[][] map;
	static int[][] mapWall;
	static int[][] mapVirus;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		mapWall = new int[N][M];
		mapVirus = new int[N][M];
		
		for(int y=0;y<N;y++) {
			for(int x=0;x<M;x++) {
				map[y][x] = sc.nextInt();
			}
		}
		
		// 자바는 clone()으로 2차원 배열의 객체를 깊은 복사하지 못 한다.
		//mapWall = map.clone();
		copyArray(map, mapWall);
		
		buildWall(0);
		
		System.out.println(maximumEmpty);
	}

	static void buildWall(int count) {
        if (count == 3) {     	
            spreadVirus();
            searchEmpty();
        	//System.out.println("map:");
        	//printArray(map);
        	//System.out.println("mapWall:");
        	//printArray(mapWall);
        	//System.out.println("mapVirus:");
        	//printArray(mapVirus);
            return;
        }
        
        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                if (mapWall[y][x] == CODE_EMPTY) {
                	//System.out.printf("(%d,%d)\r\n",y,x);
                	mapWall[y][x] = CODE_WALL;
                    buildWall(count+1);
                    mapWall[y][x] = CODE_EMPTY;
                }
            }
        }
    }
	
	static void spreadVirus() {
		copyArray(mapWall, mapVirus);
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				//System.out.printf("(%d,%d)==%d\r\n", y, x, map[y][x]);
				if(mapVirus[y][x] == CODE_VIRUS) {	
					sparedVirusRecursive(y+1, x);
					sparedVirusRecursive(y-1, x);
					sparedVirusRecursive(y, x+1);
					sparedVirusRecursive(y, x-1);
				}
			}
		}
	}
	
	static void sparedVirusRecursive(int y, int x) {			
		//System.out.printf("(%d,%d)\r\n", y, x);
		
		if (y<0 || x<0 || y>=N || x>=M) {
			//System.out.println("범위를 벗어났다.");
			return;
		}
		
		if(mapVirus[y][x] == CODE_WALL) {
			//System.out.println("벽이다.");
			return;
		}

		if(mapVirus[y][x] == CODE_VIRUS) {
			//System.out.println("이미 바이러스가 퍼진 곳이다.");
			return;
		}

		if (mapVirus[y][x] == CODE_EMPTY) {
			//System.out.println("전염시키자!");
			mapVirus[y][x] = CODE_VIRUS;
		}
		
		sparedVirusRecursive(y+1, x);
		sparedVirusRecursive(y-1, x);
		sparedVirusRecursive(y, x+1);
		sparedVirusRecursive(y, x-1);
	}
	
	static void searchEmpty() {
		int count = 0;
		for(int y=0;y<N;y++) {
			for(int x=0;x<M;x++) {
				if(mapVirus[y][x] == CODE_EMPTY) {
					count++;
				}
			}
		}
		maximumEmpty = Math.max(maximumEmpty, count);
	}
	
	static void printArray(int[][] m) {
		for(int y=0;y<m.length;y++) {
			for(int x=0;x<m[y].length;x++) {
				System.out.printf("%d ", m[y][x]);
			}
			System.out.println();
		}
	}
	
	static void copyArray(int[][] src, int dest[][]) {
		for(int y=0; y<src.length; y++) {
			for(int x=0; x<src[0].length; x++) {
				dest[y][x] = src[y][x];
			}
		}
	}
}