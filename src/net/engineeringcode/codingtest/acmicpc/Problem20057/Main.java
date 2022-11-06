package net.engineeringcode.codingtest.acmicpc.Problem20057;
import java.util.*;

public class Main{
	/*
	 * Baekjoon Online Judge > Problem > 20057 > 마법사 상어와 토네이도
	 * 문제주소: https://www.acmicpc.net/problem/20057
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 * 시뮬레이션 문제이다. 구현력이 중요하다. 참고문서와 처리성능차이가 많이 나는데 원인을 찾게 되면 반영하겠다.
	 * 
	 * 참고문서: https://alwaysbemoon.tistory.com/225
	 */
	
	static int N;
	static int[][] map;
	static int[] spreadRate = {+1,+1,+2,+7,+7,+2,+10,+10,+5};
	static int[][] spreadDirectionX = {
			{-1,+1,-2,-1,+1,+2,-1,+1,+0}, 
			{-1,-1,+0,+0,+0,+0,+1,+1,+2},
            {+1,-1,+2,+1,-1,-2,+1,-1,+0}, 
            {+1,+1,+0,+0,+0,+0,-1,-1,-2}
	};
	static int[][] spreadDirectionY = {
			{+1,+1,+0,+0,+0,+0,-1,-1,-2},
			{-1,+1,-2,-1,+1,+2,-1,+1,+0},
            {-1,-1,+0,+0,+0,+0,+1,+1,+2},
            {+1,-1,+2,+1,-1,-2,+1,-1,+0}
	};
	static int[] directionX = {+0,+1,+0,-1};
	static int[] directionY = {-1,+0,+1,+0};
	static int[] directionWeight = {+1,+1,+2,+2};
	
	static int amountOfSand = 0;
		
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		/*
		Scanner sc = new Scanner("5\r\n" + 
				"0 0 0 0 0\r\n" + 
				"0 0 0 0 0\r\n" + 
				"0 100 0 0 0\r\n" + 
				"0 0 0 0 0\r\n" + 
				"0 0 0 0 0");
		*/
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		/*
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
		System.out.println(simulation());
	}
	
	static int simulation() {
		// 배열 가운데 좌표를 구한다.
		int currentX = N/2;
		int currentY = N/2;

		for(;;) {
			// 한 바퀴(4방향)를 돌고 이동하는 양이 증가한다.
			for(int directionIndex = 0; directionIndex < 4; directionIndex++) {
				// 목표 지점까지 토네이도가 1칸씩 이동한다.
				for(int movementCount = 0; movementCount < directionWeight[directionIndex]; movementCount++) {
					int nextX = currentX + directionX[directionIndex];
					int nextY = currentY + directionY[directionIndex];
					
					// 토네이도가 모래밭을 벗어났다. 시뮬레이션을 종료한다.
					if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
						return amountOfSand;
					}
					
					/* 모래 계산 시작 */					
                    int sandTotal = map[nextX][nextY];
                    map[nextX][nextY] = 0;
                    int spreadTotal = 0;

                    for(int spreadIndex = 0; spreadIndex < 9; spreadIndex++){
                        int sandX = nextX + spreadDirectionX[directionIndex][spreadIndex];
                        int sandY = nextY + spreadDirectionY[directionIndex][spreadIndex];
                        int spreadAmount = (sandTotal * spreadRate[spreadIndex]) / 100;
                        
                        if(sandX < 0 || sandY < 0 || sandX >= N || sandY >= N){ // 모래밭을 벗어나면
                        	amountOfSand += spreadAmount;
                        } else { // 기존 모래 위에 쌓였다.
                            map[sandX][sandY] += spreadAmount;
                        }
                        spreadTotal += spreadAmount;
                    }

                    /* α 계산 */
                    int aX = nextX + directionX[directionIndex];
                    int aY = nextY + directionY[directionIndex];
                    int aAmount = sandTotal - spreadTotal;
                    if(aX < 0 || aY < 0|| aX >= N || aY >= N){
                    	amountOfSand += aAmount;
                    } else {
                        map[aX][aY] += aAmount;
                    }				
					/* 모래 계산 끝 */
	
					currentX = nextX;
					currentY = nextY;
				}
			}
			
			// 한 바퀴를 돌았으면 이동하는 거리 추가
			for(int i = 0; i < 4; i++) {
				directionWeight[i] += 2;
			}
		}
	}
}