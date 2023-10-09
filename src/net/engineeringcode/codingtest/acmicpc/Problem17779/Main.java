package net.engineeringcode.codingtest.acmicpc.Problem17779;
import java.util.*;

/*
 * Baekjoon Online Judge > Problem > 17779 > 게리맨더링 2
 * 문제주소: https://www.acmicpc.net/problem/17779
 * 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 * 제출용 소스 코드
 *  
 */

public class Main{	
	static int answer = Integer.MAX_VALUE;
	static int N;
	static int[][] mapPopulation;
	static int totalPopulation = 0;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		mapPopulation = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				mapPopulation[i][j] = sc.nextInt();
				totalPopulation += mapPopulation[i][j];
			}
		}

		System.out.println(simulation());
	}
	
	static int simulation() {
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				for(int d1=0; d1<N; d1++) {
					for(int d2=0; d2<N; d2++) {
						if(x+d1+d2 >= N) {
							continue;
						}
						if( y-d1 < 0 || y+d2 >= N) {
							continue;
						}
						answer = Math.min(answer, getDifference(x, y, d1, d2));
					}
				}
			}
		}
		
		return answer;
	}
	
	static int getDifference(int x, int y, int d1, int d2) {
		int[] populations = new int[5];
		boolean[][] mapBoundary = new boolean[N][N];
		
        for(int i=0; i<=d1; i++) {
        	mapBoundary[x+i][y-i] = true;
        	mapBoundary[x+d2+i][y+d2-i] = true;
        }
        for(int i=0; i<=d2; i++) {
        	mapBoundary[x+i][y+i] = true;
        	mapBoundary[x+d1+i][y-d1+i] = true;
        }		
		for(int i=0; i<x+d1; i++) {
			for(int j=0; j<=y; j++){
				if (mapBoundary[i][j]) 
					break;
				populations[0] += mapPopulation[i][j];
			}
		}		
		for(int i=0; i<=x+d2;i++) {
			for(int j=N-1; j>y; j--){
				if (mapBoundary[i][j]) 
					break;
				populations[1] += mapPopulation[i][j];
			}
		}		
		for(int i=x+d1; i<N; i++) {
			for(int j=0; j<y-d1+d2; j++){
				if (mapBoundary[i][j]) 
					break;
				populations[2] += mapPopulation[i][j];
			}
		}		
		for(int i=x+d2+1; i<N; i++) {
			for(int j=N-1; j>=y-d1+d2; j--){
				if (mapBoundary[i][j]) 
					break;
				populations[3] += mapPopulation[i][j];
			}
		}
		populations[4] = totalPopulation;
		for(int i=0; i<4; i++) {
			populations[4] -= populations[i];
		}		
		int minimumPopulation = Integer.MAX_VALUE;
		int maximumPopulation = 0;
		for(int i=0; i<=4; i++) {
			minimumPopulation = Math.min(minimumPopulation, populations[i]);
			maximumPopulation = Math.max(maximumPopulation, populations[i]);
		}		
		
		return maximumPopulation-minimumPopulation;
	}
}