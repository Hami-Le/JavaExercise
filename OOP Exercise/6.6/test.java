
public class test {
	public static void main(String[] args) {
        Animal cat = new Cat("Kitty");
        cat.greets(); 

        Dog dog1 = new Dog("Buddy");
        dog1.greets(); 

        Dog dog2 = new Dog("Charlie");
        dog1.greets(dog2); 

        BigDog bigDog1 = new BigDog("Max");
        bigDog1.greets(); 

        BigDog bigDog2 = new BigDog("Rocky");
        bigDog1.greets(bigDog2); 

        bigDog1.greets(dog1); 
    }
}
