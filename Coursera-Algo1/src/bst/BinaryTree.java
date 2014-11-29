package bst;

public class BinaryTree {
	public static void main(String[] args){
		bst root = new bst(50);
		insert(root,20);
		insert(root,5);
		insert(root,10);
		//inOrder(root);
		preOrder(root);
	}
	
	public static void insert(bst root, int data){
		if(data >= root.data){
			if(root.right != null)
				insert(root.right,data);
			else
				root.right = new bst(data);
		}
		else{
			if(root.left != null)
				insert(root.left,data);
			else
				root.left = new bst(data);
		}
	}
	
	public static void inOrder(bst root){
		if(root != null){
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	
	public static void preOrder(bst root){
		if(root != null){
			System.out.println(root.data);
			inOrder(root.left);
			inOrder(root.right);
		}
	}
	static class bst{
	    bst left;
	    bst right;
	    int data;
	 
	    public bst(){
	    	System.out.println("Empty Node");
		}
	    public bst(int value){
	      this.data = value;
	    }
	    public bst getLeft(){
	    	return left;
	    }
	    public bst getRight(){
	    	return right;
	    }
	    public int getValue(){
	    	return data;
	    }
    }
	
	
	
}
