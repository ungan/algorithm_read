

import java.io.*;
import java.util.*;

public class Main {
    // map이 필요한 경우
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] origin;
    static boolean[][] visited;

    static int n, m;
    static int answer;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            origin = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < m; j++) {
                    origin[i][j] = Integer.parseInt(st.nextToken());

                }
            }

            visited = new boolean[n][m];
            int cnt = 0;
            while (true) {
                int count = countParts(origin);
                
                if (count == 0) {       // 모두 녹음
                    cnt = 0;
                    break;
                }
                if (count > 1) {        // 분리 완료
                    break;
                }

                int[][] temp = copyArr(origin);
                changeMap(origin, temp);
                origin = temp;
                cnt++;
            }

            // // map 확인용 출력 코드
            // bw.write("=========================================================");
            // bw.newLine();
            // for (int i = 0; i < n; i++) {
            // for (int j = 0; j < m; j++) {
            // bw.write(origin[i][j] + " ");
            // }
            // bw.newLine();
            // }

            bw.write(cnt + " ");

        }
    }

    static void changeMap(int[][] map, int[][] temp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    continue;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                        continue;
                    if (map[nx][ny] == 0) {

                        temp[i][j] = temp[i][j] - 1;
                        if (temp[i][j] < 0)
                            temp[i][j] = 0;
                    }

                }
            }
        }
    }

    static int countParts(int[][] target) {
        int cnt = 0;
        // visited = new boolean[n][m];
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], false);

        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                if (target[i][j] < 1)
                    continue;
                if (visited[i][j])
                    continue;
                bfs(visited, target, i, j);
                cnt++;
            }
        }

        return cnt;
    }

    static void bfs(boolean[][] visited, int[][] target, int row, int col) {
        Queue<int[]> qu = new LinkedList<>();

        qu.offer(new int[] { row, col });
        visited[row][col] = true;

        while (!qu.isEmpty()) {
            int[] cur = qu.poll();
            int cr = cur[0];
            int cc = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cr + dx[d];
                int ny = cc + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (target[nx][ny] == 0)
                    continue;

                qu.offer(new int[] { nx, ny });
                visited[nx][ny] = true;
            }
        }

    }

    static int[][] copyArr(int[][] origin) {
        int[][] temp = new int[origin.length][];
        for (int i = 0; i < origin.length; i++) {
            temp[i] = Arrays.copyOf(origin[i], origin[i].length);
        }

        return temp;
    }

}
