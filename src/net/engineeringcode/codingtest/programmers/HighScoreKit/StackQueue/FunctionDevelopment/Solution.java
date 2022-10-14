package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.FunctionDevelopment;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 스택/큐 > 기능개발
	 * https://programmers.co.kr/learn/courses/30/lessons/42586
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 */
    public int[] solution(int[] progresses, int[] speeds) {
        int totalWorkCount = progresses.length;
        int totalDeplyedWorkCount = 0;
        int todaysDeployedWorkCount = 0;
        int nextDeployedIndex = 0;
        Queue<Integer> deployedCountList = new LinkedList<Integer>();
        
        while(true){
            todaysDeployedWorkCount = 0;
            // 다 배포했으면 반복을 그만(탈출)한다.
            if(totalDeplyedWorkCount >= totalWorkCount){
                break;
            }
            // 어제 진척도에 오늘 진행량을 더한다.
            for(int i=0;i<totalWorkCount;i++){
            	if(progresses[i] == -1 || progresses[i] == -2) {
            		continue;
            	}
                progresses[i] += speeds[i];
                if(progresses[i] >= 100){
                	//System.out.println("progresses["+i+"] is Finished.");
                    progresses[i] = -1;
                }
            }
            // 작업이 완료된 것이 있는지 확인한다.
            for(int i=0;i<totalWorkCount;i++){
                if( (progresses[i] == -1) && (nextDeployedIndex == i) ){ // 이 작업이 배포되는 순서라면 배포한다.
                	//System.out.println("progresses["+i+"] is Deployed.");
                	todaysDeployedWorkCount++;
                    progresses[i] = -2;
                    nextDeployedIndex++; 
                }
            }
            // 오늘 배포한 작업이 있는지 확인한다.
            if(todaysDeployedWorkCount>0) {
                //System.out.println(todaysDeployedWorkCount+" is(are) Deployed.");
                totalDeplyedWorkCount += todaysDeployedWorkCount;
            	//System.out.println("todaysDeployedWorkCount:"+todaysDeployedWorkCount);
            	deployedCountList.add(todaysDeployedWorkCount);
            }
        }
        
        int[] answer = new int[deployedCountList.size()];
        // 배포했던 갯수를 순서대로 답안에 입력한다.
        for(int i=0;i<answer.length;i++){
            answer[i] = deployedCountList.poll();
        }
        
        return answer;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] progresses = new int[]{93, 30, 55};
    	int[] speeds = new int[]{1, 30, 5};
		int[] answerCorrect = new int[]{2, 1};
		int[] answerReturned = null;		
		
		answerReturned = solution.solution(progresses, speeds);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
    	progresses = new int[]{95, 90, 99, 99, 80, 99};
    	speeds = new int[]{1, 1, 1, 1, 1, 1};
		answerCorrect = new int[]{1, 3, 2};
		answerReturned = null;		
		
		answerReturned = solution.solution(progresses, speeds);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
	}
    
}
