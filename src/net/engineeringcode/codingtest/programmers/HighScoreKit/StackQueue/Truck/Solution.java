package net.engineeringcode.codingtest.programmers.HighScoreKit.StackQueue.Truck;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > ����/ť > �ٸ��� ������ Ʈ��
	 * https://programmers.co.kr/learn/courses/30/lessons/42583
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * ��� ���� Ʈ�� ��ϰ� �޸��� �ִ� Ʈ�� ����� ť�� �����Ͽ� �ذ��Ͽ���.
	 * ������ ��õǾ� ���� ������ ����� ���� �������� �߷��ϸ� Ʈ���� �ʴ� 1�� �Ÿ��� �̵��Ѵ�.
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
    	
    	// ��� ���� Ʈ�� ����� ������� ť�� �ִ´�.
    	for(int i=0;i<truck_weights.length;i++) {
    		truckWaitingList.add(new Truck(0, truck_weights[i]));
    	}
    	
    	// �ݺ��� 1ȸ�� 1��
    	while(true) {  
        	//printDrivingTruckList();
        	//printWaitingTruckList();
    		answer++;
    		//System.out.println("answer:"+answer);
    		
    		// �ٸ� ���� �ִ� Ʈ���� �ʴ� 1�� �̵� ��Ų��.
        	for(Truck truck:truckDrivingList) {
        		truck.distance++;
        	}
        	
        	// Ʈ���� �ٸ��� �ǳ����� �ǳʰ� �ִ� ��Ͽ��� ����.
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
    		// Ʈ���� �ǳ� �� ������ �ǳʴ� ��Ͽ� �߰��Ѵ�.
        	if( !truckWaitingList.isEmpty() 
    			&& truckWaitingList.getFirst().weight <= maximumTotalWeight-currentTotalWeight ) {
        		Truck truck = truckWaitingList.removeFirst();
        		currentTotalWeight += truck.weight;
        		truck.distance++;
        		truckDrivingList.add(truck);
        	}
    		  		
        	// Ʈ���� �� �ǳ����� �����Ѵ�.
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
