public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisor;

    public GraduateStudent(String name, String address, String topic, String supervisorName) {
        super(name, address);
        researchTopic = topic;
        supervisor = supervisorName;
    }

    public String getResearchTopic(){
        return this.researchTopic;
    }

    public String getSupervisor(){
        return this.supervisor;
    }

}
