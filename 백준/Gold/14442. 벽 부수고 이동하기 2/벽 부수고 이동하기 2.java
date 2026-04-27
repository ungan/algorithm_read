import java.io.*;
import java.util.*;

class Main {

    static class Node
    {
        int x;
        int y;
        int count;
        int move_count;

        Node(int x, int y, int count, int move_count)
        {
            this.x = x;
            this.y = y;
            this.count = count;
            this.move_count = move_count;
        }
    }

    static int N;
    static int M;
    static int K;
    static boolean[][][] visit;
    static int[][] map;
    static int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visit = new boolean[N][M][K+1];
        map = new int[N][M];

        
        for(int i=0; i<N; i++)
        {
            String s = br.readLine();
            for(int j=0; j<M; j++)
            {
                map[i][j] = s.charAt(j) - '0';
            }
        }


        bw.write(Integer.toString(bfs()));
        bw.flush();
        bw.close();
        bw.close();
    }

    static int bfs()
    {
        Queue<Node> q = new LinkedList();
        q.add(new Node(0,0,K,1));

        if(N-1 == 0 && M-1 == 0) return 1;

        while(!q.isEmpty())
        {
            Node node = q.poll();
            //System.out.println(node.x + " " + node.y);
            for(int i=0; i<4; i++)
            {
                int dx = node.x + delta[i][0];
                int dy = node.y + delta[i][1];
                //System.out.println("for in : " + dx + " " + dy);
                //if(node.count != 0) System.out.println("node : " + node.count);
                if(!(dx>=0 && dx<N && dy>=0 && dy<M) || visit[dx][dy][node.count]) continue;

                visit[dx][dy][node.count] = true;

                //System.out.println("check heck : " + map[dx][dy] + " " + node.count);

                if(map[dx][dy] == 1 && node.count>0)
                {
                    if(dx == N-1 && dy == M-1) return node.move_count+1;
                    q.add(new Node(dx,dy,node.count-1,node.move_count+1));
                }

                if(map[dx][dy] == 0)
                {
                    if(dx == N-1 && dy == M-1) return node.move_count+1;
                     q.add(new Node(dx,dy,node.count,node.move_count+1));
                }
            }
        }

        return -1;

    }
}