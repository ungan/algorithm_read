import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] array = new String[n];

		for(int i=0; i<n;i++)
		{
			array[i] = br.readLine();
		}
		
	

		
		Arrays.sort(array, (String e1, String e2) -> {
		    if (e1.length() == e2.length()) {
		        return e1.compareTo(e2);
		    } else {
		        return e1.length() - e2.length();
		    }
		});
		
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(array));
		
		for(String s:linkedHashSet)
		{
			System.out.println(s);
		}
	}
}

