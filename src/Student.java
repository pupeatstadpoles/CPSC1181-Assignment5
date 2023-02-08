/*
Name: Pup Abdulgapul
Class: CPSC1181-003
Professor: Hengameh Hamavand
Program: Student.java
Purpose: Creates a class, Student, with methods, constructors and instanced variables that are invoked in testStudent.java. Each Student object stores the student's name, address and their unique student number, can store and tally grade points and credits for courses taken, calculate the student's GPA and retrieve their login ID
 */

public class Student {
    private String name;
    private String address;
    private double credits;
    private double gradePoints;

    private static final double tuitionFee = 107.62;

    private static int nextStudentNum = 10000;
    private int studentNum = 0;


    /**
     * Public constructor
     * @param name
     * @param address
     */
    public Student(String name, String address) {
        this.name = name.trim();
        this.address = address.trim();
        nextStudentNum += 1;
        studentNum = nextStudentNum;
        credits = 0.0;
        gradePoints = 0.0;
    }

    /**
     * Retrieves student's name
     *
     * @return the student's full name as a string
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves student's address
     *
     * @return the student's address as a string
     */
    public String getAddress() {
        return address;
    }


    /**
     * Adds a course's grade points and its credits to the student's total
     *
     * @param gradePoints is the number of grade points earned in that course
     * @param credits     is the number of the credits that course is worth
     */
    public void addCourse(double gradePoints, double credits) {
        this.gradePoints += gradePoints * credits;
        this.credits += credits;
    }


    /**
     * Calculates GPA of the student using student's grade points and credits
     *
     * @return result as gradePoints/credits rounded to 2 decimal places
     */
    public double calculateGPA() {

        if (credits == 0)
            return 0;
        else {
            double GPA = gradePoints / credits;
            GPA = (double) Math.round(GPA * 100) / 100;
            return GPA;
        }
    }

    /**
     * Retrieve's student's unique student number
     *
     * @return student number
     */
    public int getStudentNum() {
        return studentNum;
    }

    /**
     * Retrieves student's loginID, which is computed as the first letter of the first name + up to 3 letters of the last name + last 2 digits of the student number
     *
     * @return loginID as a string.
     */
    public String getLoginId() {
        String id = "";
        String lastName = "";
        int startLastName = 0;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ' && name.charAt(i + 1) != ' ') {
                startLastName = i + 1;
                break;
            }
        }

        lastName = name.substring(startLastName);
        if (lastName.length() > 3) //if last name is longer than 3 characters, take only first 3 characters
            lastName = name.substring(startLastName, startLastName + 3);
        id = name.charAt(0) + lastName; //first initial + up to 3 initials of last name
        id = id.toLowerCase(); //converting to lowercase
        int stuNum = studentNum % 100;
        if (stuNum < 10) {
            id = id + '0' + stuNum; //if last 2 digits contain a 0 eg. 01, 03, 04, need to add the 0 back in
        } else {
            id = id + stuNum;
        }
        return id;
    }


    /**
     * Getter method for total credits
     * @return credits as double
     */
    public double getCredits() {
        return credits;
    }


    /**
     * Getter method for tuition fees based on total credits taken.
     * @return tuition fees as double.
     */
    public double getTuitionFees() {
        return (double) Math.round((tuitionFee * credits) * 100) / 100;
    }


    /**
     * Checks if object is a Student, then checks if name and address are the same.
     * @param s Object being passed through, may not be a Student object
     * @return true if they are the same Student
     */
    @Override
    public boolean equals(Object s) {
        if (s == null) {
            return false;
        }
        if (getClass() == s.getClass()) { //only if the classes are the same
            Student student = (Student) s;
            return equals(s);
        }

        return false;
    }

    public boolean equals(Student student) {
        return ((this.name.equals(student.name)) && (this.address.equals(student.address)));

    }

    @Override
    public String toString() {
        return "\n[" + getClass().getName() + ", name: " + getName() + ", address: " + getAddress() + ", student number: " + getStudentNum() + "]";
    }


}
