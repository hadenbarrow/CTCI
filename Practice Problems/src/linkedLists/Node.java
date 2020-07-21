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
	
	//2.4
	public Node sumLists(Node l1, Node l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		Node result = new Node(0);
		Node N = result;
		boolean carry = false;
		
		while(l1 != null || l2 != null) {
			int sum = 0;
			if(l1 != null) {sum += l1.data;}
			if(l2 != null) {sum += l2.data;}
			if(carry) {sum++;}
			if(sum >= 10) {carry = true; sum -= 10;}
			N.data = sum;
			l1 = l1.next;
			l2 = l2.next;
			if(l1 != null || l2 != null) {
				N.next = new Node(0);
				N = N.next;
			}
		}
		
		return result;
	}
	
	public int getNthToLast(Node head, int nth) {
		Node n = head;
		int size = 1;
		
		while(n.next != null) {
			n = n.next;
			size++;
		}
		
		n = head;
		int current = 0;
		while(current != size - nth) {
			n = n.next;
			current++;
		}
		
		return n.data;
	}
	
	public Node removeDuplicates(Node head) {
		HashSet<Integer> seen = new HashSet<Integer>();
		Node n = head;
		seen.add(head.data);
		
		while(n.next != null) {
			if(seen.contains(n.next.data)) {
				n.next = n.next.next;
				continue;
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
		
		Node start2 = new Node(3);
		start2.appendToTail(2);
		start2.appendToTail(1);
		
		Node sum = start.sumLists(start, start2);
		while(sum != null) {
			System.out.println(sum.data);
			sum = sum.next;
		}
		
//		Node n = start;
//		while(n != null) {
//			System.out.println(n.data);
//			n = n.next;
//		}
//		
//		System.out.println("");
//		
//		start.deleteNode(start, 2);
//		start.deleteNode(start, 3);
//		
//		
//		n = start;
//		while(n != null) {
//			System.out.println(n.data);
//			n = n.next;
//		}
//		
//		System.out.println();
//		
//		//add 3 back, also add 1,2,3 to test removing duplicates.
//		start.appendToTail(2);
//		start.appendToTail(3);
//		start.appendToTail(1);
//		start.appendToTail(2);
//		start.appendToTail(3);
//		
//		System.out.println("Before removing duplicates");
//		
//		n = start;
//		while(n != null) {
//			System.out.println(n.data);
//			n = n.next;
//		}
//		
//		System.out.println("After removing duplicates");
//		
//		start.removeDuplicates(start);
//		
//		n = start;
//		while(n != null) {
//			System.out.println(n.data);
//			n = n.next;
//		}
//		
//		System.out.println();
//		
//		System.out.println(start.getNthToLast(start, 3));
		
	}
}
