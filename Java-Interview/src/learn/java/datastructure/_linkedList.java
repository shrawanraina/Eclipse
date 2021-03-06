package learn.java.datastructure;

class list {
	private int score;
	private list next;
	
	list(){
		next = null;
		score = 0;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public list getNext(){
		return next;
	}
	
	public void setNext(list next){
		this.next = next;
	}
	
}

class node {
	private String name;
	private node next;
	
	node(){
		name = "";
		next = null;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public node getNext(){
		return next;
	}
	
	public void setNext(node next){
		this.next = next;
	}
	
}

public class _linkedList {
	public static node headNode;
	
	public static list _insertList(list head, int data){
		list obj = new list();
		obj.setScore(data);
		obj.setNext(head);
		head = obj;
		return head;
	}
	
	public static void _insertNode(String name){
		node obj = new node();
		obj.setName(name);
		obj.setNext(headNode);
		headNode = obj;
	}
	
	public static void _deleteNode(String name){
		node curr = headNode;
		node prev = null;
		while(curr.getName() != name){
			prev = curr;
			curr = curr.getNext();
		}
		prev.setNext(curr.getNext());
	}
	
	public static void _displayNode(node obj){
		while(obj != null){
			System.out.println(obj.getName() + "\t");
			obj = obj.getNext();
		}
		System.out.println();
	}
	
	public static void _displayList(list obj){
		while(obj != null){
			System.out.print(obj.getScore() + "\t");
			obj = obj.getNext();
		}
		System.out.println();
	}
	
	public static void _reverseNodeRec(node obj){
		if(obj.getNext() == null){
			headNode = obj;
			return;
		}
		_reverseNodeRec(obj.getNext());
		node temp = obj.getNext();
		temp.setNext(obj);
		obj.setNext(null);
	}
	
	public static node _reverse(node obj){
		node cur, prev, next;
		prev = null;
		cur = headNode;
		while(cur != null){
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	public static list _sumLinkedList(list num1, list num2) {
		// TODO Auto-generated method stub
		list result = null;
		int sum;
		boolean flag = false;
		
		while(num1 != null || num2 != null){
			if(num1 != null && num2 !=null){
				System.out.println(num1.getScore());
				System.out.println(num2.getScore());
				
				if(flag)
					sum = num1.getScore() + num2.getScore() + 1;
				else
					sum = num1.getScore() + num2.getScore();
				if(sum >= 10)
					flag = true;
				else
					flag = false;
				result = _insertList(result, sum % 10);
				num1 = num1.getNext();
				num2 = num2.getNext();
			}
			else if(num1 != null){
				if(flag){
					sum = num1.getScore() + 1;
					if(sum >= 10)
						flag = true;
					else
						flag = false;
				}
				else{
					sum = num1.getScore();
					flag = false;
				}
				result = _insertList(result, sum % 10);
				num1 = num1.getNext();
			}
			else if(num2 != null){
				if(flag){
					sum = num2.getScore() + 1;
					if(sum >= 10)
						flag = true;
					else
						flag = false;
				}
				else{
					sum = num2.getScore();
					flag = false;
				}
				result = _insertList(result, sum % 10);
				num2 = num2.getNext();
			}
		}
		if(num1 == null && num2 == null && flag){
			result = _insertList(result, 1);
		}
		return result;
	}
	
	public static void _concatenateList(list obj){
		list cur;
		boolean isSeq = false;
		while(obj.getNext() != null){
			cur = obj;
			while(obj.getScore() + 1 == obj.getNext().getScore()){
				isSeq = true;
				obj = obj.getNext();
			}
			if(isSeq){
				isSeq = false;
				System.out.println(cur.getScore()+"-"+obj.getScore());
				if(obj.getNext() != null){
					obj = obj.getNext();
				}
			}
			else{
				System.out.println(obj.getScore());
				obj = obj.getNext();
			}
		}
	}
}
