package net.engineeringcode.codingtest.programmers.HighScoreKit.BruteForce.Rectangle;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 완전탐색 > 최소직사각형
	 * 문제 주소: https://school.programmers.co.kr/learn/courses/30/lessons/86491
	 * 해설 주소: https://engineeringcode.tistory.com/411
	 * 
	 * 프로그램 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 */
	
	public int solution(int[][] sizes) {
        int width = 1;
        int height = 1;
        
        for(int i=0; i<sizes.length; i++){
            int logest_line = Math.max(sizes[i][0],sizes[i][1]);
            int shortest_line = Math.min(sizes[i][0],sizes[i][1]);
            
            width = Math.max(width, logest_line);
            height = Math.max(height, shortest_line);
        }
        
        return width*height;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[][] sizes = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};
    	int answerCorrect = 4000;
		int answerReturned = 0;		
		
		answerReturned = solution.solution(sizes);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		} else {
			System.out.println("CASE 1 FAIL");
		}
		
		sizes = new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
    	answerCorrect = 120;
		answerReturned = 0;		
		
		answerReturned = solution.solution(sizes);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		} else {
			System.out.println("CASE 2 FAIL");
		}
		
		sizes = new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
    	answerCorrect = 133;
		answerReturned = 0;		
		
		answerReturned = solution.solution(sizes);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
	}
}
