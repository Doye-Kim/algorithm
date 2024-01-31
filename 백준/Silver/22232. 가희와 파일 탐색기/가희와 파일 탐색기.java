import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
	static int n, m;
	static Set<String> extensions = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<File> pq = new PriorityQueue<>();

		String[] a = br.readLine().split(" ");
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		String[] files = new String[n];
		for (int i = 0; i < n; i++) {
			files[i] = br.readLine();
		}
		for(int i = 0; i < m; i++) {
			extensions.add(br.readLine());
		}
		//System.out.println(Arrays.toString(files));
		for (int i = 0; i < n; i++) {
			String[] b = files[i].split("\\.");
			//System.out.println(b[0] + " " + b[1]);
			pq.add(new File(b[0], b[1]));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			File f = pq.poll();
			sb.append(f.filename + "." + f.extension + "\n");
		}
		System.out.println(sb);
	}


	static class File implements Comparable<File> {
		String filename, extension;
		public File(String filename, String extension) {
			this.filename = filename;
			this.extension = extension;
		}
		public int compare(File o1, File o2) {
			int result = (o1.filename).compareTo(o2.filename);
			if(result == 0) {
				return includeExtension(o1.extension, o2.extension);
			}
			return result;
		}
		@Override
		public int compareTo(File o) {
			int result = (filename).compareTo(o.filename);
			if(result == 0) {
				return includeExtension(extension, o.extension);
			}
			return result;
		}
	}
	 public static int includeExtension(String o1, String o2) {
		if((extensions.contains(o1) && extensions.contains(o2)) || (!extensions.contains(o1) && !extensions.contains(o2))) return o1.compareTo(o2);
		else if(extensions.contains(o1) && !extensions.contains(o2)) return -1;
		else return 1;
	}
}
