package com.hotpads.trinary;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotpads.TinaryTree.TrinaryNode;
import com.hotpads.TinaryTree.TrinaryTree;

import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class HotpadsTrinaryTreeTest {

	@Injectable
	Logger mockedLogger;

	@Before
	public void setUp() {
		new MockUp<LoggerFactory>() {
			@Mock
			Logger getLogger(Class clazz) {
				return mockedLogger;
			}
		};

	}

	@Test
	public void testInsertEmptyTree() {
		final String expectedTreeAsString = "#";
		TrinaryNode root = null;
		String res = TinaryTreeTestHelper.printTree(root);
		assertEquals(res, expectedTreeAsString);
	}

	@Test
	public void testInsertTree() {
		final String expectedTreeAsString = "5,4,5,9,2,#,#,#,#,#,7,#,#,#,2,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#";

		TrinaryNode root = buildTestTree();
		String res = TinaryTreeTestHelper.printTree(root);

		assertEquals(res, expectedTreeAsString);
	}

	@Test
	public void testDeleteTreeRootNode() {
		final String expectedTreeAsString = "5,4,#,9,2,#,#,#,#,#,7,#,#,#,2,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#";

		TrinaryNode root = buildTestTree();
		root = TrinaryTree.delete(root, 5);
		String res = TinaryTreeTestHelper.printTree(root);
		assertEquals(res, expectedTreeAsString);
	}

	@Test
	public void testDeleteNotLeafNode1() {
		final String expectedTreeAsString = "5,2,5,9,#,2,#,#,#,#,7,#,#";

		TrinaryNode root = buildTestTree();
		root = TrinaryTree.delete(root, 4);
		String res = TinaryTreeTestHelper.printTree(root);
		assertEquals(res, expectedTreeAsString);
	}

	@Test
	public void testDeleteNotLeafNode2() {
		final String expectedTreeAsString = "5,4,5,9,2,#,#,#,#,#,7,#,#";

		TrinaryNode root = buildTestTree();
		root = TrinaryTree.delete(root, 2);
		String res = TinaryTreeTestHelper.printTree(root);
		assertEquals(res, expectedTreeAsString);
	}

	@Test
	public void testDeleteLeafNode() {
		final String expectedTreeAsString = "5,4,5,9,2,#,#,#,#,#,7,#,#";

		TrinaryNode root = buildTestTree2();
		root = TrinaryTree.delete(root, 3);
		String res = TinaryTreeTestHelper.printTree(root);
		assertEquals(res, expectedTreeAsString);
	}

	public TrinaryNode buildTestTree() {
		TrinaryNode root = null;
		root = TrinaryTree.insert(root, 5);
		root = TrinaryTree.insert(root, 4);
		root = TrinaryTree.insert(root, 9);
		root = TrinaryTree.insert(root, 5);
		root = TrinaryTree.insert(root, 7);
		root = TrinaryTree.insert(root, 2);
		root = TrinaryTree.insert(root, 2);
		return root;
	}

	public TrinaryNode buildTestTree2() {
		TrinaryNode root = null;
		root = TrinaryTree.insert(root, 5);
		root = TrinaryTree.insert(root, 4);
		root = TrinaryTree.insert(root, 9);
		root = TrinaryTree.insert(root, 5);
		root = TrinaryTree.insert(root, 7);
		root = TrinaryTree.insert(root, 2);
		root = TrinaryTree.insert(root, 3);
		return root;
	}
}
