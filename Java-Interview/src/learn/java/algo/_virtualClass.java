package learn.java.algo;

public class _virtualClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal();
		Cat cat = new Cat();
		//animal.eat();
		//cat.eat();
		func(animal);
		func(cat);
	}	
	static void func(Animal abc){
		abc.eat();
	}
}

class Animal {
	public void eat(){
		System.out.println("Animal Class");
	}
}

class Cat extends Animal{
	public void eat(){
		System.out.println("Cat Class");
	}
}
