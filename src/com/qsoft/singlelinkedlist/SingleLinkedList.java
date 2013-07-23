package com.qsoft.singlelinkedlist;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class SingleLinkedList {

	private final String TAG = this.getClass().getSimpleName();

	private List<Node> list;
	private int firstElement;

	public SingleLinkedList() {
		super();
		this.list = new ArrayList<Node>();
		this.firstElement = 0;
	}

	public SingleLinkedList(List<Node> listObject) {
		this.list = listObject;
		this.firstElement = 0;
	}

	public List<Node> getList() {
		// TODO Auto-generated method stub
		return this.list;
	}

	public int listSize() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	public void insertAfter(int i, Node newNode) {

		Node node = this.list.get(i);
		newNode.setNextNode(node.getNextNode());
		this.list.add(newNode);
		node.setNextNode(this.listSize() - 1);

	}

	public Node getNode(int position) {
		if (this.listSize() > 0) {
			Log.e(TAG, "pos = " + position);
			Node result = this.list.get(firstElement);
			int index = 0;
			while (index != position) {
				index++;
				Log.e(TAG, "current = " + index);
				result = this.list.get(result.getNextNode());
			}
			Log.e(TAG, "result = " + result.getNextNode());
			return result;
		} else {
			Log.e(TAG, "List has size 0");
			return null;
		}
	}

	public void delete(Node node) {
		Node iter = this.list.get(firstElement);
		int position = this.list.indexOf(node);

		while (iter.getNextNode() != position) {
			iter = this.list.get(iter.getNextNode());
		}

		iter.setNextNode(node.getNextNode());
		this.list.remove(node);
	}

	public int first() {
		Log.e(TAG, firstElement + "");
		return this.firstElement;
	}

	public int last() {
		Node iter = this.list.get(firstElement);
		while (iter.getNextNode() != null) {
			iter = this.list.get(iter.getNextNode());
		}
		return this.list.indexOf(iter);
	}

	public Integer before(Node node) {
		int positionOfNode = this.list.indexOf(node);

		if (positionOfNode == 0)
			return null;

		Node iter = this.list.get(firstElement);

		while (iter.getNextNode() != positionOfNode) {
			iter = this.list.get(iter.getNextNode());
		}
		return this.list.indexOf(iter);
	}

	public Integer after(Node node) {
		return node.getNextNode();
	}

	public Integer find(Node node) {
		return this.list.indexOf(node);
	}

	public void append(Node newNode) {
		this.list.add(newNode);
		Node lastNode = this.list.get(this.last());
		lastNode.setNextNode(this.list.indexOf(newNode));
	}

	public void insertFirst(Node node) {
		node.setNextNode(firstElement);
		this.list.add(node);
		this.firstElement = this.list.indexOf(node);

	}

}
