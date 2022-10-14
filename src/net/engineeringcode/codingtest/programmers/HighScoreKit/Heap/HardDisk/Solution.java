package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.HardDisk;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 힙 > 디스크 컨트롤러
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 운영체제 과목을 배우면 나오는 디스크 스케줄링 개념이 간단하게 활용된 문제이다.
	 * 주어진 요청을 처리할 때 각 요청의 처리 시간이 평균적으로 가장 낮을 수 있는 스케줄링을 구현하고 평균 처리 시간을 계산하는 문제이다.
	 * 요청을 정렬하기 위한 소요시간을 줄이기 위해 배열과 우선순위큐를 잘 사용하는 것이 중요하다.
	 */
	
	public int solution(int[][] jobs) {
		int currentTime = 0;
		int totalIndivisualWorkTime = 0;
		
		// 주어진 처리 요청을 처리 시점 기준으로 오름차순 정렬
		LinkedList<int[]> jobList = new LinkedList<>();		
		for(int[] job:jobs) {
			jobList.add(job);
		}		
		Collections.sort(jobList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
		/*
		System.out.print("jobList:");
		for(int[] job:jobList) System.out.print("{"+job[0]+","+job[1]+"}");
		System.out.println();
		*/
		
		// 우선순위큐로 처리대기 중인 요청을 소요시간을 기준으로 오름차순 정렬
		PriorityQueue<int[]> jobQueue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
		
		while( !jobList.isEmpty() || !jobQueue.isEmpty() ) {	
			// 현재 시점에 처리대기 상태로 우선순위큐에 들어갈 수 있는 요청을 집어 넣음
			while(!jobList.isEmpty() && jobList.peek()[0] <= currentTime) {
				int[] job = jobList.poll();
				jobQueue.offer(job);
			}
			/*
			System.out.print("jobQueue:");
			for(int[] job:jobQueue) System.out.print("{"+job[0]+","+job[1]+"}");
			System.out.println();
			*/
			
			// 처리대기 중인 요청이 없다면 남아 있는 요청이 요구한 시점으로 바로 넘어감
			if(jobQueue.isEmpty()) {
				currentTime = jobList.peek()[0];
				continue;
			}
			// 처리대기 중인 요청이 있다면 처리
			if(!jobQueue.isEmpty()) {
				int[] job = jobQueue.poll();
				currentTime += job[1];
				totalIndivisualWorkTime += currentTime - job[0];
			}
		}
		
		// 처리 요구사항에 소수점은 버리는 것이 있음. 자바에서는 기본적으로 정수형은 소수점을 버리기에 사용하지 않음.
		//return (int) Math.floor(totalIndivisualWorkTime/jobs.length);
		return totalIndivisualWorkTime/jobs.length;		
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
    	int answerCorrect = 9;
		int answerReturned = -1;
		
		answerReturned = solution.solution(jobs);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		// 내가 추가한 테스트 케이스
		jobs = new int[][]{{0, 3}, {0, 9}, {0, 6}};
    	answerCorrect = 10;
		answerReturned = -1;
		
		answerReturned = solution.solution(jobs);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		// 내가 추가한 테스트 케이스
		jobs = new int[][]{{0, 1}, {6, 1}};
    	answerCorrect = 1;
		answerReturned = -1;
		
		answerReturned = solution.solution(jobs);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
		
		// 내가 추가한 테스트 케이스
		jobs = new int[][]{{0, 8}, {3, 5}, {3, 3}}; // 8, 11-3 8, 16-3 13
    	answerCorrect = 9;
		answerReturned = -1;
		
		answerReturned = solution.solution(jobs);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 4 PASS");
		}else {
			System.out.println("CASE 4 FAIL");
		}
		
		// 내가 추가한 테스트 케이스
		jobs = new int[][]{{1, 1}, {0, 7}};
    	answerCorrect = 7;
		answerReturned = -1;
		
		answerReturned = solution.solution(jobs);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 4 PASS");
		}else {
			System.out.println("CASE 4 FAIL");
		}
	}
}
