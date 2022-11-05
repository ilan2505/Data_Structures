package Lecon_5_marsanit_tor;

public class Node<T> {
	T data;
	Node<T> next;
	public Node(T data,Node next) {
		this.data=data;
		this.next=next;
	}
	public String toString() {
		return data+"";
	}
}
