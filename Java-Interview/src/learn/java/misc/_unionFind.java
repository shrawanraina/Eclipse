package learn.java.misc;

public class _unionFind {
	
	private int[] id;
	private int[] size;
	public _unionFind(int n){
		id = new int[n];
		size = new int[n];
		for(int i=0; i<n; i++){
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int rootQU(int i){
		while(i != id[i]){
			i = id[i];
		}
		return i;
	}
	
	private int rootQUPC(int i){
		while(i != id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	public void unionQU(int p, int q){
		int pid = rootQU(p);
		int qid = rootQU(q);
		id[pid] = qid;
	}
	
	public void unionWQU(int p, int q){
		int pid = rootQU(p);
		int qid = rootQU(q);
		if(pid == qid){
			return;
		}
		if(size[pid] < size[qid]){
			id[pid] = qid;
			size[qid] += size[pid];
		}
		else{
			id[qid] = pid;
			size[pid] += size[qid];
		}
	}
	
	public boolean findQU(int p, int q){
		return rootQU(p) == rootQU(q);
	}
	
	public void unionQF(int p, int q){
		int pid = id[p];
		int qid = id[q];
		for(int i=0; i<id.length; i++){
			if(id[i] == pid)
				id[i] = qid;
		}
	}
	
	public boolean findQF(int p, int q){
		return id[p] == id[q];
	}
	
	public void print(){
		for(int i=0; i<id.length; i++){
			System.out.print(id[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_unionFind obj = new _unionFind(10);
//Ex-1,Q-1
		obj.unionQF(9, 1);
		obj.unionQF(8, 0);
		obj.unionQF(6, 1);
		obj.unionQF(4, 0);
		obj.unionQF(6, 0);
		obj.unionQF(1, 7);
//		
/*Ex-1,Q-2
		obj.unionWQU(3, 7);
		obj.unionWQU(3, 0);
		obj.unionWQU(5, 2);
		obj.unionWQU(8, 7);
		obj.unionWQU(1, 9);
		obj.unionWQU(2, 1);
		obj.unionWQU(8, 9);
		obj.unionWQU(6, 1);
		obj.unionWQU(1, 4);
*/
		obj.print();
	}
}
