import java.io.*;
import java.util.*;

public class Main {
    
static int[][] delta = {
    {},            // 0
    {},            // 1
    {1, 3},        // 2
    {3, 6},        // 3
    {6, 10, 6, 14, 6, 18},  // 4
    {5, 15}        // 5
};

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int l = Integer.parseInt(br.readLine());
    int r = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    
    int result = 0;
    
    // delta[k]의 길이는 짝수여야 함 (공차, 첫항 쌍)
    for (int i = 0; i < delta[k].length; i += 2) {
        int d = delta[k][i];
        int a1 = delta[k][i + 1];
        if (d == 0) continue;
        
        // 등차수열 항 개수 공식: (r - a1) / d + 1
        int countR = (r >= a1) ? ((r - a1) / d + 1) : 0;
        int countL = (l > a1) ? ((l - 1 - a1) / d + 1) : 0;
        result += Math.max(0, countR - countL);
    }

    bw.write(Integer.toString(Math.max(0, result)));
    bw.flush();
}
}
