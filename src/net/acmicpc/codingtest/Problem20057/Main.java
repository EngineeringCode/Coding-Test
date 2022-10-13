package net.acmicpc.codingtest.Problem20057;
import java.util.*;

public class Main{
	/*
	 * Baekjoon Online Judge > Problem > 20057 > ������ ���� ����̵�
	 * �����ּ�: https://www.acmicpc.net/problem/20057
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * 
	 * �ùķ��̼� �����̴�. �������� �߿��ϴ�. �������� ó���������̰� ���� ���µ� ������ ã�� �Ǹ� �ݿ��ϰڴ�.
	 * 
	 * ������: https://alwaysbemoon.tistory.com/225
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
		// �迭 ��� ��ǥ�� ���Ѵ�.
		int currentX = N/2;
		int currentY = N/2;

		for(;;) {
			// �� ����(4����)�� ���� �̵��ϴ� ���� �����Ѵ�.
			for(int directionIndex = 0; directionIndex < 4; directionIndex++) {
				// ��ǥ �������� ����̵��� 1ĭ�� �̵��Ѵ�.
				for(int movementCount = 0; movementCount < directionWeight[directionIndex]; movementCount++) {
					int nextX = currentX + directionX[directionIndex];
					int nextY = currentY + directionY[directionIndex];
					
					// ����̵��� �𷡹��� �����. �ùķ��̼��� �����Ѵ�.
					if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
						return amountOfSand;
					}
					
					/* �� ��� ���� */					
                    int sandTotal = map[nextX][nextY];
                    map[nextX][nextY] = 0;
                    int spreadTotal = 0;

                    for(int spreadIndex = 0; spreadIndex < 9; spreadIndex++){
                        int sandX = nextX + spreadDirectionX[directionIndex][spreadIndex];
                        int sandY = nextY + spreadDirectionY[directionIndex][spreadIndex];
                        int spreadAmount = (sandTotal * spreadRate[spreadIndex]) / 100;
                        
                        if(sandX < 0 || sandY < 0 || sandX >= N || sandY >= N){ // �𷡹��� �����
                        	amountOfSand += spreadAmount;
                        } else { // ���� �� ���� �׿���.
                            map[sandX][sandY] += spreadAmount;
                        }
                        spreadTotal += spreadAmount;
                    }

                    /* �� ��� */
                    int aX = nextX + directionX[directionIndex];
                    int aY = nextY + directionY[directionIndex];
                    int aAmount = sandTotal - spreadTotal;
                    if(aX < 0 || aY < 0|| aX >= N || aY >= N){
                    	amountOfSand += aAmount;
                    } else {
                        map[aX][aY] += aAmount;
                    }				
					/* �� ��� �� */
	
					currentX = nextX;
					currentY = nextY;
				}
			}
			
			// �� ������ �������� �̵��ϴ� �Ÿ� �߰�
			for(int i = 0; i < 4; i++) {
				directionWeight[i] += 2;
			}
		}
	}
}