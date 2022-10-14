package net.engineeringcode.codingtest.programmers.SummerWinterCoding2018.PrimeNumber;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > Summer/Winter Coding(~2018) > 소수 만들기
	 * https://programmers.co.kr/learn/courses/30/lessons/12977
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 입력의 개수와 자연수 범위가 작으므로 완전 탐색으로 빠르게 답을 작성하는 것이 유리합니다.
	 */

	public int solution(int[] nums) {
		int answer = 0;
        int a, b, c;

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                for(int k=j;k<nums.length;k++){
                    if(i==j || i==k || j==k){
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k];
                    //System.out.println(sum);
                    if(isPrime(sum))
                        answer++;
                }
            }
        }

        return answer;
    }
    
	boolean isPrime(int number){
        if(number == 1)
            return false;
        for(int i=2;i<number;i++){
            if(number%i == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] nums = new int[]{1, 2, 3, 4};
		int answerCorrect = 1;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(nums);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
    	nums = new int[]{1, 2, 7, 6, 4};
		answerCorrect = 4;
		answerReturned = -1;		
		
		answerReturned = solution.solution(nums);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
	}
    
}
