import java.util.ArrayList;

public class College {
    private ArrayList<Student> listStudents;
    private static int highestStudentNum = 0;

    /**
     * Public Constructor
     */
    public College() {
        listStudents = new ArrayList<Student>();
    };


    /**
     * Adds a Student object to the arraylist listStudents
     * @param student is the Student object being passed in
     */
    public void addStudent(Student student) {
        listStudents.add(student);
        if(highestStudentNum < student.getStudentNum()) //set highest student number if current student has highest
            highestStudentNum = student.getStudentNum();
    }


    /**
     * Method to remove a Student from the listStudents arraylist
     * @param number is the unique student number of a Student object.
     */
    public void removeStudent(int number){
        if(listStudents.size()<1)
            System.out.println("No students to remove! Please add some students to the college.");
        for(Student s:listStudents) {
            if(s.getStudentNum() == number) {
                System.out.println("Removing " + s.getName());
                listStudents.remove(s);
            }
        }
    }


    /**
     * Method to retrieve a Student from listStudents using their unique student number as a reference
     * @param number is the student number for referring against
     */
    public Student lookupWithNumber(int number) {
        String result = "No such student";
        for(Student s: this.listStudents) {
            if(s.getStudentNum() == number)
                result = s.toString();
                System.out.println(result);
                return s;
        }
        System.out.println(result);
        return null;
    }


    /**
     * Method to retrieve Student object from listStudents using their unique student number as a reference point
     * @param number is the student number used to find the Student
     * @return a Student object, student, if found. Otherwise return null.
     */
    public Student getStudent(int number) {
        Student student = null;
        for(Student s: this.listStudents) {
            if(s.getStudentNum() == number)
                student = s;
                return student;
        }
        System.out.println("No student found.");
        return student;
    }

    /**
     * Method to get the highest recorded student number of all Students in listStudents
     * @return an integer, highestStudentNum, which is updated upon adding a new Student to reflect the current highest recorded student number in the array list.
     */
    public int getHighestStudentNum() {
        return highestStudentNum;
    }

    /**
     * Method to obtain loginID of an existing Student in the college
     * @param number is the student's unique student number
     * @return the loginID as a string, otherwise returns the string "No such student"
     */
    public String getLogin(int number) {
        for(Student s: this.listStudents)
            if(s.getStudentNum() == number) {
                return s.getLoginId();
            }
        return "No such student";
    }


    /**
     * Method to check the GPA's of all Students in listStudents and find the student with the highest one.
     * @return the Student with the highest GPA.
     */
    public Student highestGPA() {
        double GPACheck = 0.0;
        Student highestGPAKid = null;
        for(Student s: this.listStudents) {
            if (s.calculateGPA() > GPACheck) {
                GPACheck = s.calculateGPA();
                highestGPAKid = s;
            }
        } return highestGPAKid;
    }

    @Override
    public String toString() {
        return "College " + listStudents.toString();
    }

}