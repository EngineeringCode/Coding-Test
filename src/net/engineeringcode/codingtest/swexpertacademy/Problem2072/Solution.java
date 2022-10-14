package net.engineeringcode.codingtest.swexpertacademy.Problem2072;
import java.util.*;

class Solution
{
	/*
	 * SW Expert Academy > CODE > Problem > 2072 > 홀수만 더하기
	 * 문제주소: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 */
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#"+test_case+" ");
            int sum = 0;
            for(int i=0; i<10; i++){
                int currentValue = sc.nextInt();
                if( (currentValue % 2) == 1){
                 	sum = sum+currentValue;
                }
                if(i==9){
                    System.out.print(sum);   
                }
            }
            System.out.println();
		}
	}
}