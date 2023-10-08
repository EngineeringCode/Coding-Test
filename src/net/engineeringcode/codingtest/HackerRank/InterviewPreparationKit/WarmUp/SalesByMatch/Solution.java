package net.engineeringcode.codingtest.HackerRank.InterviewPreparationKit.WarmUp.SalesByMatch;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
 * Prepare > Interview Preparation Kit > Warm-up Challenges > Sales by Match
 * 문제 주소: https://www.hackerrank.com/challenges/sock-merchant/problem
 * 해설 주소: 
 * 
 * 프로그램 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 */

class Result {
    public static int sockMerchant(int n, List<Integer> ar) {
        int answer = 0;
        Collections.sort(ar);
        
        int previousNumber = 0;
        for(int i=0; i<n; i++){
            int currentNumber = ar.get(i);
            if(previousNumber == currentNumber){
                answer++;
                previousNumber = 0;
                continue;
            }            
            previousNumber = currentNumber;
        }
        
        return answer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt("9".trim());

        List<Integer> ar = Stream.of("10 20 20 10 10 30 50 10 20".replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int answerCorrect = 3;
		int answerReturned = Result.sockMerchant(n, ar); 
        
        System.out.println("Returned Value == " + answerCorrect);
		System.out.println("Expected Value == " + answerReturned);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		} else {
			System.out.println("CASE 1 FAIL");
		}
    }
}
