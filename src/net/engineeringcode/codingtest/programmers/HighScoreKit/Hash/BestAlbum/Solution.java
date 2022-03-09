package net.engineeringcode.codingtest.programmers.HighScoreKit.Hash.BestAlbum;
import java.util.*;

public class Solution {
	/*
	 * ���α׷��ӽ� > �ڵ��׽�Ʈ ���� > �ؽ� > ����Ʈ�ٹ�
	 * https://programmers.co.kr/learn/courses/30/lessons/42579
	 * �ۼ���: �����ڵ�(engineeringcode93@gmail.com)
	 * �� ���� ����� �帣���� �� ���� ����� �뷡�� 2���� ��ȿ� �Է��Ѵ�. �� �帣�� �뷡�� �ϳ��� �ִ� ��쵵 �ִ�.
	 * ������ �䱸�� ���� �帣�� �뷡������ �����ϰ� �����ϰ� �����ϴ� ���� �߿��ϴ�.
	 */
	
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Genre> genreHashMap = new HashMap<>();
		HashMap<String, ArrayList<Music>> musicHashMap = new HashMap<>();
		
		// �帣���� ��� Ƚ���� ��� ���� ����� �ؽø����� ����
		for(int i=0;i<genres.length;i++) {
			// �帣 ���� �߰�
			if(genreHashMap.getOrDefault(genres[i], null) == null) {
				genreHashMap.put(genres[i], new Genre(genres[i], 0, 0));
			}
			Genre genre = genreHashMap.get(genres[i]);
			genreHashMap.put(genres[i], new Genre(genre.name, genre.playCount+plays[i], genre.musicCount+1));
			
			// �帣�� �뷡 ���� �߰�
			if(musicHashMap.getOrDefault(genres[i], null) == null) {
				musicHashMap.put(genres[i], new ArrayList<>());
			}			
			ArrayList<Music> musicListSameGenre = musicHashMap.get(genres[i]);
			musicListSameGenre.add(new Music(i, plays[i]));
		}
		
		// �帣 ����� �÷��� ���� ���� �������� ����
		ArrayList<Genre> genreListSorted = new ArrayList<>();
		for(String key:genreHashMap.keySet()) {
			genreListSorted.add(genreHashMap.get(key));
		}
		Collections.sort(genreListSorted, Collections.reverseOrder());
		
		// �� ���� ����� �帣���� �� ���� ����� �뷡�� 2���� ��ȿ� �Է��Ѵ�. �� �帣�� �뷡�� �ϳ��� �ִ� ��쵵 �ִ�.
		ArrayList<Integer> answerList = new ArrayList<>();
		for(int i=0;i<genreHashMap.size();i++) {
			// �뷡 ����� �÷��� ���� ���� �������� ����
			ArrayList<Music> musicListSameGenre = musicHashMap.get(genreListSorted.get(i).name);
			Collections.sort(musicListSameGenre, Collections.reverseOrder());
			// �� ����Ʈ�� �Է�
			for(int j=0; j<musicListSameGenre.size() && j<2; j++) {
				answerList.add(musicListSameGenre.get(j).id);
			}
		}
		
		// ����Ʈ�� ��� ���� �䱸�� ���� int�迭�� ����
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
			// �帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
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
			// �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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
		
		// ���� �߰��� �׽�Ʈ ���̽�
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
