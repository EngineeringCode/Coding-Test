package net.engineeringcode.codingtest.programmers.HighScoreKit.Sorting.BiggestNumber;
import java.util.*;

public class Solution3 {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 정렬 > 가장 큰 수
	 * https://programmers.co.kr/learn/courses/30/lessons/42746
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 주어진 숫자로 만들 수 있는 가장 큰 숫자를 찾는 문제이다.
	 * 배열을 내림차순 정렬하였다. 자릿수에 따른 대소관계 특성을 고려해 두 자리 이상인 숫자는 가장 높은 자리의 숫자와 비교하도록 하였다.
	 * 내림차순 정렬하였기 때문에 가장 큰 수의 제일 앞자리가 0이면 뒷자리도 모두 0일 것이기에 0으로 처리하는 코드를 만들었다.
	 */
	
    public String solution(int[] numbers) {
        String[] numberStringList = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
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
    	Solution3 solution = new Solution3();
    	
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
