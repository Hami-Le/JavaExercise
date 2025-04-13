public class Class {

    static void forName(String commysqlcjjdbcDriver) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    private String classID;
    private String description;
    private int numberOfCredits;

    public Class(String classID, String description, int numberOfCredits) {
        this.classID = classID;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
    }

    public String getClassID() { return classID; }
    public String getDescription() { return description; }
    public int getNumberOfCredits() { return numberOfCredits; }
}