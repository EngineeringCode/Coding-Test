package net.engineeringcode.codingtest.HackerRank.InterviewPreparationKit.WarmUp.RepeatedString;
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
 * Prepare > Interview Preparation Kit > Warm-up Challenges > Repeated String
 * 문제 주소: https://www.hackerrank.com/challenges/sock-merchant/problem
 * 해설 주소: 
 * 
 * 프로그램 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 * 문자 a 가 문자열에 몇개 포함되어 있는지 세는 문제이다.
 * 시간 초과(Time limit exceeded)를 해결하기 위해 일일이 다 세지 않고 반복되는 횟수를 계산하여 연산량을 줄였다.
 */

class Result2 {

    public static long repeatedString(String s, long n) {
        long countContainA = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a'){
                countContainA++;
            }
        }
        long countRepeated = n/s.length();
        long residualN = n - countRepeated * s.length();
        long answer = countContainA * countRepeated;
        
        for(int i=0; i<residualN; i++){
            if(s.charAt(i) == 'a'){
                answer++;
            }
        }       
        
        return answer;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result2.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
