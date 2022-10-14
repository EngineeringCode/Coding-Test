package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.BestAlbum;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 해시 > 베스트앨범
	 * https://programmers.co.kr/learn/courses/30/lessons/42579
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 더 많이 재생된 장르부터 더 많이 재생된 노래를 2개씩 답안에 입력한다. 한 장르에 노래가 하나만 있는 경우도 있다.
	 * 문제의 요구에 따라 장르와 노래정보를 가공하고 적절하게 정렬하는 것이 중요하다.
	 */
	
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Genre> genreHashMap = new HashMap<>();
		HashMap<String, ArrayList<Music>> musicHashMap = new HashMap<>();
		
		// 장르별로 재생 횟수가 담긴 음악 목록을 해시맵으로 생성
		for(int i=0;i<genres.length;i++) {
			// 장르 정보 추가
			if(genreHashMap.getOrDefault(genres[i], null) == null) {
				genreHashMap.put(genres[i], new Genre(genres[i], 0, 0));
			}
			Genre genre = genreHashMap.get(genres[i]);
			genreHashMap.put(genres[i], new Genre(genre.name, genre.playCount+plays[i], genre.musicCount+1));
			
			// 장르에 노래 정보 추가
			if(musicHashMap.getOrDefault(genres[i], null) == null) {
				musicHashMap.put(genres[i], new ArrayList<>());
			}			
			ArrayList<Music> musicListSameGenre = musicHashMap.get(genres[i]);
			musicListSameGenre.add(new Music(i, plays[i]));
		}
		
		// 장르 목록을 플레이 수에 따라 내림차순 정렬
		ArrayList<Genre> genreListSorted = new ArrayList<>();
		for(String key:genreHashMap.keySet()) {
			genreListSorted.add(genreHashMap.get(key));
		}
		Collections.sort(genreListSorted, Collections.reverseOrder());
		
		// 더 많이 재생된 장르부터 더 많이 재생된 노래를 2개씩 답안에 입력한다. 한 장르에 노래가 하나만 있는 경우도 있다.
		ArrayList<Integer> answerList = new ArrayList<>();
		for(int i=0;i<genreHashMap.size();i++) {
			// 노래 목록을 플레이 수에 따라 내림차순 정렬
			ArrayList<Music> musicListSameGenre = musicHashMap.get(genreListSorted.get(i).name);
			Collections.sort(musicListSameGenre, Collections.reverseOrder());
			// 답 리스트에 입력
			for(int j=0; j<musicListSameGenre.size() && j<2; j++) {
				answerList.add(musicListSameGenre.get(j).id);
			}
		}
		
		// 리스트에 담긴 답을 요구에 따라 int배열로 가공
		int[] answer = new int[answerList.size()];
		for(int i=0; i<answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}		
        return answer;
    }
	
	class Genre implements Comparable<Genre>{
		public String name;
		public int playCount;
		public int musicCount;
		
		Genre(String name, int playCount, int musicCount){
			this.name = name;
			this.playCount = playCount;
			this.musicCount = musicCount;
		}

		@Override
		public int compareTo(Genre genre) {
			// 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
			if (this.playCount < genre.playCount) {
				return -1;
			} else if (this.playCount == genre.playCount) {
				return 0;
			} else {
				return 1;
			}
		}
	}
		
	class Music implements Comparable<Music>{
		public int id;
		public int playCount;
		
		Music(int id, int playCount){
			this.id = id;
			this.playCount = playCount;
		}

		@Override
		public int compareTo(Music music) {
			// 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
			if (this.playCount < music.playCount) {
				return -1;
			} else if (this.playCount == music.playCount) {
				if (this.id < music.id) {
					return 1;
				} else if (this.id == music.id) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return 1;
			}
		}
	}
    
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	String[] genres = new String[] {"classic", "pop", "classic", "classic", "pop"};
    	int[] plays = new int[] {500, 600, 150, 800, 2500};
    	int[] answerCorrect = new int[]{4, 1, 3, 0};
		int[] answerReturned = null;		
		
		answerReturned = solution.solution(genres, plays);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		// 내가 추가한 테스트 케이스
		genres = new String[] {"classic", "pop", "classic", "classic"};
    	plays = new int[] {500, 1000, 100, 200};
    	answerCorrect = new int[]{1, 0, 3};
		answerReturned = null;		
		
		answerReturned = solution.solution(genres, plays);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		// 내가 추가한 테스트 케이스
		genres = new String[] {"classic", "pop", "jpop", "classic"};
    	plays = new int[] {500, 1000, 100, 200};
    	answerCorrect = new int[]{1, 0, 3, 2};
		answerReturned = null;		
		
		answerReturned = solution.solution(genres, plays);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
		
		// 내가 추가한 테스트 케이스
		genres = new String[] {"classic"};
    	plays = new int[] {500};
    	answerCorrect = new int[]{0};
		answerReturned = null;		
		
		answerReturned = solution.solution(genres, plays);
		
		System.out.println("Returned Value == " + Arrays.toString(answerReturned));
		System.out.println("Expected Value == " + Arrays.toString(answerCorrect));
		
		if(Arrays.equals(answerCorrect, answerReturned)) {
			System.out.println("CASE 4 PASS");
		}else {
			System.out.println("CASE 4 FAIL");
		}
	}
}
