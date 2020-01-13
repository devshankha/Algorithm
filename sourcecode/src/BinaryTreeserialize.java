import java.util.ArrayList;


public class BinaryTreeserialize {
	int data;
	BinaryTreeserialize left;
	BinaryTreeserialize right;
	static int startIndex=0;
	public BinaryTreeserialize(int d) {
		data = d;
	}
	
	static ArrayList<Integer > serialize(BinaryTreeserialize root, ArrayList<Integer> list) {
		if (root == null) {
			list.add(-1);
			startIndex++;
		return list;
		}
		list.add(root.data);
		startIndex++;
		serialize(root.left, list);
		serialize(root.right, list);
		return list;
				
		
		
	}
	
	static void inOrder(BinaryTreeserialize root) {
		if (root == null)
			return;
		inOrder(root.left); 
		System.out.print(root.data+" ");
		inOrder(root.right);
		
	}
	
	static BinaryTreeserialize deserialize(ArrayList<Integer> l) {
		if (l.get(startIndex) == -1 || startIndex == l.size()) {
			startIndex++;
			return null;
		}
		BinaryTreeserialize root = new BinaryTreeserialize(l.get(startIndex));
		startIndex++;
		root.left = deserialize(l);
		root.right = deserialize(l);
		return root;
		
	}
	
	
	
	public static void main(String[] args) {
		
		BinaryTreeserialize tree = new BinaryTreeserialize(20);
       // tree.root = new Node(20);
        tree.left = new BinaryTreeserialize(8);
        tree.right = new BinaryTreeserialize(24);
        tree.left.left = new BinaryTreeserialize(14);
        ArrayList<Integer> l = new ArrayList<Integer>();
        ArrayList<Integer> l1 = BinaryTreeserialize.serialize(tree, l);
        System.out.println(l1);
        BinaryTreeserialize.startIndex = 0;
        BinaryTreeserialize s=BinaryTreeserialize.deserialize(l1);
        BinaryTreeserialize.inOrder(s);
	}

}
