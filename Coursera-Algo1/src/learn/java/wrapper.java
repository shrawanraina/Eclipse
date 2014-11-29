package learn.java;

import java.util.ArrayList;
import java.util.List;

public class wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> x = new ArrayList<String>();
		x.add("5");
		x.add("6");
		System.out.println(x);
		List<String> y = new Overloading().addStuff(x);
		System.out.println(y);
		new Overloading().addStuff(x);
		System.out.println(x);
		float i = Float.parseFloat("10");
		System.out.println(i);
		Integer a = Integer.valueOf("20");
		System.out.println(a);
	}

}
