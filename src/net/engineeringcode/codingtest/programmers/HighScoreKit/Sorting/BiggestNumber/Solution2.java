package net.engineeringcode.codingtest.programmers.HighScoreKit.Sorting.BiggestNumber;
import java.util.*;

public class Solution2 {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ���� > ���� ū ��
	 * https://programmers.co.kr/learn/courses/30/lessons/42746
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �־��� ���ڷ� ���� �� �ִ� ���� ū ���ڸ� ã�� �����̴�.
	 * �迭�� �������� �����Ͽ���. �ڸ����� ���� ��Ұ��� Ư���� ����� �� �ڸ� �̻��� ���ڴ� ���� ���� �ڸ��� ���ڿ� ���ϵ��� �Ͽ���.
	 * ���ʿ��� ������ ���̱� ���� ���� ū ���� ���� ���ڸ��� 0�̸�� 0���� ó���ϴ� ����� Solution3���� �ٷ����.
	 */
	
	public String solution(int[] numbers) {
        String[] numberStringList = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            //numberStringList[i] = Integer.toString(numbers[i]);
            numberStringList[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numberStringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        StringBuilder answer = new StringBuilder();
        for(String number:numberStringList){
            answer.append(number);
        }
        if(answer.charAt(0) == '0'){
            return "0";
        }  
        
        return answer.toString();
    }
    
    public static void main(String[] args) { 
    	Solution2 solution = new Solution2();
    	
    	int[] numbers = new int[] {6, 10, 2};
    	String answerCorrect = "6210";
    	String answerReturned = null;		
		
		answerReturned = solution.solution(numbers);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect.equals(answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		numbers = new int[] {3, 30, 34, 5, 9};
    	answerCorrect = "9534330";
    	answerReturned = null;		
		
		answerReturned = solution.solution(numbers);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect.equals(answerReturned)) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
	}
}
