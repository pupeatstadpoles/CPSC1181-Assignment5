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

    @Override
    public boolean equals(Object graduateStudent){
        if(super.equals(graduateStudent)) {
            GraduateStudent grad = (GraduateStudent) graduateStudent;
            return equals(grad);
            }
        return false;
    }


    public boolean equals(GraduateStudent graduateStudent) {
        return ((this.supervisor.equals(graduateStudent.getSupervisor())) && (this.researchTopic.equals(graduateStudent.getResearchTopic())));
    }
}
