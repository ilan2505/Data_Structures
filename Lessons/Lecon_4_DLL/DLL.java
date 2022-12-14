package Lecon_4_DLL;

public class DLL {
	Node head;
	int size;
	public DLL() {
		head=null;
		size=0;
	}
	public void Add(int data) {
		Node new_Node=new Node(data);
		new_Node.next=head;
		if(head!=null) {
			head.prev=new_Node;
		}
		head=new_Node;
		size++;
	}
	public void append(int data) {
		Node new_Node=new Node(data);
		if(head==null) {
			new_Node.prev=null;
			head=new_Node;
			size++;
			return;
		}
		Node p=head;
		while(p.next!=null) {
			p=p.next;
		}
		p.next=new_Node;
		new_Node.prev=p;
		size++;
	}
}
