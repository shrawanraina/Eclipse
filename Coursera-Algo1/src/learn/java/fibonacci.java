package learn.java;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fibonacci obj = new fibonacci();
		for(int i=0; i<6; i++){
			System.out.print(obj.Fibonacci(i)+" ");
		}
	}
	public int Fibonacci(int n){
		if(n == 0){
			return 0;
		}
		else if (n == 1){
			return 1;
		}
		return Fibonacci(n-1)+Fibonacci(n-2);
	}
}
