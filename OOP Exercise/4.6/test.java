
public class test {
	public static void main(String[] args) {
	     Animal animal = new Animal("Generic Animal");
	     System.out.println(animal);

	     Mammal mammal = new Mammal("Mammal");
	     System.out.println(mammal);

	     Cat cat = new Cat("Kitty");
	     System.out.println(cat);
	     cat.greets();

	     Dog dog1 = new Dog("Buddy");
	     System.out.println(dog1);
	     dog1.greets();

	     Dog dog2 = new Dog("Max");
	     dog1.greets(dog2);
	 }
}
