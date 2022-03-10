package net.engineeringcode.codingtest.programmers.HighScoreKit.BruteForce.Carpet;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ����Ž�� > ī��
	 * https://programmers.co.kr/learn/courses/30/lessons/42842
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �����ڸ��� ���� brown �� ���� ���� yellow �� �迭�� ũ�⸦ ���ϴ� �����̴�.
	 */
	
    public int[] solution(int brown, int yellow) {
        int totalBlockCount = brown + yellow;
        int row = 0;
        int col = 0;
        
        for(row=2; row<=totalBlockCount; ){
            row++;
            col=totalBlockCount/row;                
            if( col>=row && yellow == (row-2)*(col-2) && brown == (col*2+(row-2)*2) ){
                break;
            }
        }
        
        int[] answer = {col, row};
        return answer;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int brown = 10;
    	int yellow = 2;
    	int[] answerCorrect = new int[] {4, 3};
		int[] answerReturned = null;		
		
		answerReturned = solution.solution(brown, yellow);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		brown = 8;
    	yellow = 1;
    	answerCorrect = new int[] {3, 3};
		answerReturned = null;		
		
		answerReturned = solution.solution(brown, yellow);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		brown = 24;
    	yellow = 24;
    	answerCorrect = new int[] {8, 6};
		answerReturned = null;		
		
		answerReturned = solution.solution(brown, yellow);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)){
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
	}
}
