package learn.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class binaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(5);
		_insertBST(root,3);
		_insertBST(root,7);
		_insertBST(root,4);
		_insertBST(root,2);
		_insertBST(root,6);
		_insertBST(root,8);
		//_levelOrderTraverseArr(root);
		_levelOrderTraverse(root);
		//System.out.println(_searchBST(4,root).value);
		_levelOrderTraverse(root);
		//System.out.println(_isBST(root));
		//_inOrder(root);
		//_preOrder(root);
		//_postOrder(root);
//		List<Integer> arr = new ArrayList<Integer>();
//		arr = traversePreRecursive(root);
//		System.out.println(arr);
//		System.out.println(searchBST(8,root));
	}
	
	public static List<Integer> traversePreRecursive(Node node) {
	    if (node == null) return new ArrayList<Integer>();

	    List<Integer> nodeValues = new ArrayList<Integer>();
	    //nodeValues.add(node.getValue());
	    nodeValues.addAll(traversePreRecursive(node.getLeft()));
	    nodeValues.add(node.getValue());
	    nodeValues.addAll(traversePreRecursive(node.getRight()));

	    return nodeValues;
	}
	
	public static void _levelOrderTraverseArr(Node node){
		if(node == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		q.add(node);
		while(!q.isEmpty()){
			Node temp = q.element();
			arr.add(temp.value);
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
			q.remove();
		}
		System.out.println(arr);
	}
	public static void _levelOrderTraverse(Node node){
		if(node == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		//ArrayList<Integer> arr = new ArrayList<Integer>();
		q.add(node);
		while(!q.isEmpty()){
			Node temp = q.element();
			System.out.println(temp.value);
			//arr.add(temp.value);
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
			q.remove();
		}
		//System.out.println(arr);
	}
	static class Node {
	    Node left;
	    Node right;
	    int value;
	 
	    public Node() {
	    	System.out.println("Empty Node");
		}
	    
	    public Node(int value) {
	      this.value = value;
	    }
	    
	    public Node getLeft(){
	    	return left;
	    }
	    
	    public Node getRight(){
	    	return right;
	    }
	    
	    public int getValue(){
	    	return value;
	    }
	  }
	
	public static void _inOrder(Node node){
		if(node != null){
			_inOrder(node.left);
			System.out.println(node.value);
			_inOrder(node.right);
		}
	}
	
	public static void _preOrder(Node node){
		if(node != null){
			System.out.println(node.value);
			_preOrder(node.left);
			_preOrder(node.right);
		}
	}
	
	public static void _postOrder(Node node){
		if(node != null){
			_postOrder(node.left);
			_postOrder(node.right);
			System.out.println(node.value);
		}
	}
	
	public static void _insertBST(Node node, int value) {
	    if (value < node.value) {
	      if (node.left != null) {
	        _insertBST(node.left, value);
	      } else {
//	        System.out.println("  Inserted " + value + " to left of "+ node.value);
	        node.left = new Node(value);
	      }
	    } else if (value > node.value) {
	      if (node.right != null) {
	        _insertBST(node.right, value);
	      } else {
//	        System.out.println("  Inserted " + value + " to right of "+ node.value);
	        node.right = new Node(value);
	      }
	    }
	 }
	
	public static Node _searchBST(int key,Node root){
		if(root == null){
			return null;
		}
		if(key == root.value){
			return root;
		}
		else if (key < root.value)
			return _searchBST(key,root.left);
		else if (key > root.value)
			return _searchBST(key,root.right);
		else
			System.out.println("Not Found");
			return null;
	}
	
	public static Node _deleteBST(Node root, int value){
		if(root == null)
			return root;
		else if(value < root.value)
			root.left = _deleteBST(root.left, value);
		else if(value > root.value)
			root.right = _deleteBST(root.right, value);
		else{
			//No child
			if(root.left == null && root.right == null){
				root = null;
			}
			//1 child
			else if(root.left == null){
				root = root.right;
			}
			else if(root.right == null){
				root = root.left;
			}
			//2 children
			else{
				Node temp = _findMin(root.right);
				root.value = temp.value;
				root.right = _deleteBST(root.right, temp.value);
			}
		}
		return root;
	}
	
	private static Node _findMin(Node root) {
		// TODO Auto-generated method stub
		while(root != null)
			root = root.left;
		return root;
	}

	public static boolean _isBST(Node root){
		if(root == null)
			return true;
		if(_isLeftLesser(root.left, root.value) && _isRightGreater(root.right, root.value)
				&& _isBST(root.left) && _isBST(root.right))
			return true;
		else
			return false;
	}
	public static boolean _isLeftLesser(Node root, int value){
		if(root == null)
			return true;
		if((root.value <= value) && _isLeftLesser(root.left, value) && _isLeftLesser(root.right, value))
			return true;
		else 
			return false;
	}
	public static boolean _isRightGreater(Node root, int value){
		if(root == null)
			return true;
		if((root.value >= value) && _isRightGreater(root.left, value) && _isRightGreater(root.right, value))
			return true;
		else 
			return false;
	}
}