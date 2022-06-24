package net.engineeringcode.codingtest.programmers.HighScoreKit.DynamicProgramming.N;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ������ȹ��(Dynamic Programming) > N���� ǥ��
	 * https://programmers.co.kr/learn/courses/30/lessons/42895
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �ؼ�: https://small-stap.tistory.com/65
	 * '���� �Ѱ���'���� �ۼ��Ͻ� �ؼ��� �ҽ��ڵ带 �����߽��ϴ�.
	 */
	
    public int solution(int N, int number) {
        int answer = -1;
        
        ArrayList<Set<Integer>> setList = new ArrayList<>();
        
        for(int i=0; i<9; i++) {
        	setList.add(new HashSet<>());
        }
        
        for(int i=1; i<9; i++) {
        	if(i==1) {
        		setList.get(1).add(N);
        		continue;
        	}
        	Set<Integer> countSet = setList.get(i);
        	
        	for(int j=1; j<=i; j++) {
        		Set<Integer> preSet = setList.get(j);
        		Set<Integer> postSet = setList.get(i-j);
        		
        		for(int preNumber: preSet) {
        			for(int postNumber: postSet) {
        				countSet.add(preNumber + postNumber);
        				countSet.add(preNumber - postNumber);
        				countSet.add(preNumber * postNumber);
        				
        				if(preNumber != 0 && postNumber != 0) {
        					countSet.add(preNumber/postNumber);
        				}
        			}
        		}
        	}
        	
        	countSet.add(Integer.parseInt(String.valueOf(N).repeat(i))); // repeat()�� �ڹ� 11�� �߰��� �޼����Դϴ�. ���α׷��ӽ��� �ڹ� 14 ȯ�濡�� �����ϴ� �� �޼��带 ����� �� �ֽ��ϴ�.
        }
        
        for(Set<Integer> subSet : setList) {
        	if(subSet.contains(number)) {
        		answer = setList.indexOf(subSet);
        		break;
        	}
        }
        
        return answer;
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int N = 5;
    	int number = 12;
    	int answerCorrect = 4;
    	int answerReturned = -9999;
		
		answerReturned = solution.solution(N, number);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
    	N = 5;
    	number = 31168;
    	answerCorrect = -1;
    	answerReturned = -9999;
		
		answerReturned = solution.solution(N, number);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
    }
}