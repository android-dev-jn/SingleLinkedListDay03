package com.qsoft.singlelinkedlist;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import android.util.Log;

public class SingleLinkedListTest extends TestCase {

	private List<Node> listObject;
	private SingleLinkedList newList;

	// 1 - New LinkedList should be EMPTY
	public void testNewLinkedListShouldBeEmpty() {
		SingleLinkedList newList = new SingleLinkedList();
		assertTrue(newList.getList().isEmpty());
	}

	// 2 - Create new LinkedList from an array of Objects
	public void testNewLinkedListFromArray() {
		List<Node> listObject = new ArrayList<Node>();
		listObject.add(new Node());
		listObject.add(new Node());
		listObject.add(new Node());
		listObject.add(new Node());
		listObject.add(new Node());
		SingleLinkedList newList = new SingleLinkedList(listObject);
		assertEquals(listObject.size(), newList.getList().size());
	}

	// 3 - The method listSize() should return the number of elements in the
	// list
	public void testMethodListSizeShouldReturnTheNumberOfElementInList() {
		List<Node> listObject = new ArrayList<Node>();
		listObject.add(new Node());
		listObject.add(new Node());
		listObject.add(new Node());
		listObject.add(new Node());
		listObject.add(new Node());
		SingleLinkedList newList = new SingleLinkedList(listObject);

		assertEquals(5, newList.listSize());
	}

	// 4 - Test get Node at specified position
	public void testGetExistedElement() {
		createList();

		Node node = newList.getNode(2);

		assertEquals("value", node.getValue());
		Log.e("Test 4", node.getNextNode() + "");
		assertTrue(3 == node.getNextNode());
	}

	// 5 - Insert new element after node n, nextNode of Node n should be updated
	public void testInsertNewElementAfterNodeN() {
		createList();

		int position = 3;
		Node newNode = new Node("This is new Node", null);

		newList.insertAfter(position, newNode);

		Node test = newList.getNode(position + 1);
		assertEquals(newNode.getValue(), test.getValue());
	}

	// 6 - Delete node n
	public void testDeleteNodeN() {
		createList();

		int oldSize = newList.listSize();

		Node node = newList.getNode(2);
		newList.delete(node);

		assertEquals(oldSize - 1, newList.listSize());
	}

	// 7 - Get position of the first element
	public void testGetPositionOfTheFirstElement() {
		createList();

		int postion = newList.first();

		assertEquals(0, postion);
	}

	// 8 - Get position of the last element
	public void testGetPositionOfTheLastElement() {
		createList();

		int position = newList.last();

		assertEquals(4, position);
	}

	// 9.1 - Get position of the node before node 0 should return null
	public void testGetPositionOfPreviousNodeOfNodeZeroShouldReturnNull() {
		createList();

		Node node = newList.getNode(0);
		Integer position = newList.before(node);

		assertTrue(null == position);
	}

	// 9.2 - Get position of the node before node n
	public void testGetPositionOfPreviousNodeOfN() {
		createList();

		Node node = newList.getNode(3);
		Integer position = newList.before(node);

		assertTrue(3 == newList.getNode(position).getNextNode());
	}

	// 10.1 - Get position of the node after the last should return null
	public void testGetPositionOfTHeNodeAfterLastShouldReturnNull() {
		createList();

		Node node = newList.getNode(4);
		Integer position = newList.after(node);

		assertTrue(null == position);
	}

	// 10.2 - Get position of the node before node n
	public void testGetPositionOfNodeAfterN() {
		createList();

		Node node = newList.getNode(3);
		Integer position = newList.before(node);

		assertTrue(3 == newList.getNode(position).getNextNode());
	}

	// 11 - Get the position of node n
	public void testGetPositionOfNodeN() {
		createList();
		Node node = newList.getNode(3);
		Integer position = newList.find(node);

		assertTrue(position == newList.getList().indexOf(node));

	}

	// 12 - Append an object at the end of list
	public void testAppendNewObject() {
		createList();
		Node node = newList.getNode(newList.last());

		Node newNode = new Node("value", null);

		newList.append(newNode);

		assertEquals(node.getNextNode(), newList.find(newNode));
	}

	// 13 - Insert an object at the beginning of list
	public void testInsertNewObjectAtTheBeginingOfList() {
		createList();
		Node node = newList.getNode(newList.first());

		newList.insertFirst(new Node("new Node", null));

		Node firstNode = newList.getNode(newList.first());

		assertEquals(newList.find(node), firstNode.getNextNode());
	}

	private void createList() {
		Log.e("Test", "Create list");
		listObject = new ArrayList<Node>();
		listObject.add(new Node("value", 1));
		listObject.add(new Node("value", 2));
		listObject.add(new Node("value", 3));
		listObject.add(new Node("value", 4));
		listObject.add(new Node("value", null));

		newList = new SingleLinkedList(listObject);
	}

}
