package learn.java.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class tree{
	private int data;
	tree left; 
	tree right;
	
	tree(){
		this.left = null;
		this.right = null;
	}
	
	tree(int x){
		this.data = x;
		this.left = null;
		this.right = null;
	}
	
	public int getData(){
		return this.data;
		
	}
	
	public void setData(int data){
		this.data = data;
	}
}

public class _bst1 {
	public static tree root = null;
	
	public static tree _insert(tree node, int x) {
		// TODO Auto-generated method stub
		if(node == null){
			node = new tree(x);
			//System.out.println("r: "+node.getData());
			//System.out.println("r: "+node.left);
			//System.out.println("r: "+node.right);
			return node;
		}
		else if(x <= node.getData()){
			node.left = _insert(node.left, x);
			//System.out.println("l: "+node.left.getData());
			//System.out.println("l: "+node.left.left);
			//System.out.println("l: "+node.left.right);
		}
		else {
			node.right = _insert(node.right, x);
			//System.out.println("rt: "+node.right.getData());
			//System.out.println("rt: "+node.right.left);
			//System.out.println("rt: "+node.right.right);
		}
		return node;
	}
	
	public static tree _minVal(tree right) {
		// TODO Auto-generated method stub
		tree current = right;
		while(current.left != null){
			current = current.left;
		}
		return current;
	}
	
	public static tree _delete(tree root, int key) {
		// TODO Auto-generated method stub
		if(root == null)
			return root;
		if(key < root.getData()){
			root.left = _delete(root.left, key);
		}
		else if (key > root.getData()){
			root.right = _delete(root.right, key);
		}
		else{
			if(root.left == null){
				tree temp = root.right;
				root = null;
				return temp;
			}
			else if(root.right == null){
				tree temp = root.left;
				root = null;
				return temp;
			}
			tree temp = _minVal(root.right);
			//System.out.println(temp.getData());
			root.setData(temp.getData());
			root.right = _delete(root.right, temp.getData());
		}
		return root;
	}
	
	public static void _inOrder(tree root){
		if(root != null){
			_inOrder(root.left);
			System.out.print(root.getData() + "\t");
			_inOrder(root.right);	
		}
	}
	
	public static void _preOrder(tree root){
		if(root == null)
			return;
		System.out.print(root.getData() + "\t");
		_preOrder(root.left);
		_preOrder(root.right);	
	}
	
	public static void _postOrder(tree root){
		if(root != null){
			_postOrder(root.left);
			_postOrder(root.right);
			System.out.print(root.getData() + "\t");
		}
	}
	
	public static boolean _isSubTree(tree root, tree root3) {
		// TODO Auto-generated method stub
		if(root3 == null)
			return true;
		if(root == null)
			return false;
		if(_checkIdentical(root,root3))
			return true;
		return _isSubTree(root.left,root3) || _isSubTree(root.right, root3);
	}

	public static boolean _checkIdentical(tree root, tree root3) {
		// TODO Auto-generated method stub
		if(root == null && root3 == null)
			return true;
		if(root == null || root3 == null)
			return false;
		return (
				root.getData() == root3.getData() &&
				_checkIdentical(root.left,root3.left) &&
				_checkIdentical(root.right,root3.right));
	}
	
	public static tree _findLSA(tree root, int i, int j) {
		// TODO Auto-generated method stub
		if(root == null)
			return null;
		if(root.getData() > i && root.getData() > j)
			return _findLSA(root.left, i, j);
		if(root.getData() < i && root.getData() < j)
			return _findLSA(root.right, i, j);
		return root;
	}
	
	public static tree _arrayToTreeStack(List<Integer> result) {
		// TODO Auto-generated method stub
		Stack<tree> stack = new Stack<tree>();
		tree root = new tree(result.get(0));
		stack.push(root);
		tree temp;
		for(int i=1; i<result.size(); ++i){
			temp = null;
			while(!stack.isEmpty() && result.get(i) > stack.peek().getData())
				temp = stack.pop();
			if(temp != null){
				temp.right = new tree(result.get(i));
				stack.push(temp.right);
			}
			else{
				stack.peek().left = new tree(result.get(i));
				stack.push(stack.peek().left);
			}
		}
		return root;
	}

	private static int index;
	public static tree _arrayListToTree(List<Integer> treeArr, int min, int max) {
		// TODO Auto-generated method stub
		if(index >= treeArr.size())
			return null;
		tree root = null;
		int current = treeArr.get(index);
		//System.out.println("ind: "+index);
		//System.out.println("len: "+treeArr.size());
		//System.out.println("cur: "+current);
		if(current > min && current < max){
			root = new tree(current);
			//System.out.println("data: "+root.getData());
			index++;
			if(index < treeArr.size()){
				root.left = _arrayListToTree(treeArr, min, current);
			}
			if(index < treeArr.size()){
				root.right = _arrayListToTree(treeArr, current, max);
			}
		}
		return root;
	}

	public static List<Integer> _treeToArrayList(tree node) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		result.add(node.getData());
		if(node.left != null)
			result.addAll(_treeToArrayList(node.left));
		if(node.right != null)
			result.addAll(_treeToArrayList(node.right));
		return result;
	}
	
}
