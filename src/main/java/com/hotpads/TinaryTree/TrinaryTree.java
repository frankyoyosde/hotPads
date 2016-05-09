package com.hotpads.TinaryTree;

import java.io.IOException;

public class TrinaryTree {

	private TrinaryNode root;

	public void TrinaryNode() {
		this.root = null;
	}

	public void TrinaryTreeNode(TrinaryNode root) {
		this.root = root;
	}

	public TrinaryNode getRoot() {
		return root;
	}

	public void setRoot(TrinaryNode root) {
		this.root = root;
	}

	public static TrinaryNode insert(TrinaryNode root, int val) {
		if (root == null) {
			root = new TrinaryNode(val);
		} else if (root.val == val) {
			root.middle = insert(root.middle, val);
		} else if (root.val > val) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}

	public static TrinaryNode delete(TrinaryNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.val == val) {
			if (root.middle != null) {
				root.middle.left = root.left;
				root.middle.right = root.right;
				root = root.middle;
			} else if (root.left == null && root.right == null) {
				root = null;
			} else if (root.left != null && root.right == null) {
				root = root.left;
			} else if (root.left == null && root.right != null) {
				root = root.right;
			} else { // middle==null && left!=null && right!=null
				TrinaryNode rightMost = root.left;
				while (rightMost.right != null) {
					rightMost = rightMost.right;
				}
				root.val = rightMost.val;
				root.middle = rightMost.middle;
				rightMost.middle = null;
				root.left = delete(root.left, rightMost.val);
			}
		} else if (root.val > val) {
			root.left = delete(root.left, val);
		} else {
			root.right = delete(root.right, val);
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		TrinaryNode root = null;
		root = TrinaryTree.insert(root, 5);
		root = TrinaryTree.insert(root, 4);
		root = TrinaryTree.insert(root, 9);
		root = TrinaryTree.insert(root, 5);
		root = TrinaryTree.insert(root, 7);
		root = TrinaryTree.insert(root, 2);
		root = TrinaryTree.insert(root, 2);
		//TrinaryTree.printTree(root);
	}

	/*public static void printTree(TrinaryNode root) {
		if (root != null) {
			System.out.println(root.val);
			printTree(root.left);
			printTree(root.middle);
			printTree(root.right);

		}
	}*/
}
