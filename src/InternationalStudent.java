public class InternationalStudent extends Student{
    private String country;
    private static final double internationalTuitionFee = 637.91;


    public InternationalStudent(String name, String address, String country) {
        super(name,address);
        this.country = country;
    }
}
