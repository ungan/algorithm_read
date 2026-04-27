import java.io.*;
import java.util.*;

class Main {
    
    static class Node{
        int node;
        int weight;

        Node(int node, int weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }
    static ArrayList<Node>[] tree;
    static int[][][] parent;
    static int[] depth;
    static boolean[] visit;
    static int N;
    static int total=0;
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));                         
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        parent = new int[21][N+1][2];
        depth = new int[N+1];
        visit = new boolean[N+1];

        for(int i=0; i <=N; i++)
        {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new Node(b, c));
            tree[b].add(new Node(a, c));

        }


        int root=0;

        for(int i=1; i<=N; i++)
        {
            root = i;
            if(tree[i].size() == 0) break;
        }

        dfs(1,0);
        df();
        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            total =0;
            int r = lca(a, b);
            bw.write(Integer.toString(r) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int node, int d)
    {
        visit[node] = true;
        depth[node] = d;
        //System.out.println("node " + node + " d " + d);
        for(Node next : tree[node])
        {
            if(visit[next.node]) continue;
            //System.out.println("next " + next.node + " d " + d);
            parent[0][next.node][0] = node;
            parent[0][next.node][1] = next.weight;
            dfs(next.node, d+1);
        }
    }

    static void df()
    {
        for(int k=1; k<21; k++)
        {
            for(int v=1; v<=N; v++)
            {
                if(parent[k-1][v][0] != 0){
                    parent[k][v][0] = parent[k-1][parent[k-1][v][0]][0];
                    parent[k][v][1] = parent[k-1][parent[k-1][v][0]][1] + parent[k-1][v][1];
                    //System.out.println("parent[k][v][1] : " + parent[k][v][1] + " " + k + " " + v);
                }
            }
        }
    }

    static int lca(int a, int b)
    {
        if(depth[a] < depth[b])
        {
            int temp =a;
            a = b;
            b = temp;
        }
        //System.out.println(depth[a] + " " + depth[b]);
        for(int k=20; k>=0; k--)
        {
            int jump = (int)Math.pow(2,k);

            if(depth[a] - depth[b] >= jump)
            {
                total += parent[k][a][1];
                a = parent[k][a][0];
                //System.out.println("total : " + total + " " + parent[k][a][1] + " " + k + " " + a);
            }
        }

        //System.out.println(a + " " + b);

        if(a == b) return total;

        for(int k=20; k>=0; k--)
        {
            if(parent[k][a][0] !=0 && parent[k][a][0] != parent[k][b][0])
            {
                total += parent[k][a][1] + parent[k][b][1];
                a = parent[k][a][0];
                b = parent[k][b][0];
            }
        }
        total += parent[0][a][1] + parent[0][b][1];

        return total;
    }
}