package Lecon_6_tree;

public class BTSTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst=new BinarySearchTree();
		int n=20;
		for(int i=0;i<n;i++) {
			bst.Add((Math.random()>0.5)?((int)(Math.random()*n)):(-1*(int)(Math.random()*n)));
		}
		bst.inOrder();
	}

}
