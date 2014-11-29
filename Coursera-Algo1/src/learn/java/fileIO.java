package learn.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//System.out.print("Enter input: ");
				//Scanner scan = new Scanner(System.in);
				//String input = scan.nextLine();
				File file = new File("file IO/test.txt");
		/*		try {
					PrintWriter output = new PrintWriter(file);
					output.println("Shrawan");
					output.println("UMD");
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.printf("Error: %s", e);
				}*/
				//System.out.println(input);
				try {
					Scanner input1 = new Scanner(file);
					String line1 = input1.nextLine();
					String line2 = input1.nextLine();
					System.out.println(line1+" "+line2);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
