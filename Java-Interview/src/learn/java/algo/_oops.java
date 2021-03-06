package learn.java.algo;

public class _oops {
	static class parent{
		parent(){
			System.out.println("You are in parent");
		}
		
		void dummy(){
			System.out.println("Parent dummy");
		}
	}
	
	static class child extends parent{
		child(){
			super.dummy();
			System.out.println("You are in child");
		}
		
		@Override
		void dummy(){
			System.out.println("Child dummy");
		}
	}
	
	static class child2 extends parent{
		child2(){
			System.out.println("You are in child2");
		}
		
		@Override
		void dummy(){
			System.out.println("Child2 dummy");
		}
	}
}
