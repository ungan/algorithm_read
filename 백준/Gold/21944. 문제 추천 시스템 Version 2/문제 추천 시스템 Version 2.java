
import java.io.*;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;


public class Main {
    
    static class Node implements Comparable<Node>
    {
        int id;
        int difficult;
        boolean erase = false;
        
        Node(int id, int difficult)
        {
            this.id = id;
            this.difficult = difficult;
        }

        @Override
        public int compareTo(Node o) {
            if(this.difficult == o.difficult)
            {
                return this.id - o.id;
            }
            return this.difficult - o.difficult;
        }
    }
    static PriorityQueue<Node> pq_all_max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Node>[] pq_grade_max = new PriorityQueue[101];
    static PriorityQueue<Node>[] pq_algo_max = new PriorityQueue[101];
    
    static PriorityQueue<Node> pq_all_min = new PriorityQueue<>();
    static PriorityQueue<Node>[] pq_grade_min = new PriorityQueue[101];
    static PriorityQueue<Node>[] pq_algo_min = new PriorityQueue[101];
    
    static Node[] all_node = new Node[100001];
    
    public static void main(String[] args) throws InterruptedException, IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;//  = new StringTokenizer(br.readLine());
       
       int n = Integer.parseInt(br.readLine());
       
       
       for(int i=0; i<=100; i++)
       {
    	   pq_grade_max[i] = new PriorityQueue<Node>(Collections.reverseOrder());
    	   pq_algo_max[i] = new PriorityQueue<Node>(Collections.reverseOrder());

    	   pq_grade_min[i] = new PriorityQueue<Node>();
    	   pq_algo_min[i] = new PriorityQueue<Node>();

       }
       
       for(int i=0; i<n; i++)
       {
           st = new StringTokenizer(br.readLine());
           
           int p = Integer.parseInt(st.nextToken());
           int l = Integer.parseInt(st.nextToken());
           int g = Integer.parseInt(st.nextToken());
           
           Node node= new Node(p, l);
           
           all_node[p] = node;
           
           pq_all_max.add(node);
           pq_grade_max[l].add(node);
           pq_algo_max[g].add(node);
           
           pq_all_min.add(node);
           pq_grade_min[l].add(node);
           pq_algo_min[g].add(node);
       }
      
       int m = Integer.parseInt(br.readLine());
       
       for(int i=0; i<m; i++)
       {
    	   st= new StringTokenizer(br.readLine());
           String s = st.nextToken();
           int a = Integer.parseInt(st.nextToken());
           
           int ans = -100;
           
           if(s.equals("add"))
           {
        	   int l = Integer.parseInt(st.nextToken());
        	   int g = Integer.parseInt(st.nextToken());
        	   
        	   Node node= new Node(a, l);
        	   
        	   all_node[a] = node;
               
               pq_all_max.add(node);
               pq_grade_max[l].add(node);
               pq_algo_max[g].add(node);
               
               pq_all_min.add(node);
               pq_grade_min[l].add(node);
               pq_algo_min[g].add(node);
        	   
           }
           else if(s.equals("recommend"))
           {
        	   int x = Integer.parseInt(st.nextToken());
        	   if(x == 1)
        	   {
        		   update(pq_algo_max[a]);
        		   ans = pq_algo_max[a].peek().id;
        	   }
        	   else
        	   {
        		   update(pq_algo_min[a]);
        		   ans = pq_algo_min[a].peek().id;
        	   }
        	   
           }
           else if(s.equals("recommend2"))
           {
        	   //int x = Integer.parseInt(st.nextToken());
        	   
        	   if(a == 1)
        	   {
        		   update(pq_all_max);
        		   ans = pq_all_max.peek().id;
        	   }
        	   else
        	   {
        		   update(pq_all_min);
        		   ans = pq_all_min.peek().id;
        	   }
           }
           else if(s.equals("recommend3"))
           {
        	   ans = -1;
        	   int L = Integer.parseInt(st.nextToken());
        	   if(a == 1)
        	   {
        		   //Node node = new Node(101,101);
        		   
        		   for(int j=L; j<=100; j++)
        		   {
        			   
        			   update(pq_grade_min[j]);
        			   
        			   if(pq_grade_min[j].isEmpty()) continue;
        			   
        			   int id = pq_grade_min[j].peek().id;
        			   int difficult = pq_grade_min[j].peek().difficult;
        			   
        			   //System.out.println("id : " + id + " difficult : " + difficult + " " + (node.difficult > difficult));
        			   
        			   ans = pq_grade_min[j].peek().id;
        			   break;
        		   }
        		   //ans = node.id;
        	   }
        	   else
        	   {
        		   //Node node = new Node(0,0);
        		   
        		   for(int j=L-1; j>=1; j--)
        		   {
        			   
        			   update(pq_grade_max[j]);
        			   
        			   if(pq_grade_max[j].isEmpty()) continue;
        			   
        			   int id = pq_grade_max[j].peek().id;
        			   int difficult = pq_grade_max[j].peek().difficult;
        			   
        			   //node = pq_grade_max[j].peek();
        			   ans = pq_grade_max[j].peek().id;
        			   break;
        			   //if(node.difficult < difficult) node = pq_grade_max[j].peek();
        			   //if(node.difficult == difficult && node.id > id) node = pq_grade_max[j].peek();
        		   }
        		   
        		   //ns = node.id;
        	   }
        	   
        	   //if(ans == 101 || ans == 0) ans = -1;
           }
           else if(s.equals("solved"))
           {
        	   
        	   all_node[a] = new Node(0,1);
           }
           
           if(ans != -100)bw.write(Integer.toString(ans) + "\n");
    	   
       }
       
       
       bw.flush();
       bw.close();

    }
    
    static void update(PriorityQueue<Node> pq)
    {
    	while(!pq.isEmpty())
    	{
    		int id = pq.peek().id;
    		//int difficult = pq.peek().difficult;
    		
    		if(pq.peek() == all_node[id]) break;
    		
    		pq.poll();
    	}
    }
    
    
}
