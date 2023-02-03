public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisor;

    public GraduateStudent(String name, String address, String topic, String supervisorName) {
        super(name, address);
        researchTopic = topic;
        supervisor = supervisorName;
    }

}
