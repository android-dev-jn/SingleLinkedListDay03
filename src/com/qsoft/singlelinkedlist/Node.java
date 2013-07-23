package com.qsoft.singlelinkedlist;

public class Node {
	private String value;
	private Integer nextNode;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getNextNode() {
		return nextNode;
	}

	public void setNextNode(Integer nextNode) {
		this.nextNode = nextNode;
	}

	public Node(String value, Integer nextNode) {
		this.value = value;
		this.nextNode = nextNode;
	}

	public Node() {
		this.value = "";
		this.nextNode = null;
	}

}
