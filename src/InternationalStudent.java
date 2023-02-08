public class InternationalStudent extends Student{
    private String country;
    private static final double internationalTuitionFee = 637.91;


    public InternationalStudent(String name, String address, String country) {
        super(name,address);
        this.country = country;
    }

    public String getCountry(){
        return this.country;
    }



    @Override
    public double getTuitionFees() {
        return (this.getCredits()*internationalTuitionFee);
    }

    @Override
    public boolean equals(Object internationalStudent){
        if(super.equals(internationalStudent)) {
            InternationalStudent iStudent = (InternationalStudent) internationalStudent;
            return equals(iStudent);
        }
        return false;
    }

    public boolean equals(InternationalStudent internationalStudent) {
        return ((this.country.equals(internationalStudent.getCountry())));
    }
}
