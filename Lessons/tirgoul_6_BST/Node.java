package tirgoul_6_BST;

public class Node {
	int data;
	public Node right;
	public Node left;
	public int num;
	public Node(int data)
	{
		this.data = data;
		left = right = null;
		num = 1;
	}
}

