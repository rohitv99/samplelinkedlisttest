
// Java program to reverse given  
// linked list according to its size  
public class CFG {

	static class Node {
		int data;
		Node next;
	};

// Function to create a new Node  
	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = null;
		return temp;
	}

// Prints a list.  
	static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

// Function to push a Node  
	static Node push(Node head_ref, int new_data) {
		Node new_Node = new Node();
		new_Node.data = new_data;
		new_Node.next = (head_ref);
		(head_ref) = new_Node;
		return head_ref;
	}

// Returns size of list.  
	static int getSize(Node head) {
		Node curr = head;
		int count = 0;
		while (curr != null) {
			curr = curr.next;
			count++;
		}
		return count;
	}

// Function to reverse the linked  
// list according to its size  
	static Node reverseSizeBy2Util(Node head, int k, boolean skipMiddle) {
		if (head == null)
			return null;

		int count = 0;
		Node curr = head;
		Node prev = null;
		Node next = null;

		// Reverse current block of list.
		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		// If size is even, reverse next block too.
		if (!skipMiddle)
			head.next = reverseSizeBy2Util(next, k, false);

		else {

			// if size is odd, skip next element
			// and reverse the block after that.
			head.next = next;
			if (next != null)
				next.next = reverseSizeBy2Util(next.next, k, true);
		}
		return prev;
	}

	static Node reverseBySizeBy2(Node head) {
		// Get the size of list.
		int n = getSize(head);

		// If the size is even, no need
		// to skip middle Node.
		if (n % 2 == 0)
			return reverseSizeBy2Util(head, n / 2, false);

		// If size is odd, middle Node has
		// to be skipped.
		else
			return reverseSizeBy2Util(head, n / 2, true);
	}

// Driver code  
	public static void main(String args[]) {
		// Start with the empty list /
		Node head = null;

		// Created Linked list is 1.2.3.4.5.6.7.8.9 /
		head = push(head, 9);
		head = push(head, 8);
		head = push(head, 7);
		head = push(head, 6);
		head = push(head, 5);
		head = push(head, 4);
		head = push(head, 3);
		head = push(head, 2);
		head = push(head, 1);

		System.out.print("Original List : ");
		printList(head);

		System.out.print("Reversed List : ");
		Node reversedHead = reverseBySizeBy2(head);
		printList(reversedHead);
	}
}