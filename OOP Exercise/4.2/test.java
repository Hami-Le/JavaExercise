
public class test {
	public static void main(String[] args) {
        Person person = new Person("John Doe", "123 Main St");
        Student student = new Student("Alice", "456 School Rd", "Computer Science", 2024, 15000.0);
        Staff staff = new Staff("Bob", "789 Office Ln", "XYZ School", 50000.0);

        System.out.println(person);
        System.out.println(student);
        System.out.println(staff);
    }
}
