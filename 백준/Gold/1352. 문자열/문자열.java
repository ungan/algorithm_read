

import java.io.*;

public class Main {
    static int N;
    static char[] result;              
    static int[] remain = new int[26]; 
    static boolean found = false;      
    
    // ★ [추가 1] 실패한 상태를 기억할 2차원 배열 (방명록)
    // failed[idx][sum]이 true라면, "이 상태에선 답이 없다"는 뜻입니다.
    static boolean[][] failed = new boolean[105][105];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result = new char[N + 1];

        back(1, 0, 0);

        if (!found) {
            System.out.println("-1");
        }
    }

    static void back(int idx, int nextChar, int sum) {
        if (found) return; 

        // ★ [추가 2] 이미 예전에 와봤는데 "여기 답 없어!"라고 판명된 상태라면, 탐색하지 않고 칼같이 돌아갑니다. (초고속 가지치기)
        if (failed[idx][sum]) return;

        if (idx > N) {
            if (sum == N) { 
                System.out.println(new String(result, 1, N));
                found = true;
            }
            return;
        }

        for (int c = 0; c <= nextChar; c++) {
            
            if (c < nextChar) {
                if (remain[c] > 0) { 
                    result[idx] = (char) ('A' + c);
                    remain[c]--; 

                    back(idx + 1, nextChar, sum); 

                    remain[c]++; 
                }
            } 
            else {
                if (sum + idx <= N) { 
                    result[idx] = (char) ('A' + c);
                    remain[c] = idx - 1; 

                    back(idx + 1, nextChar + 1, sum + idx); 

                    remain[c] = 0; 
                }
            }
        }
        
        // ★ [추가 3] for문을 다 돌며 'A'부터 다 넣어봤는데도 정답(found)을 못 찾고 여기까지 왔다면?
        // "아, 현재 인덱스(idx)와 합계(sum) 상태에서는 어떻게 해도 정답을 못 만드는구나!" 하고 기록합니다.
        failed[idx][sum] = true;
    }
}