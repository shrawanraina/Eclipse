package learn.java.datastructure;

class stack{
	private int val;
	private stack next;
	
	public int getVal(){
		return this.val;
	}
	
	public void setVal(int val){
		this.val = val;
	}
	
	public stack getNext(){
		return this.next;
	}
	
	public void setNext(stack next){
		this.next = next;
	}
}

public class _stack {
	static stack head = null;
	private static int [] stackA = new int[10];
	private static int top = -1;
	
	public static int _popLL() {
		// TODO Auto-generated method stub
		if(head == null)
			throw new UnsupportedOperationException("Stack Empty");
		int temp = head.getVal();
		head = head.getNext();
		return temp;
	}

	public static void _pushLL(int i) {
		// TODO Auto-generated method stub
		stack temp = new stack();
		temp.setVal(i);
		temp.setNext(head);
		head = temp;
		temp = null;
	}

	public void _push(int i) {
		// TODO Auto-generated method stub
		if(top == stackA.length - 1){
			throw new UnsupportedOperationException("Stack Full");
		}
		else
			stackA[++top] = i;
	}
	
	public int _pop() {
		// TODO Auto-generated method stub
		if(top == -1)
			throw new UnsupportedOperationException("Stack Empty");
		else
			return stackA[top--];
	}

	public int _top() {
		// TODO Auto-generated method stub
		return stackA[top];
		
	}

	public boolean _isEmpty() {
		// TODO Auto-generated method stub
		if(top == -1)
			return true;
		else
			return false;
	}
	
}
