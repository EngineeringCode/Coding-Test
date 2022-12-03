package net.engineeringcode.codingtest.HackerRank.InterviewPreparationKit.DictionaryHashmap.RansomNote;
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
 * Prepare > Interview Preparation Kit > Dictionaries and Hashmaps > Hash Tables: Ransom Note
 * 문제 주소: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 * 해설 주소: 
 * 
 * 프로그램 작성자: 공학코드(engineeringcode93@gmail.com)
 * 
 */

class Result {
    public static void checkMagazine(List<String> magazine, List<String> note) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<magazine.size(); i++){
            map.put(magazine.get(i), map.getOrDefault(magazine.get(i), 0)+1);
        }
        
        for(int i=0; i<note.size(); i++){
            if(map.get(note.get(i))==null){
                System.out.println("No");
                return;
            }
            
            if(map.get(note.get(i))==1) {
                map.remove(note.get(i));
            } else {
                map.put(note.get(i), map.get(note.get(i))-1);
            }
        }
        
        System.out.println("Yes");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
