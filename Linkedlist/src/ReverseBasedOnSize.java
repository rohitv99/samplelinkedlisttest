//import ReverseBasedOnSize.Node;

/**
 * 
 */

/**
 * @author rohit
 *
 */
public class ReverseBasedOnSize {
	
	
	static class Node 
	{  
	    int data;  
	    Node next;  
	}; 
	
	
	// Function to push a Node  
	static Node push(Node head_ref, int new_data)  
	{  
	    Node new_Node = new Node();
	    new_Node.data = new_data;
		new_Node.next = (head_ref);
		(head_ref) = new_Node;
		return head_ref;
	} 
	
	
	static void printList(Node head) {
		
		Node temp = head;
		
		while (temp != null) {
			System.out.println(temp.data + "");
			temp = temp.next;
		}
		System.out.println("");
	}
	
	
	static int getSize(Node head) {
		
		int count = 0;
		Node curr = head;
		while (curr != null) {
			
			curr = curr.next;
			count++;
		}
		System.out.println("size is:" +count);
		return count;
	}
	
	
	static Node reverseSizeBasedOnSize(Node head, int n, Boolean ifEven) {
		
		if(head == null)
			return null;
		
		int count = 0;
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		while (curr != null && count < n) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if (!ifEven) {
			reverseSizeBasedOnSize(next, n, Boolean.FALSE);
		}
		else {

			// if size is odd, skip next element
			// and reverse the block after that.
			head.next = next;
			if (next != null)
				next.next = reverseSizeBasedOnSize(next.next, n, true);
		} 
		
		
		return prev;
	}
	
	
	static Node reverseBySizeBy2(Node head) {
		
		int size = getSize(head);
		
		if (size % 2 == 0) {
			return reverseSizeBasedOnSize(head, size/2, false);
			
		}
		else {
			return reverseSizeBasedOnSize(head, size/2, true);
		}
		
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Start with the empty list / 
	    Node head = null;  
	  
	    // Created Linked list is 1.2.3.4.5.6.7.8.9 / 
	    head = push(head, 9);  
	    head = push(head, 8);  
	    head = push(head, 7);  
	    head = push(head, 6);  
	    head = push(head, 5);  
//	    head = push(head, 4);  
//	    head = push(head, 3);  
//	    head = push(head, 2);  
//	    head = push(head, 1);  
	  
	    System.out.print( "Original List : ");  
	    printList(head);  
	  
	    System.out.print( "Reversed List : ");  
	    Node reversedHead = reverseBySizeBy2(head);  
	    printList(reversedHead); 
	}

	
	
	
	
}
