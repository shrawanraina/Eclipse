package learn.java.algo;

public class _enum {
	_enum v;
	int size;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int h1 = test1.months.dwarves.getheight();
//		System.out.println(h1);
		_enum v1 = new _enum();
		final _enum v2;
		v2 = v1.getsize(v1);
		v2.v.size = 7;
		System.out.println(v2.size);
		System.out.println(v2.v.size);
	}
	_enum getsize(_enum v3){
		v3.size = 5;
		v3.v = new _enum();
		return v3;
	}
	
	
}
class test1{
	enum months{
		hobbit(1), elves(2), dwarves(3);
		int height;
		months(int h){
			height = h;
		}
		int getheight(){
			return height;
		}
		
	}
	
}
