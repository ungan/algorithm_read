import java.io.IOException;
import java.io.*;
import java.util.*;


class Main {
    
    static class Node
    {
        int x;
        int y;
        int count=1;
        int move_count=0;

        Node(int x, int y,int count,int move_count)
        {
            this.x = x;
            this.y = y;
            this.count = count;
            this.move_count = move_count;

        }
    }

    static int N;
    static int M;
    static int map[][];
    static boolean visit[][][];
    static int delta[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][2];

        for(int i=0; i<N; i++)
        {
            String s = br.readLine();
            for(int j=0; j<M; j++)
            {
                map[i][j] = s.charAt(j)-'0';
            }
        }

        bw.write(Integer.toString(bfs(new Node(0,0,1,1))));
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(Node node)
    {
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        visit[0][0][node.count] = true;

        if(node.x == N-1 && node.y == M-1) return 1;

        while(!q.isEmpty())
        {
            Node cur_n = q.poll();

            //System.out.println(cur_n.x + " " + cur_n.y + " " + cur_n.count);

            for(int i=0; i<4; i++)
            {
                int dx = cur_n.x + delta[i][0];
                int dy = cur_n.y + delta[i][1];
                //if(cur_n.x == 0 && cur_n.y == 1) System.out.println("cur_n : " + dx + " " + dy);
                if(!(dx>=0 && dx <N && dy >=0 && dy<M) || visit[dx][dy][cur_n.count]) continue;
                
                visit[dx][dy][cur_n.count] = true;

                //System.out.println("map : " + map[dx][dy] + " " + cur_n.count);

                if(map[dx][dy] == 1 && cur_n.count > 0) {
                    //System.out.println("11 cur_n : " + dx + " " + dy);
                    if(dx == N-1 && dy == M-1) return cur_n.move_count+1;
                    q.add(new Node(dx, dy,0,cur_n.move_count+1));
                }

                if(map[dx][dy] == 0 )  {
                    if(dx == N-1 && dy == M-1) return cur_n.move_count+1;
                    q.add(new Node(dx, dy,cur_n.count,cur_n.move_count+1));
                }

            }

        }
        return -1;
    }

}