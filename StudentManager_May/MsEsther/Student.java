
public class Student 
{
    // Class field
    private String name;
    private int studentID;
    private double mark;

    // Constructor with parameter
    public Student(int pStudentID, String pName, double pMark)
    {
        name = pName;
        studentID = pStudentID;
        mark = pMark;
    }

    // Copy Constructor
    public Student(Student pStudent)
    {
        name = pStudent.getName();
        studentID = pStudent.getStudentID();
        mark = pStudent.getMark();
    }

    // Default Constructor
    public Student ()
    {
        name = "James";
        studentID = 70008229;
        mark = 87.0;
    }

    // getters
    public String getName()
    {
        return this.name;
    }

    public int getStudentID()
    {
        return this.studentID;
    }

    public double getMark()
    {
        return this.mark;
    }

    // setters
    public void setName(String pName)
    {
        if(!pName.trim().isEmpty() || pName!=null)
        {
            this.name = pName;
        }
    }

    public void setStudentID(int pStudentID)
    {
        if(pStudentID >=10000000 && pStudentID <=99999999 )
        {
            this.studentID = pStudentID;
        }
    }

    public void setMark(double pMark)
    {
        if(pMark >= 0.0  && pMark <=100.0)
        {
            this.mark = pMark;
        }
    }

    @Override
    public String toString()
    {
        String theString;
        theString = this.name + ":" + this.studentID + " with mark " + this.mark;
        return theString;
    }
    
    @Override
    public boolean equals(Object inObject)
    {
        boolean isEqual = false;
        Student inStudent = null;

        if(inObject instanceof Student)
        {
            inStudent = (Student) inObject;
            if(this.name == inStudent.getName())
            {
                if(this.studentID == inStudent.getStudentID())
                {
                    if(this.mark == inStudent.getMark())
                    {
                        isEqual = true;
                    }
                }
            }
        }
        return isEqual;
    }


    // getGrade method
    public String getGrade()
    {
        
        String grade;
        if(this.mark >= 80 && this.mark<=100)
        {
            grade = "HD";
        }
        else if(this.mark >= 70 && this.mark<=80)
        {
            grade = "D";
        }
        else if(this.mark >= 60 && this.mark<=70)
        {
            grade = "C";
        }
        else if(this.mark >= 50 && this.mark<=60)
        {
            grade = "P";
        }
        
        else
        {
            grade = "F";
        }
        
        return grade;
    }

    public String toFileString()
    {
        String fileString;
        fileString = name + "," + studentID + "," + mark;
        return fileString;
    }

    

}

