package com.hotpads.TinaryTree;

public class TrinaryNode {
	int val;
	TrinaryNode left;
	TrinaryNode right;
	TrinaryNode middle;

	public TrinaryNode(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TrinaryNode getLeft() {
		return left;
	}

	public void setLeft(TrinaryNode left) {
		this.left = left;
	}

	public TrinaryNode getRight() {
		return right;
	}

	public void setRight(TrinaryNode right) {
		this.right = right;
	}

	public TrinaryNode getMiddle() {
		return middle;
	}

	public void setMiddle(TrinaryNode middle) {
		this.middle = middle;
	}

	public String toString() {
		return (this == null ? "#" : String.valueOf(this.val));

	}

}
