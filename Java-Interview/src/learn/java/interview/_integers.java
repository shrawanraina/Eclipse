package learn.java.interview;

public class _integers {
	public static void _reverseInt(int input) {
		// TODO Auto-generated method stub
		boolean flag = true;
		int output = 0;
		int temp;
		if(input < 0){
			temp = Math.abs(input);
			flag = false;
		}
		else
			temp = input;
			while(temp > 0){
				int rem = temp % 10;
				output = output * 10 + rem;
				temp = temp / 10;
		}
		if(!flag)
			output = -output;
		//System.out.println(Math.abs(input) % 10);
		System.out.println(output);
	}
}
