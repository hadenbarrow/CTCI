package linkedLists;

public class Node {
	Node next = null;
	int data;
	public Node (int d) {data = d;}
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {n = n.next;}
		n.next = end;
	}
	
	public static void main(String[] args) {
		Node start = new Node(1);
		start.appendToTail(2);
		start.appendToTail(3);
		
		while(start != null) {
			System.out.println(start.data);
			start = start.next;
		}
	}
}
