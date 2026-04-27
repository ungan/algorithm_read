import java.io.*;
import java.util.*;

class Main {
	static int code1_count = 0;
	static int code2_count = 0;
	static int f[] = new int[41];
	static HashMap<String, Integer> hash = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(true)
        {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	if(a==-1 && b==-1 && c==-1) break;
        	
        	sb.append("w("+a+", "+b+", "+c+") = " +w(a,b,c)+"\n");
        	//System.out.println("w("+a+", "+b+", "+c+") = " +w(a,b,c));
        	
        }
        
        System.out.println(sb);
        //bw.write();
//        bw.flush();
//        bw.close();
//        br.close();

    }
    
    public static int w(int a, int b, int c)
    {
    	String key = a + " " + b + " " + c;
    	if(hash.containsKey(key)) return hash.get(key);
    	
    	if(a<=0 || b<=0 || c<=0) 
		{
    		hash.put(key, 1);
    		return 1;
		}
    	else if(a>20 || b>20 || c>20) {
    		if(hash.containsKey(20+" "+20+" "+20)) return hash.get(20+" "+20+" "+20);
    		
    		return w(20,20,20);
    	}
    	else if(a<b && b<c) 
		{
    		int total=0;
    		
    		if(hash.containsKey(a+" "+b+" "+(c-1))) total += hash.get(a+" "+b+" "+(c-1));
    		else {
    			int t = w(a,b,c-1);
    			hash.put(a+" "+b+" "+(c-1), t);
    			total += t;
    		}
    			
			if(hash.containsKey(a+" "+(b-1)+" "+(c-1)))  total += hash.get(a+" "+(b-1)+" "+(c-1));
			else {
				int t = w(a,b-1,c-1);
    			hash.put(a+" "+(b-1)+" "+(c-1), t);
				total += t;
			}
				
			if(hash.containsKey(a+" "+(b-1)+" "+c)) total -= hash.get(a+" "+(b-1)+" "+c);
			else {
				int t = w(a,b-1,c);
    			hash.put(a+" "+(b-1)+" "+c, t);
				total -=  t;
			}
    					
    		return total;
		}
    	else
    	{
    		int total=0;
    		
    		if(hash.containsKey((a-1)+" "+b+" "+c)) total += hash.get((a-1)+" "+b+" "+c);
    		else {
    			int t = w(a-1,b,c);
    			hash.put((a-1)+" "+b+" "+c, t);
    			total += t;
    		}
    			
			if(hash.containsKey((a-1)+" "+(b-1)+" "+c))  total += hash.get((a-1)+" "+(b-1)+" "+c);
			else {
				int t = w(a-1,b-1,c);
    			hash.put((a-1)+" "+(b-1)+" "+c, t);
				total += t;
			}
				
			if(hash.containsKey((a-1)+" "+b+" "+(c-1))) total += hash.get((a-1)+" "+b+" "+(c-1));
			else {
				int t = w(a-1, b, c-1);
    			hash.put((a-1)+" "+b+" "+(c-1), t);
				total += t;
			}
    			
			if(hash.containsKey((a-1)+" "+(b-1)+" "+(c-1))) total -= hash.get((a-1)+" "+(b-1)+" "+(c-1));
			else {
				int t = w(a-1,b-1,c-1);
    			hash.put((a-1)+" "+(b-1)+" "+(c-1), t);
				total -= w(a-1,b-1,c-1);
			}
			
    		return total;
    		
    		//return w(a-1,b,c) + w(a-1,b-1,c) + w(a-1, b, c-1) -w(a-1,b-1,c-1);
    	}
    	

    }
    
}