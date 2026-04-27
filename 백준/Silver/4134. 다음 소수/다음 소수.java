import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;// = new StringTokenizer(br.readLine());
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	long n;
    	
    	for(int i=0; i<T; i++) {
    		n = Long.parseLong(br.readLine());
    		BigInteger bigInt = new BigInteger(String.valueOf(n));
    		
    		if(bigInt.isProbablePrime(10)) {
    			System.out.println(bigInt);
    		}
    		else {
    			System.out.println(bigInt.nextProbablePrime());
    		}
    			
    	}
    	
    	bw.flush();
    	bw.close();
    	br.close();
    }
}
