package learn.java.main;

import learn.java.datastructure._linkedList;

public class _main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_linkedList._insertNode("Shrawan");
		_linkedList._insertNode("Somya");
		_linkedList._insertNode("Divya");
		_linkedList._displayNode(_linkedList.headNode);
		//_linkedList._deleteNode("Divya");
		//_linkedList._displayNode(_linkedList.headNode);
		_linkedList.headNode = _linkedList._reverse(_linkedList.headNode);
		_linkedList._displayNode(_linkedList.headNode);
		_linkedList._reverseNodeRec(_linkedList.headNode);
		_linkedList._displayNode(_linkedList.headNode);
	}

}
