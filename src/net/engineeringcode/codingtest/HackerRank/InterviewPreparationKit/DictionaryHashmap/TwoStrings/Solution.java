package net.engineeringcode.codingtest.HackerRank.InterviewPreparationKit.DictionaryHashmap.TwoStrings;
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
 * Prepare > Interview Preparation Kit > Dictionaries and Hashmaps > Two Strings
 * 문제 주소: https://www.hackerrank.com/challenges/two-strings/problem
 * 해설 주소: 
 * 
 * 프로그램 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 */

class Result {
    public static String twoStrings(String s1, String s2) {
        HashMap<String, String> map = new HashMap<>();
        String[] arr1 = s1.split("");
        for(String str: arr1){
            map.put(str, "");
        }
        
        String[] arr2 = s2.split("");
        for(String str: arr2){
            if(map.get(str) != null){
                return "YES";
            }
        }
        
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
