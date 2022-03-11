package net.engineeringcode.codingtest.programmers.HighScoreKit.Heap.HardDisk;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �� > ��ũ ��Ʈ�ѷ�
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �ü�� ������ ���� ������ ��ũ �����ٸ� ������ �����ϰ� Ȱ��� �����̴�.
	 * �־��� ��û�� ó���� �� �� ��û�� ó�� �ð��� ��������� ���� ���� �� �ִ� �����ٸ��� �����ϰ� ��� ó�� �ð��� ����ϴ� �����̴�. 
	 */
	
	public int solution(int[][] jobs) {
		int currentTime = 0;
		int totalIndivisualWorkTime = 0;
		
		// �־��� ó�� ��û�� ó�� ���� �������� �������� ����
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
		
		// �켱����ť�� ó����� ���� ��û�� �ҿ�ð��� �������� �������� ����
		PriorityQueue<int[]> jobQueue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
		
		while( !jobList.isEmpty() || !jobQueue.isEmpty() ) {	
			// ���� ������ ó����� ���·� �켱����ť�� �� �� �ִ� ��û�� ���� ����
			while(!jobList.isEmpty() && jobList.peek()[0] <= currentTime) {
				int[] job = jobList.poll();
				jobQueue.offer(job);
			}
			/*
			System.out.print("jobQueue:");
			for(int[] job:jobQueue) System.out.print("{"+job[0]+","+job[1]+"}");
			System.out.println();
			*/
			
			// ó����� ���� ��û�� ���ٸ� ���� �ִ� ��û�� �䱸�� �������� �ٷ� �Ѿ
			if(jobQueue.isEmpty()) {
				currentTime = jobList.peek()[0];
				continue;
			}
			// ó����� ���� ��û�� �ִٸ� ó��
			if(!jobQueue.isEmpty()) {
				int[] job = jobQueue.poll();
				currentTime += job[1];
				totalIndivisualWorkTime += currentTime - job[0];
			}
		}
		
		// ó�� �䱸���׿� �Ҽ����� ������ ���� ����. �ڹٿ����� �⺻������ �������� �Ҽ����� �����⿡ ������� ����.
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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
