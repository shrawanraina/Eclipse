package learn.java;

public class Enum {
	Enum v;
	int size;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int h1 = test1.months.dwarves.getheight();
//		System.out.println(h1);
		Enum v1 = new Enum();
		final Enum v2;
		v2 = v1.getsize(v1);
		v2.v.size = 7;
		System.out.println(v2.size);
		System.out.println(v2.v.size);
	}
	Enum getsize(Enum v3){
		v3.size = 5;
		v3.v = new Enum();
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
