import java.util.*;
import java.io.*;

public class Main {
    static long N;
    static int P, Q, X, Y;
    static int MAX = 15000000; // 메모리 상황에 따라 1500만~2000만 권장
    static long[] cache = new long[MAX + 1];

    public static void main(String[] args) throws IOException {
        // Scanner보다 빠른 StringTokenizer + BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        // 하위 구간 미리 계산 (Bottom-Up)
        cache[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            long idx1 = (long)i / P - X;
            long idx2 = (long)i / Q - Y;
            cache[i] = (idx1 <= 0 ? 1 : cache[(int)idx1]) 
                     + (idx2 <= 0 ? 1 : cache[(int)idx2]);
        }

        System.out.println(solve(N));
    }

    static long solve(long n) {
        if (n <= 0) return 1;
        // 배열 범위 안이라면 즉시 반환 (재귀를 여기서 끊음)
        if (n <= MAX) return cache[(int) n];

        // 배열 범위를 벗어나는 큰 값에 대해서만 재귀 호출
        // 팁: Map을 쓰지 않고 생재귀를 돌려도 MAX가 크면 중복 계산이 급격히 줄어듦
        return solve(n / P - X) + solve(n / Q - Y);
    }
}