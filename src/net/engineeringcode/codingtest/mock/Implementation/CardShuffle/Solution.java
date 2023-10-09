package net.engineeringcode.codingtest.mock.Implementation.CardShuffle;
import java.util.*;

public class Solution {
	/*
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 */

	public int[] solution(int[] cards, String[] shuffles) {
        LinkedList<Integer> list = new LinkedList<>();   
        for(int card : cards){
            list.add(card);
        }
        LinkedList<Integer> currentCards = list;

        for(String cmd : shuffles){
            if(cmd.equals("Cut")){
                currentCards = cut(currentCards);
            }else if(cmd.equals("Riffle")){
                currentCards = riffle(currentCards);
            }
        }

        return currentCards.stream().mapToInt(i->i).toArray();
    }

    public LinkedList<Integer> cut(LinkedList<Integer> cards){
        LinkedList<Integer> newCards = new LinkedList<>();
        for(int i=cards.size()/2; i<cards.size(); i++){
            newCards.add(cards.get(i));
        }        
        for(int i=0;i<cards.size()/2;i++){
            newCards.add(cards.get(i));
        }
        return newCards;
    }

    public LinkedList<Integer> riffle(LinkedList<Integer> cards){
        LinkedList<Integer> newCards = new LinkedList<>();
        int mid=cards.size()/2;
        for(int n=0; n<cards.size()/2; n++){            
            newCards.add(cards.get(n+mid));
            newCards.add(cards.get(n));
        }
        return newCards;
    }
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int[] cards = new int[]{1, 2, 3, 4, 5, 6};
    	String[] shuffles = new String[]{"Cut"};
		int[] answerCorrect = new int[]{4, 5, 6, 1, 2, 3};
		int[] answerReturned = null;		
		
		answerReturned = solution.solution(cards, shuffles);
		
		System.out.println("Returned Value == " + Arrays.toString(answerCorrect));
		System.out.println("Expected Value == " + Arrays.toString(answerReturned));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		cards = new int[]{1, 2, 3, 4, 5, 6};
    	shuffles = new String[]{"Cut", "Cut"};
		answerCorrect = new int[]{1, 2, 3, 4, 5, 6};
		answerReturned = null;		
		
		answerReturned = solution.solution(cards, shuffles);
		
		System.out.println("Returned Value == " + Arrays.toString(answerCorrect));
		System.out.println("Expected Value == " + Arrays.toString(answerReturned));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		cards = new int[]{1, 2, 3, 4, 5, 6};
    	shuffles = new String[]{"Riffle", "Cut"};
		answerCorrect = new int[]{2, 6, 3, 4, 1, 5};
		answerReturned = null;		
		
		answerReturned = solution.solution(cards, shuffles);
		
		System.out.println("Returned Value == " + Arrays.toString(answerCorrect));
		System.out.println("Expected Value == " + Arrays.toString(answerReturned));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
		
		cards = new int[]{1, 2, 3, 4, 5, 6};
    	shuffles = new String[]{"Riffle"};
		answerCorrect = new int[]{4, 1, 5, 2, 6, 3};
		answerReturned = null;		
		
		answerReturned = solution.solution(cards, shuffles);
		
		System.out.println("Returned Value == " + Arrays.toString(answerCorrect));
		System.out.println("Expected Value == " + Arrays.toString(answerReturned));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 4 PASS");
		}else {
			System.out.println("CASE 4 FAIL");
		}		
	}
    
}
