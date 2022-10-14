package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.Truck;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 스택/큐 > 다리를 지나는 트럭
	 * https://programmers.co.kr/learn/courses/30/lessons/42583
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 대기 중인 트럭 목록과 달리고 있는 트럭 목록을 큐로 관리하여 해결하였다.
	 * 문제에 명시되어 있지 않지만 입출력 예와 설명으로 추론하면 트럭은 초당 1의 거리를 이동한다.
	 */
	
	LinkedList<Truck> truckDrivingList;
	LinkedList<Truck> truckWaitingList;
	int maximumTotalWeight;
	int currentTotalWeight;
	int answer;	
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	truckDrivingList = new LinkedList<>();
    	truckWaitingList = new LinkedList<>();
    	maximumTotalWeight = -1;
    	currentTotalWeight = 0;
    	answer = 0;	
    	maximumTotalWeight = weight;
    	
    	// 대기 중인 트럭 목록을 순서대로 큐에 넣는다.
    	for(int i=0;i<truck_weights.length;i++) {
    		truckWaitingList.add(new Truck(0, truck_weights[i]));
    	}
    	
    	// 반복문 1회에 1초
    	while(true) {  
        	//printDrivingTruckList();
        	//printWaitingTruckList();
    		answer++;
    		//System.out.println("answer:"+answer);
    		
    		// 다리 위에 있는 트럭을 초당 1씩 이동 시킨다.
        	for(Truck truck:truckDrivingList) {
        		truck.distance++;
        	}
        	
        	// 트럭이 다리를 건넜으면 건너고 있는 목록에서 뺀다.
    		if( !truckDrivingList.isEmpty()) {
    			if(truckDrivingList.getFirst().distance > bridge_length) {
        			//Truck truck = truckDrivingList.pollFirst();
        			Truck truck = truckDrivingList.removeFirst();
        			//System.out.println("truck.weight:"+truck.weight);
        			currentTotalWeight -= truck.weight;
                	//System.out.println("maximumTotalWeight:"+maximumTotalWeight);
                	//System.out.println("currentTotalWeight:"+currentTotalWeight);
    			}
    		}
    		
    		//System.out.println("truckWaitingList.getFirst().weight:"+truckWaitingList.getFirst().weight);
    		//System.out.println("currentTotalWeight:"+currentTotalWeight);
    		// 트럭이 건널 수 있으면 건너는 목록에 추가한다.
        	if( !truckWaitingList.isEmpty() 
    			&& truckWaitingList.getFirst().weight <= maximumTotalWeight-currentTotalWeight ) {
        		Truck truck = truckWaitingList.removeFirst();
        		currentTotalWeight += truck.weight;
        		truck.distance++;
        		truckDrivingList.add(truck);
        	}
    		  		
        	// 트럭이 다 건넜으면 종료한다.
    		if(truckDrivingList.isEmpty() && truckWaitingList.isEmpty()) {
    			break;
    		}
    	}
        
        return answer;
    }
    
    class Truck {
    	public int distance = 0;
    	public int weight = -1;
    	
    	Truck(int distance, int weight){
    		this.distance = distance;
    		this.weight = weight;
    	}
    }
    
    void printDrivingTruckList() {
    	System.out.print("truckDrivingList:");
    	for(Truck truck:truckDrivingList) {
    		System.out.print(truck.weight+"("+answer+", "+truck.distance+") ");
    	}
    	System.out.println();
    }
    
    void printWaitingTruckList() {
    	System.out.print("truckWaitingList:");
    	for(Truck truck:truckWaitingList) {
    		System.out.print(truck.weight+"("+answer+", "+truck.distance+") ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int bridge_length = 2;
    	int weight = 10;
    	int[] truck_weights = new int[]{7, 4, 5, 6};
		int answerCorrect = 8;
		int answerReturned = -1;		
		
		answerReturned = solution.solution(bridge_length, weight, truck_weights);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		bridge_length = 100;
    	weight = 100;
    	truck_weights = new int[]{10};
		answerCorrect = 101;
		answerReturned = -1;		
		
		answerReturned = solution.solution(bridge_length, weight, truck_weights);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}		
		
		bridge_length = 100;
		weight = 100;
    	truck_weights = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		answerCorrect = 110;
		answerReturned = -1;		
		
		answerReturned = solution.solution(bridge_length, weight, truck_weights);
		
		System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}	
	}
    
}
