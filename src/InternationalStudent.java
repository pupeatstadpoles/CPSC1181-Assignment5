public class InternationalStudent extends Student{
    private String country;

    //InternationalStudents have higher fees
    private static final double internationalTuitionFee = 637.91;


    /**
     * Public constructor
     * @param name is the name of the student
     * @param address their address
     * @param country their country of origin
     */
    public InternationalStudent(String name, String address, String country) {
        super(name,address);
        this.country = country;
    }


    /**
     * Getter method for retrieving the country of origin
     * @return country as String
     */
    public String getCountry(){
        return this.country;
    }


    /**
     * Getter method to retrieve tuition fees. Overriden to use the internationalTuitionFee instead
     * @return tuition fees as double
     */
    @Override
    public double getTuitionFees() {
        return (double) Math.round((this.getCredits()*internationalTuitionFee) * 100)/100;
    }


    /**
     * Checks if two InternationalStudents are the same
     * @param internationalStudent an Object passed in for checking. May not be of class InternationalStudent
     * @return true if same InternationalStudent
     */
    @Override
    public boolean equals(Object internationalStudent){
        if(super.equals(internationalStudent)) {
            InternationalStudent iStudent = (InternationalStudent) internationalStudent;
            return ((this.country.equals(iStudent.getCountry())));
        }
        return false;
    }



    /**
     * toString method
     * @return the Student.toString() then appends the country of origin
     */
    @Override
    public String toString(){
        return super.toString() + "[ Country: " + country + "]";
    }
}
