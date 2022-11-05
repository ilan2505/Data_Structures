package Lecon_6_tree;

public class BSTNOde {
	int data;
	BSTNOde right, left;

	public BSTNOde(int data) {
		this.data = data;
		right = left = null;
	}

	public String toString() {
		return "" + data;
	}
}
