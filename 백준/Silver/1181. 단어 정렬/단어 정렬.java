import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> words = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String w = br.readLine();
			if(words.contains(w)) continue;
			words.add(w);
		}
		words.sort((word1, word2)-> { 
			return word1.length() == word2.length() ? word1.compareTo(word2) : word1.length() - word2.length();
		});
		for(String w : words) {
			System.out.println(w);
		}
	}
}