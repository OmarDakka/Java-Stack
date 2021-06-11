

public class Druiver {

	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(0);
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
		Node curr = list.head;
		for(int i =0;i<list.size;i++) {
			System.out.println(curr.getValue());
			curr=curr.getNext();
		}
	}

}
