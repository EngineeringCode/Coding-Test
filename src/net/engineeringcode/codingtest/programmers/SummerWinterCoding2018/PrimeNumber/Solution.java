package net.engineeringcode.codingtest.programmers.SummerWinterCoding2018.PrimeNumber;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > Summer/Winter Coding(~2018) > �Ҽ� �����
	 * https://programmers.co.kr/learn/courses/30/lessons/12977
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �Է��� ������ �ڿ��� ������ �����Ƿ� ���� Ž������ ������ ���� �ۼ��ϴ� ���� �����մϴ�.
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
