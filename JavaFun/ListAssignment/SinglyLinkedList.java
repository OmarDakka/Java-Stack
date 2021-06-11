
public class SinglyLinkedList {
public Node head;
public int size=0;
public Node last;
public void addFirst(int item) {
	if(head==null) {
		head=new Node(item);
		size++;
		last=head;
	}
	else {
	Node temp = new Node(item);
	temp.setNext(head);
	head=temp;
	size++;
	}
}

}
