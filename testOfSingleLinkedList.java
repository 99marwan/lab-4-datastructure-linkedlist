package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testOfSingleLinkedList {

	@Test
	void test() {
		SLinkedList list = new SLinkedList();
		//insert element to list 
		list.add(1);
		list.add(2);
		list.add(0,4);
		list.add(3);
		
		
		//check this elements
		assertEquals(true,list.contains(2));
		assertEquals(4,list.get(0));
		assertEquals(1,list.get(1));
		assertEquals(2,list.get(2));
		assertEquals(3,list.get(3));
		
		
		//check that his index out of range and value is "null"
				NullPointerException thrown = assertThrows(NullPointerException.class,() -> list.get(5));
				assertEquals(null, thrown.getMessage());
		
		//check size
		assertEquals(false,list.isEmpty());
		assertEquals(4,list.size());
		
		//check that list contains these elements or not 
		assertEquals(true,list.contains(2));
		assertEquals(false,list.contains(10));
		
		//making sub list and check its elements
		list.sublist(0,2);
		assertEquals(3,list.sublist(0,2).size());
		assertEquals(4,list.sublist(0,2).get(0));
		assertEquals(1,list.sublist(0,2).get(1));
		assertEquals(2,list.sublist(0,2).get(2));
		assertEquals(3,list.sublist(0, 2).size());
		
		
		//check if we insert element to out of range index the value will be "null"
		NullPointerException thrown2 = assertThrows(NullPointerException.class,() -> list.add(6,13));
		assertEquals(null, thrown2.getMessage());
		
		
		//changing value of one element and check it
		list.set(2, 5);
		assertEquals(5,list.get(2));
		
		//check that index to be set is out of range
		NullPointerException thrown5 = assertThrows(NullPointerException.class,() -> list.set(15,5));
		assertEquals(null, thrown5.getMessage());
		
		
		
		//remove an element and check that size was decreased
		list.remove(2);
		assertEquals(false,list.contains(5));
		assertEquals(3,list.size());
		
		
		//check that index to be removed is out of range
				NullPointerException thrown4 = assertThrows(NullPointerException.class,() -> list.remove(10));
				assertEquals(null, thrown4.getMessage());
		
		//check that one of indexes of sub list is out of range 
		NullPointerException thrown1 = assertThrows(NullPointerException.class,() -> list.sublist(1,3).size());
		assertEquals(null, thrown1.getMessage());
		
		
		//check that one of indexes of sub list is out of range 
				NullPointerException thrown3 = assertThrows(NullPointerException.class,() -> list.sublist(1,3));
				assertEquals(null, thrown3.getMessage());
		
		//clear all elements of list and check that
		list.clear();
		assertEquals(true,list.isEmpty());
		assertEquals(0,list.size());
	}

}
