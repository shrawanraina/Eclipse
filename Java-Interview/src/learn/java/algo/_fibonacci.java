package learn.java.algo;

public class _fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//_fibonacci obj = new _fibonacci();
		for (int i = 0; i < 6; i++) {
			System.out.print(_fibonacci._fibonacciR(i) + " ");
		}
	}

	public static int _fibonacciR(int n) {
		/*
		 * if(n==0) return 0; if(n==1) return 1;
		 */
		if (n < 2)
			return 1;
		else if (n > 1)
			return _fibonacciR(n - 1) + _fibonacciR(n - 2);
		else
			return -1;
	}

	public static int _fibonacciArray(int n) {
		// List<Integer> fibTable = new ArrayList<Integer>();
		int[] fibTable = new int[46];
		if (n == 0) {
			return fibTable[0] = 1;
		}
		if (n == 1) {
			return fibTable[1] = 1;
		} else if (n > 1) {
			if (fibTable[n] != 0) {
				return fibTable[n];
			}
			return fibTable[n] = _fibonacciArray(n - 1)
					+ _fibonacciArray(n - 2);
		} else
			return -1;
	}

	public static void _fibonacciI(int n) {
		int a = 1;
		int b = 0;
		for (int i = 0; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
			System.out.print(b + " ");
		}
	}
}
