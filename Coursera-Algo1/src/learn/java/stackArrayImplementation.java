package learn.java;

class Stacks{
	private int top;
	private int[] stackArray; 

	Stacks(int size){
		stackArray = new int[size];	
		top = -1;
	}
	
	public void push(int num){
		stackArray[++top] = num;
	}
	
	public int pop(){
		if(top == -1){
			System.out.println("Empty Stack");
			return 0;
		}
		else{
			return stackArray[top--];
		}
	}
	
	public boolean isEmpty(int[] stack){
		if(top == -1)
			return true;
		else
			return false;
	}
	
	public void printStack(){
		if(!isEmpty(stackArray)){
			for(int i=0; i <= top; ++i){
				System.out.println(stackArray[i]);
			}
		}
		else
			System.out.println("Empty Stack");
	}
}

public class stackArrayImplementation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//stack1.arraySize = 4;
		Stacks stack1 = new Stacks(4);
		Stacks stack2 = new Stacks(5);
		//stack1.printStack(stack1);
		stack1.push(10);
		stack1.push(20);
		stack1.push(30);
		stack1.printStack();
		//stack2.printStack(stack2);
		stack2.printStack();
	}
}
