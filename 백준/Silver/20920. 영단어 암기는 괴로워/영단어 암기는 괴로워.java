import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strArr = br.readLine().split(" ");
		int n = Integer.parseInt(strArr[0]);
		int m = Integer.parseInt(strArr[1]);
		PriorityQueue<Word> words = new PriorityQueue<>(); 
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++){
            String str = br.readLine();
            if(str.length() < m) continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
		}
		for(String key : map.keySet()){
		    words.offer(new Word(key, map.get(key)));
		}
		
		while(!words.isEmpty()){
		    sb.append(words.poll().word).append("\n");
		}
		System.out.println(sb);
	}
	static class Word implements Comparable{
	    String word;
	    int count;
	    public Word(String word, int count){
	        this.word = word;
	        this.count = count;
	    }
	    
	    @Override
	    public int compareTo(Object o){
	        Word w = (Word)o;
	        if(w.count != this.count) return w.count - this.count;
	        if(this.word.length() != w.word.length()) return w.word.length() - this.word.length();
	        return this.word.compareTo(w.word);
	        
	    }
	}
}
