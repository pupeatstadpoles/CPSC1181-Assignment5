/**
 * Name: Pup Abdulgapul
 * Course: CPSC 1181-003
 * Professor: Hengameh Hamavand
 * Program: CollegeTester
 * Purpose: For testing the College class, demonstrating array lists, exceptions, and use of multiple classes.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class CollegeTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean restart = true;
        int command = 0;
        College squart = new College();

        //Adding example students
        Student s1 = new Student("Plip Plop", "Where @ What Street");
        s1.addCourse(4,3);
        squart.addStudent(s1);

        Student s2 = new Student("Tip Top", "Langara College");
        s2.addCourse(4,4);
        s2.addCourse(3,4);
        squart.addStudent(s2);


        do {
            System.out.println("\nRead the following menu of commands and enter in the number of the command you want to execute.\n\n1. Add a new student to the college.\n2. Lookup a student in the college using their student number.\n3. Deleting a student from the college using their student number. \n4. Add the grade points and credits for a course to a certain student \n5. Get a student's login ID. \n6. Find which student has the highest GPA. \n7. Terminate program.");
            System.out.println("");
            try {
                command = input.nextInt();
            } catch (InputMismatchException exception) { //if the input is not an int...................
                exception.printStackTrace();
            }
            switch (command) {
                case (1): //Adding new student to college's arraylist
                    addStudentCollege(squart);
                    break;
                case (2): //Looking up a student from college's arraylist
                    lookup(input, squart);
                    break;
                case (3): //Removing a student from college's arraylist
                    removal(input, squart);
                    break;
                case (4): //Adding a course's grade points and credits to a student in the college
                    addCourse(input, squart);
                    break;
                case (5): //Retrieving a student's loginID
                    loginID(input, squart);
                    break;
                case (6): //Finding the student with the highest GPA in the college
                    Student s = squart.highestGPA();
                    System.out.println(s.toString());
                    break;
                case (7) :
                    restart = false;
                    break;
                default:
                    throw new InputMismatchException("Invalid command. Must enter a number from 1-7.");
            }
        } while (restart);
    }


    /**
     * Method to check if a string meets the requirements for having a valid student name. String must contain 2 words separated by a space.
     * @param name is the string being passed in for validation.
     * @return false if does not contain 2 words separated by space, otherwise return true.
     */
    public static boolean validStudentName(String name) {
        if (name.length() > 2) {
            int lastNameStart = 0;
            lastNameStart = name.indexOf(' ');
            if (lastNameStart < name.length() && lastNameStart != -1) //check that there's actually another name in the string
                return true;
        }
        System.out.println("Invalid student name. Student name should be 2 names separated by a space.");
        return false;
    }


    /**
     * Method to validate integer passed in as a valid student number of the college.
     * Student number must be 8 digits, be above 10000000 and below or equal to the College's recorded highestStudentNum.
     * @param number  is an integer being passed through.
     * @param college is an arraylist of Students. Uses college's getter method to find the highest possible student number.
     * @return true if number has 8 digits and is between 10000000 and the college's highestStudentNum, otherwise false.
     */
    public static boolean validStudentNumber(int number, College college) {
        if ((number < 10000000) || (number > college.getHighestStudentNum())) {
            System.out.println("Invalid student number. Student not found.");
            return false;
        }
        return true;

    }


    /**
     * Method to check loginID of a certain student in the college.
     * Obtains user inputted string that is checked to see if in range of student numbers issued out.
     * @param input   is a Scanner connected to the system.
     * @param college is an arraylist of Students.
     */
    public static void loginID(Scanner input, College college) {
        int sNumber = 0;
        String loginID = "";
        boolean validNum = false;
        System.out.println("What is the student number of the student?");
        try {
            sNumber = input.nextInt();
            validNum = validStudentNumber(sNumber, college);
            if (validNum) {
                loginID = college.getLogin(sNumber);
                System.out.println("Their login id is " + loginID);
            }
        } catch (InputMismatchException e) {
            System.out.println("Integers only please.");
        }
    }


    /**
     * Method to lookup a student's records in the college using a given student number.
     * @param input is a Scanner attached to the system.
     * @param college is an arraylist of Students.
     */
    public static void lookup(Scanner input, College college) {
        int sNumber = 0;
        boolean validNum = false;
        Student s;
        System.out.println("What is the student number you want to lookup?");
        try {
            sNumber = input.nextInt();
            validNum = validStudentNumber(sNumber, college);
            if (validNum) {
                college.lookupWithNumber(sNumber);
            }
        } catch (InputMismatchException e) {
            System.out.println("Integers only please.");
        }
    }


    /**
     * Method to add credits and grade points for a course to a student's recorded total credits/total grade points.
     * @param input is a Scanner attached to the system.
     * @param college is an arraylist of Students.
     */
    public static void addCourse(Scanner input, College college) {
        int sNumber = 0;
        boolean validNum = false;
        System.out.println("Please enter in the student number for the student whose courses you wish to add.");
        try {
            sNumber = input.nextInt();
            validNum = validStudentNumber(sNumber, college);
            if (validNum) {
                Student student = college.getStudent(sNumber);
                System.out.println("What are the student's grade points?");
                double gradePoints = input.nextDouble();
                System.out.println("How many credits was the course?");
                double credits = input.nextInt();
                student.addCourse(gradePoints, credits);
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong format of numbers.");
        }
    }


    /**
     * Method to remove a Student from a College.
     * @param input is a Scanner attached to the system.
     * @param college is an arraylist of Students.
     */
    public static void removal(Scanner input, College college) {
        int sNumber = 0;
        boolean validNum = false;
        System.out.println("Please enter the student number of the student you wish to remove.");
        try {
            sNumber = input.nextInt();
            validNum = validStudentNumber(sNumber, college);
            if (validNum) {
                college.removeStudent(sNumber);
            }
        } catch (InputMismatchException e) {
            System.out.println("Integers only please.");
        }
    }


    /**
     * Method to add a Student to an existing College.
     * @param college is an arraylist of Students.
     */
    public static void addStudentCollege(College college) {
        String sName = "", sAddress = "", sCountry = "", sResearchTopic = "", sSupervisorName = "";
        Scanner input = new Scanner(System.in);
        int studentTypeSelection = 0;
        boolean valid = false;

        System.out.println("");
        System.out.println("Please enter the name of the student you want to add in the format [Firstname Lastname]");
        System.out.println("");
        sName = input.nextLine();
        sName = sName.trim();
        valid = validStudentName(sName);
        if (valid) {
            System.out.println("Please enter the address of the student you want to add to the college.");
            sAddress = input.nextLine();
        }
        try {
            System.out.println("What type of student do you want to add? Please enter the corresponding number:\n[1] Enter 1 for a regular student.\n[2] Enter 2 for an International Student\n[3]Enter 3 for a Graduate Student.");
            System.out.println("");
            studentTypeSelection = input.nextInt();
        }
        catch (InputMismatchException e1) {
            System.out.println("You can only enter a number from 1 to 3!\nTerminating procedure - no student added.\n\n");
        }


        switch (studentTypeSelection) {
            case (1):
                System.out.println("Adding a Student named " + sName + " with address " + sAddress);
                Student newStudent = new Student(sName, sAddress);
                college.addStudent(newStudent);
                break;
            case (2):
                System.out.println("Which country is this International Student from?");
                System.out.println();
                sCountry = input.nextLine();
                System.out.println("Adding an International Student with the name " + sName + " and address " + sAddress + " from the country " + sCountry);
                InternationalStudent newInternationalStudent = new InternationalStudent(sName, sAddress, sCountry);
                college.addStudent(newInternationalStudent);
                break;
            case (3):
                System.out.println("What is this Graduate Student's research topic?");
                System.out.println();
                sResearchTopic = input.nextLine();
                System.out.println("What is their Supervisor's name?");
                System.out.println();
                sSupervisorName = input.nextLine();
                System.out.println("Adding a Graduate Student with the name " + sName + " and address " + sAddress + ". Their research topic is " + sResearchTopic + " and their supervisor is " + sSupervisorName);
                break;
            default:
                System.out.println("Invalid selection! You can only choose a command from [1] to [3].\nTerminating procedure: Add student.");
        }
    }


}
