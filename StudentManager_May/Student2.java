// Foo and Jun Xiang
public class Student2{
    private String name;
    private int studentID;
    private double mark;

// Default constructor
    public Student2() {
        this.name = "Unknown";
        this.studentID = 10000000;
        this.mark = 0.0;
    }

// Parameter constructor
public Student2(String name, int studentID, double mark) {
        setName(name);
        setStudentID(studentID);
        setMark(mark);
    }

// Copy constructor
    public Student2(Student2 other) {
        this.name = other.getName();
        this.studentID = other.getStudentID();
        this.mark = other.getMark();
    }

    // mutator set student ID
    public void setStudentID(int id) {
        if (id >= 700000000 && id <= 700099999) {
            this.studentID = id;
        }
    }

    // mutator set student name
    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }
    }

    // mutator set student mark
    public void setMark(double mark) {
        if (mark >= 0 && mark <= 100) {
            this.mark = mark;
        }
    }

    // Accessor for name
    public String getName() {
        return this.name;
    }

    // Accessor for studentID
    public int getStudentID() {
        return this.studentID;
    }

    // Accessor for mark
    public double getMark() {
        return this.mark;
    }

    // Returns the grade corresponding to the mark
    public String getGrade() {
        if (mark >= 80.0) {
            return "HD";
        } else if (mark >= 70.0) {
            return "D";
        } else if (mark >= 60.0) {
            return "C";
        } else if (mark >= 50.0) {
            return "P";
        } else {
            return "F";
        }
    }

    public String toFileString() {
        return name + "," + studentID + "," + mark;
    }

public String toString() {
        return name + " (" + studentID + ") scored " + mark + "%";
    }

    public boolean equals (Object student) {
        return this.studentID == this.studentID &&
           this.name.equals(this.name) &&
           this.mark == this.mark;
    }
}