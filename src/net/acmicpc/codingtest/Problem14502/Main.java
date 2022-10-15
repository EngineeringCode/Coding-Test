package net.acmicpc.codingtest.Problem14502;
import java.util.*;

/*
 * Baekjoon Online Judge > Problem > 14502 > 연구소
 * 문제주소: https://www.acmicpc.net/problem/14502
 * 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 * 제출용 소스 코드
 *  
 */
public class Main{	
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
		
		copyArray(map, mapWall);	
		
		buildWall(0);
		
		System.out.println(maximumEmpty);
	}
	static void buildWall(int count) {
        if (count == 3) {     	
            spreadVirus();
            searchEmpty();
            return;
        }
        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                if (mapWall[y][x] == CODE_EMPTY) {
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
		
		if (y<0 || x<0 || y>=N || x>=M) {
			return;
		}
		
		if(mapVirus[y][x] == CODE_WALL) {
			return;
		}

		if(mapVirus[y][x] == CODE_VIRUS) {
			return;
		}

		if (mapVirus[y][x] == CODE_EMPTY) {
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
	static void copyArray(int[][] src, int dest[][]) {
		for(int y=0; y<src.length; y++) {
			for(int x=0; x<src[0].length; x++) {
				dest[y][x] = src[y][x];
			}
		}
	}
}