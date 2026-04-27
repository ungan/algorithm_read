import java.io.*;
import java.util.*;

class Main {

    static int[] tree_distance;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int start=0;

        //tree_distance = new ArrayList<>();

       
        tree_distance = new int[N-1];
        

        for(int i=0; i<N; i++)
        {
            if(start == 0)
            {
                start = Integer.parseInt(br.readLine());
                continue;
            }
            int num = Integer.parseInt(br.readLine());
            tree_distance[i-1] = num -start;
            start = num;
        }

        int g= gcd(tree_distance[0], tree_distance[1]);

        for(int i=2; i<tree_distance.length; i++)
        {
            if(tree_distance[i] % g != 0) g = gcd(tree_distance[i], g);
            
        }

        int total=0;

        for(int i : tree_distance)
        {
            total += i/g-1;
            //System.out.println(i/g + " " + total);
        }

        bw.write(Integer.toString(total));
        bw.flush();
        bw.close();
        br.close();
    }

    static int gcd(int a, int b)
    {
        while(b!=0)
        {
            int r = a%b;
            a = b;
            b = r;
        }

        return a;
    }
}