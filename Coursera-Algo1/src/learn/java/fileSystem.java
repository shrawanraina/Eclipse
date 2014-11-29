package learn.java;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class fileSystem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double gpa;
	
	public fileSystem(String getName, double getgpa){
		this.name = getName;
		this.gpa = getgpa;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getgpa(){
		return this.gpa;
	}
	
	public static void main (String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("file IO/student.txt");
		ArrayList<fileSystem> students = new ArrayList<fileSystem>();
		students.add(new fileSystem("Shrawan",3.92));
		students.add(new fileSystem("Chintan",4.00));
		students.add(new fileSystem("Tanvi",3.95));
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream output = new ObjectOutputStream(fo);
		for(fileSystem s: students){
			output.writeObject(s);
		}
		output.close();
		fo.close();
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream input = new ObjectInputStream(fi);
		ArrayList<fileSystem> students2 = new ArrayList<fileSystem>();
		try{
			while(true){
				fileSystem s = (fileSystem) input.readObject();
				students2.add(s);
			}
		}
		catch (EOFException ex){
		}
		for(fileSystem s: students2){
			System.out.println(s);
		}
		//System.out.println(students2);
	}
}