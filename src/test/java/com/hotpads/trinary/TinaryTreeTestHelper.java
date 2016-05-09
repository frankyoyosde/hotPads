package com.hotpads.trinary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hotpads.TinaryTree.TrinaryNode;

public class TinaryTreeTestHelper {

	public static List<List<String>> levelOrder(TrinaryNode root) {
		List<List<String>> res = new ArrayList<List<String>>();
		final String EMPTY_NODE = "#";
		if (root == null) {
			List<String> list = new ArrayList<>();
			list.add(EMPTY_NODE);
			res.add(list);
			return res;
		}
		Queue<TrinaryNode> q = new LinkedList<TrinaryNode>();
		q.add(root);
		List<String> list = new ArrayList<>();
		boolean levelHasValue = true;
		while (!q.isEmpty() && levelHasValue) {
			Queue<TrinaryNode> temp = new LinkedList<TrinaryNode>();
			list = new ArrayList<>();
			levelHasValue = false;
			while (!q.isEmpty()) {
				TrinaryNode current = q.poll();
				if (current == null) {
					list.add(EMPTY_NODE);
				} else {
					list.add(String.valueOf(current.getVal()));
				}

				if (current != null && current.getLeft() != null) {
					levelHasValue = true;
					temp.add(current.getLeft());
				} else {
					temp.add(null);
				}
				if (current != null && current.getMiddle() != null) {
					levelHasValue = true;
					temp.add(current.getMiddle());
				} else {
					temp.add(null);
				}
				if (current != null && current.getRight() != null) {
					levelHasValue = true;
					temp.add(current.getRight());
				} else {
					temp.add(null);
				}
			}
			res.add(list);
			q = temp;
		}
		return res;
	}

	public static String printTree(TrinaryNode root) {
		List<List<String>> treeLevels = levelOrder(root);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < treeLevels.size(); i++) {
			List<String> level = treeLevels.get(i);
			sb.append(String.join(",", level));
			if (i != treeLevels.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
}
