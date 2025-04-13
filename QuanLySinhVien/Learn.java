public class Learn {
    private int learnID;
    private String studentID;
    private String classID;

    public Learn(int learnID, String studentID, String classID) {
        this.learnID = learnID;
        this.studentID = studentID;
        this.classID = classID;
    }

    public int getLearnID() { return learnID; }
    public String getStudentID() { return studentID; }
    public String getClassID() { return classID; }
}