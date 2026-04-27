import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 10 미만의 숫자는 시작하자마자 부분 문자열을 고를 수 없으므로 무조건 패배(-1)
        if (n < 10) {
            System.out.println(-1);
            return;
        }

        // dp[i] : 게임 판에 숫자 i가 있을 때, 내가 이기기 위해 골라야 하는 최소 부분 문자열
        // 만약 어떻게 해도 이길 방법이 없다면 -1을 저장
        int[] dp = new int[n + 1];
        
        // 1~9는 고를 수 있는 진 부분 문자열이 없으므로 무조건 짐
        for (int i = 1; i < 10; i++) {
            dp[i] = -1;
        }

        // 10부터 N까지 작은 수부터 차근차근 정답을 구해 나감 (Bottom-Up DP)
        for (int i = 10; i <= n; i++) {
            dp[i] = -1; // 일단 기본 상태는 '이길 수 없음(-1)'으로 둠
            
            String s = String.valueOf(i);
            int len = s.length();
            
            // 가능한 진 부분 문자열을 중복 없이 오름차순으로 자동 정렬하기 위해 TreeSet 사용
            TreeSet<Integer> substrings = new TreeSet<>();
            
            // 이중 반복문으로 시작점과 끝점을 잡아 모든 연속된 부분 문자열 추출
            for (int start = 0; start < len; start++) {
                for (int end = start + 1; end <= len; end++) {
                    // 자기 자신과 완전히 동일한 경우는 '진 부분 문자열'이 아니므로 제외
                    if (start == 0 && end == len) continue;
                    
                    int part = Integer.parseInt(s.substring(start, end));
                    
                    // 문제 조건: '양의 정수 M'이므로 0보다 큰 경우만 추가
                    if (part > 0) {
                        substrings.add(part);
                    }
                }
            }
            
            // 오름차순으로 정렬된 부분 문자열을 작은 것부터 하나씩 시도
            for (int part : substrings) {
                // 상대방에게 (i - part)를 넘겨주었을 때, 상대방이 지는 상황(-1)이라면 나의 승리!
                if (dp[i - part] == -1) {
                    dp[i] = part;
                    break; // 가장 작은 최소값을 찾았으므로 더 이상 찾을 필요 없이 종료
                }
            }
        }

        // 최종적으로 우리가 원했던 N에 대한 결과 출력
        System.out.println(dp[n]);
    }
}