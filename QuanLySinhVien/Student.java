public class Student {
    private String studentID;
    private String name;
    private int age;
    private String email;

    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.email = generateEmail(name);
    }

    private String generateEmail(String fullName) {
        fullName = fullName.trim().toLowerCase();
        String[] parts = fullName.split(" ");
        String lastName = parts[parts.length - 1];
        StringBuilder initials = new StringBuilder();
        for (int i = 0; i < parts.length - 1; i++) {
            initials.append(parts[i].charAt(0));
        }
        return lastName + initials + "@vku.udn.vn";
    }

    public String getStudentID() { 
        return studentID; 
    }
    public void setStudentID(String studentID) { 
        this.studentID = studentID; 
    }

    public String getName() { 
        return name; 
    }
    public void setName(String name) {
        this.name = name;
        this.email = generateEmail(name); 
    }

    public int getAge() { 
        return age; 
    }
    public void setAge(int age) { 
        this.age = age; 
    }

    public String getEmail() { 
        return email; 
    }

    @Override
    public String toString() {
        return studentID + " | " + name + " | " + age + " | " + email;
    }
}
