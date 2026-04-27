import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		
		int scount = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		
		// **핵심 수정:** 탐색 상한을 1002 (혹은 1001)로 설정합니다.
		// N과 고장난 숫자가 1000이므로, 1001도 고려해야 합니다.
		final int MAX_LIMIT = 1002; 
		
		// boolean 배열 크기를 MAX_LIMIT에 맞게 조정
		boolean[] isForbidden = new boolean[MAX_LIMIT]; 
		
		// 고장난 숫자가 있다면 다음 줄에서 읽음
		if (scount > 0) {
		    st = new StringTokenizer(br.readLine());
		    for(int i = 0; i < scount; i++) {
		        int forbiddenNum = Integer.parseInt(st.nextToken());
		        // 1000보다 작은 고장난 숫자만 배열에 저장 (문제 제약 조건)
		        if (forbiddenNum < MAX_LIMIT) {
		            isForbidden[forbiddenNum] = true;
		        }
		    }
		}
		
		// 세 수 x, y, z의 탐색 범위는 1부터 MAX_LIMIT-1까지
		for (int i = 1; i < MAX_LIMIT; i++) { 
            if (isForbidden[i]) continue;
            
            for (int w = i; w < MAX_LIMIT; w++) {
            	if (isForbidden[w]) continue;

                // i*w*w가 이미 N보다 훨씬 크다면 w 루프를 종료하는 최적화도 가능

                for (int j = w; j < MAX_LIMIT; j++) {
                	if (isForbidden[j]) continue;
                	
                	long product = (long)i * w * j;

                    // **조기 종료 최적화**: 
                    // 곱이 N보다 크고 현재까지의 최소 차이(min)를 넘어선다면, break
                    if (product > N && (product - N) >= min) {
                        break; 
                    }
                    
                    // N과 곱의 차이 계산
                	int diff = (int)Math.abs(N - product);
                	
                	if (diff < min) {
                	    min = diff;
                	}
                    
                    // 최적화: min이 0이면 더 이상 작은 값은 없으므로 모든 루프를 종료
                    if (min == 0) {
                        // bw.write(Integer.toString(0));
                        // bw.flush();
                        // bw.close();
                        // br.close();
                        // return; // 메인 함수를 완전히 종료 (가장 빠른 종료)
                    }
                }
            }
        }
		
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
		br.close();
	}
}