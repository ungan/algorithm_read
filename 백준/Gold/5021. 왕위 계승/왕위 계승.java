

import java.io.*;
import java.util.*;

public class Main {
	static class Node
	{
		String name;
		
		int rank;
		List<Node> list = new LinkedList<Node>(); // 부모
		List<Node> child_list = new LinkedList<Node>(); // 자식
		
		double blood = 0f;
		boolean visit = false;
		
		Node(String name , int rank)
		{
			this.name = name;
			this.rank = rank;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		HashMap<String, Node> hash = new HashMap<String, Main.Node>();
		
		String king = br.readLine();
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			
			Node node_a;
			Node node_b = null;
			Node node_c = null;
			
			if(hash.containsKey(a)) node_a = hash.get(a);
			else {
				node_a = new Node(a,1);
				hash.put(a, node_a);

			}
			if(hash.containsKey(b)) node_b = hash.get(b);
			else {
				node_b = new Node(b,0);
				hash.put(b, node_b);
			}
			if(hash.containsKey(c)) node_c = hash.get(c);
			else {
				node_c = new Node(c,0);
				hash.put(c, node_c);
			}
			
			//System.out.println("a : " + a);
			node_a.rank = 2;
			node_a.list.add(node_b);
			node_a.list.add(node_c);
			node_b.child_list.add(node_a);
			node_c.child_list.add(node_a);
			
		}
		
		if(hash.containsKey(king)) hash.get(king).blood = 1f;
		
		Queue<Node> que = new LinkedList<>();
		
		for(String s : hash.keySet())
		{
			Node n = hash.get(s);
			if(n.list.size() == 0 && n.rank == 0)
			{
				que.add(n);
			}
		}
		
		
		// 1. 데이터 타입 변경 (float -> double)
		double maxBlood = -1.0; // 0인 경우도 비교해야 하므로 -1로 초기화
		String ans = "";

		// 2. 위상 정렬 루프 내 혈통 계산
		while(!que.isEmpty()) {
		    Node n = que.poll();
		    
		    // 부모가 2명 있을 때만 계산 (이미 부모들의 blood는 확정된 상태)
		    if(n.list.size() == 2) {
		        n.blood = (n.list.get(0).blood + n.list.get(1).blood) / 2.0;
		    }
		    
		    for(Node next : n.child_list) {
		        next.rank--;
		        if(next.rank == 0) { // 자식의 입장에서 부모 신호가 모두 도착
		            que.add(next);
		        }
		    }
		}

		// 3. 후보자 비교 (K만큼 반복)
		for(int i = 0; i < K; i++) {
		    String candidate = br.readLine();
		    if(!hash.containsKey(candidate)) continue;
		    
		    double currentBlood = hash.get(candidate).blood;
		    if(currentBlood > maxBlood) { // 더 높은 혈통 발견 시 업데이트
		        maxBlood = currentBlood;
		        ans = candidate;
		    }
		}
		
		
		System.out.println(ans);
		
	}

}
