package eg.edu.alexu.csd.datastructure.linkedList;

public class SLinkedList implements ILinkedList {
	private class Node{
		// we assume elements are character strings
				private Object element;
				private Node next;
			
			/** Returns the element of this node. */
			public Object getElement() {
				return element; 
			}
			/** Returns the next node of this node. */
			public Node getNext() {
				return next; 
			}
			// Modifier methods:
			/** Sets the element of this node. */
			public void setElement(Object newElem) {
				element = newElem;
			}
			/** Sets the next node of this node. */
			public void setNext(Node newNext) { 
				next = newNext;
			}

	}
	private Node head; // head node of the list
	private int size; // number of nodes in the list
	/** Default constructor that creates an empty list */
	public SLinkedList(){
	head = null;
	size = 0;
	            }
	@Override
	public void add(int index, Object element) {
		Node node = new Node();
		node.setElement(element);
		node.setNext(null);
	/*	if(head==null) {
			head = node;
			head.setNext(null);
			size++;
		}
		else {*/
			if(index==0) {
				node.setNext(head);
				head=node;
				size++;
			}
			else {
				    if(index>size || index <0) {
				    	NullPointerException nullPointer = new NullPointerException();
	                    throw nullPointer;
				    }
				    else {
				    Node n =head;
					for(int i=0;i<index-1;i++) {
						n=n.getNext();
					}
					node.setNext(n.getNext());
					n.setNext(node);
					size++;
				    }
			}
		//}
		
		
	}
	@Override
	public void add(Object element) {
		add(this.size,element);
		
	}
	@Override
	public Object get(int index) {
		if(index>size || index <0) {
	    	NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
	    }
		else {
		Node n =head;
		for(int i=0;i<index;i++) {
			n=n.getNext();
		}
		if(n.getElement()==null)
			return 1;
		return n.getElement();
		}
	}
	@Override
	public void set(int index, Object element) {
		if(index>size || index <0) {
	    	NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
	    }
		else {
		Node node =head;
		for(int i=0;i<index;i++) {
			node=node.getNext();
		}
		node.setElement(element);
		}
	}
	@Override
	public void clear() {
		
		while(head.getNext()!=null){
			head=head.getNext();
			size--;
		}
		head=head.getNext();
		
		size--;
		
	}
	@Override
	public boolean isEmpty() {
		boolean test=false;
			//if(head==null) we can use this also
			if(size==0) {
				test = true;
			}
		return test;
	}
	@Override
	public void remove(int index) {
		if(index==0) {
			head=head.getNext();
			size--;
		}
		else {
			if(index>size || index <0) {
		    	NullPointerException nullPointer = new NullPointerException();
                throw nullPointer;
		    }
			else {
				Node n =head;
				Node m;
				for(int i=0;i<index-1;i++) {
					n=n.getNext();
				}
				m=n.getNext();
				n.setNext(m.getNext());
				size--;
			}
			
		}
		
	}
	@Override
	public int size() {
		return this.size;
	}
	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if(fromIndex>size || fromIndex <0 || toIndex>size || toIndex<0 ) {
	    	NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
	    }
		else {
		int subSize=toIndex-fromIndex+1;
		Node node=head;
		for(int i=0;i<fromIndex;i++) {
			node=node.getNext();
		}
		SLinkedList newList=new SLinkedList();
		for(int i=0;i<subSize;i++) {
			newList.add(node.getElement());
			node=node.getNext();	
		}
		//newList.show();
		return newList;
		}
	}
	@Override
	public boolean contains(Object o) {
		boolean test =false;
		Node node =head;
		if(node.getElement()==o) {
			test =true;
		}
		else {
			for(int i=1;i<this.size;i++) {
				node=node.getNext();
				if(node.getElement()==o) {
					test =true;
				}
			}
		}
		
		return test;
	}
	public void show() {
		Node n = head;
		while(n.getNext()!=null) {
			System.out.println(n.getElement());
			n=n.getNext();
		}
		System.out.println(n.getElement());
		
	}

}
