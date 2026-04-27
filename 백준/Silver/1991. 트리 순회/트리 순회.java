import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int c=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		treeNode root = null;// = new TreeNode();
		int N = Integer.parseInt(br.readLine());
		Map<String,treeNode> map = new HashMap<>();
		
		for(int i=0;i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			
			map.putIfAbsent(a, new treeNode(a));
			if(!b.equals(".")) map.putIfAbsent(b, new treeNode(b));
			if(!c.equals(".")) map.putIfAbsent(c, new treeNode(c));
			
			treeNode parent = map.get(a);
			treeNode l = map.get(b);
			treeNode r = map.get(c);
			
			if(root == null) 
			{
				root = parent;
				//System.out.println("parent : " + parent.val);
			}

			if(l != null) 
			{
			parent.left = l;
			//System.out.println("parent.left" + parent.left.val);
			}
			else parent.left = null;
			if(r != null) 
			{
				parent.right = r;
				//System.out.println("parent.right" + parent.right.val);
			}
			else parent.right = null;
			
		}
		//System.out.println("root" + root.right.val);
		//System.out.println("root" + root.left.val);
		Preorder_Traversal(root);
		bw.write("\n");
		inorder_Traversal(root);
		bw.write("\n");
		post_Traversal(root);
		
		bw.flush();
		bw.close();
	}
	
	static void Preorder_Traversal(treeNode r) throws IOException
	{
		if(r == null) return;
		
		bw.write(r.val);
		Preorder_Traversal(r.left);
		Preorder_Traversal(r.right);
	}
	
	static void inorder_Traversal(treeNode root) throws IOException
	{
		if(root == null) return;
		
		inorder_Traversal(root.left);
		bw.write(root.val);
		inorder_Traversal(root.right);
	}
	
	static void post_Traversal(treeNode root) throws IOException
	{
		if(root == null) return;
		
		post_Traversal(root.left);
		post_Traversal(root.right);
		bw.write(root.val);
	}
}

class treeNode{
	String val;
	treeNode left;
	treeNode right;
	
	public treeNode(String val)
	{
		this.val = val;
		
	}
}
