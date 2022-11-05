package Lecon_6_tree;

public class Node<T> {
	T data;
	Node<T> right, left;

	public Node(T data) {
		this.data = data;
		right = left = null;
	}

	public String toString() {
		return "" + data;
	}
}
