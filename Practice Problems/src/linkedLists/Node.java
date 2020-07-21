package linkedLists;

import java.util.HashSet;

public class Node {
	Node next = null;
	int data;
	
	public Node (int d) {data = d;}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {n = n.next;}
		n.next = end;
	}
	
	public Node deleteNode(Node head, int d) {
		Node n = head;
		
		if(n.data == d) {
			return head.next;
		}
		
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	public Node removeDuplicates(Node head) {
		HashSet<Integer> seen = new HashSet<Integer>();
		Node n = head;
		seen.add(head.data);
		
		while(n.next != null) {
			if(seen.contains(n.next.data)) {
				n.next = n.next.next;
			}
			seen.add(n.next.data);
			n = n.next;
		}
		return head;
	}
	
	
	
	public static void main(String[] args) {
		Node start = new Node(1);
		start.appendToTail(2);
		start.appendToTail(3);
		
		Node n = start;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
		
		System.out.println("");
		
		start.deleteNode(start, 2);
		start.deleteNode(start, 3);
		
		
		n = start;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
		
		System.out.println();
		
		//add 3 back, also add 1,2,3 to test removing duplicates.
		start.appendToTail(2);
		start.appendToTail(3);
		start.appendToTail(1);
		start.appendToTail(2);
		start.appendToTail(3);
		
		start.removeDuplicates(start);
		
		n = start;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}
