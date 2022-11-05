package Lecon_5_marsanit_tor;

public class NodeTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> p=new Node<Integer>(5,null);
		Node<Boolean> p2=new Node<Boolean>(false,p);
		Node<Character> p3=new Node<Character>('*',p2);
		System.out.println(""+p3+", "+p3.next+", "+p3.next.next);
	}
}
